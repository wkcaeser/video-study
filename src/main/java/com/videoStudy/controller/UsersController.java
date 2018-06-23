package com.videoStudy.controller;

import com.videoStudy.data.model.Users;
import com.videoStudy.data.reponse.Status;
import com.videoStudy.data.reponse.UserInformation;
import com.videoStudy.data.reponse.ValidateCode;
import com.videoStudy.service.UserService;
import com.videoStudy.service.ValidateCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class UsersController {
    private final UserService userService;
    private final ValidateCodeFactory validateCodeFactory;

    @Autowired
    public UsersController(UserService userService, ValidateCodeFactory validateCodeFactory) {
        this.userService = userService;
        this.validateCodeFactory = validateCodeFactory;
    }

    //获取验证码
    @RequestMapping(value = "validateCode", method = RequestMethod.POST)
    public void getValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode validateCode = validateCodeFactory.getValidateCode();
        //将图片流转化为图片
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        validateCode.write(outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        outputStream.close();
        //将字节数组转化为base64编码string
        String imageBase64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageBytes);
        //验证码存入session
        request.getSession().setAttribute("code", validateCode.getCode().toLowerCase());
        validateCodeFactory.refresh();
        response.getWriter().write(imageBase64);
    }

    //验证验证码是否正确
    @RequestMapping(value = "checkValidateCode", method = RequestMethod.GET)
    @ResponseBody
    public Status checkValidateCode(String code, HttpServletRequest request){
        String validateCode = (String) request.getSession().getAttribute("code");
        if(validateCode == null)
            return new Status("ERROR");
        if(validateCode.equals(code.toLowerCase()))
            return new Status("SUCCESS");
        return new Status("ERROR");
    }

    //登录
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Status login(String username, String password, String validateCode, HttpServletRequest request){
        if(!((String)request.getSession().getAttribute("code")).equals(validateCode.toLowerCase())){
            return new Status("ERROR");
        }
        if(username == null || password == null)
            return new Status("ERROR");
        if(username.trim().equals("") || password.trim().equals(""))
            return new Status("ERROR");
       Users users = userService.checkUsernameAndPassword(username.trim(), password.trim());
       users.setPassword("");
       if(users != null){
           request.getSession().setAttribute("userInfo", users);
           int userStatus = users.getRole();
           return new Status("" + userStatus);
       }else {
           return new Status("ERROR");
       }
    }

    //注册用户名检测
    @RequestMapping(value = "/checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public Status checkUsername(String username){
        return new Status(userService.checkUsername(username));
    }

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Status register(Users users){
        return new Status(userService.addUser(users));
    }

    //获取用户信息
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserInformation getUserInfo(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        UserInformation userInformation = new UserInformation();
        if(userInformation == null){
            userInformation.setStatus("ERROR");
            return userInformation;
        }
        userInformation.setStatus("SUCCESS");
        userInformation.setUsers(users);
        return userInformation;
    }

    //根据用户权限跳转相应界面
    @RequestMapping(value = "/getUserPage", method = RequestMethod.GET)
    public String getUserPageByRole(HttpServletRequest request, Model model){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        if(users == null) {
            //用户未登陆跳转到登陆页面
            return "index";
        }
        model.addAttribute("user",users);
        int role = users.getRole();
        if(role == 5) {
            //管理员权限role为5
            return "manager";
        }
        if(role == 2){
            //单位账号权限为2
            return "companyConsole";
        }
        if(role == 1 || role == 3){
            //员工权限为1或者3
            return "employeePage";
        }
        if(role == 0) {
//            return "tool/registerKind";
            return "employeePage";
        }
        return "index";
    }

    //修改密码
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(String username, String identityNumber, String password, String passwordRepeat, Model model){
        if(username == null || username.trim().equals("")){
            model.addAttribute("passwordMessage", "用户名不能为空");
            return "passwordPage";
        }
        if(identityNumber == null || identityNumber.trim().equals("")){
            model.addAttribute("passwordMessage", "身份证不能为空");
            return "passwordPage";
        }
        if(password == null || password.trim().equals("") || passwordRepeat == null || passwordRepeat.trim().equals("")){
            model.addAttribute("passwordMessage", "新密码不能为空或两次密码输入不一致");
            return "passwordPage";
        }
        Users users = userService.getUserByUsername(username);
        if(users == null){
            model.addAttribute("passwordMessage","用户名不存在");
            return "passwordPage";
        }
        if(!(identityNumber.equals(users.getIdentityNumber()))){
            model.addAttribute("passwordMessage","身份证信息错误");
            return "passwordPage";
        }
        int st = userService.setPassword(password, users.getId());
        if(st > 0)
            model.addAttribute("passwordMessage","修改密码成功");
        else
            model.addAttribute("passwordMessage","修改密码失败");
        return "passwordPage";
    }
}
