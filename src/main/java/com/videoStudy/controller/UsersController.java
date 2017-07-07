package com.videoStudy.controller;

import com.videoStudy.data.model.Users;
import com.videoStudy.data.reponse.Status;
import com.videoStudy.data.reponse.ValidateCode;
import com.videoStudy.service.UserService;
import com.videoStudy.service.ValidateCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    //登陆
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Status login(String username, String password, String validateCode, HttpServletRequest request){
        if(request.getSession().getAttribute("code").equals(validateCode.toLowerCase())){
            return new Status("ERROR");
        }
        if(username == null || password == null)
            return new Status("ERROR");
        if(username.trim().equals("") || password.trim().equals(""))
            return new Status("ERROR");
        return new Status(userService.checkUsernameAndPassword(username.trim(), password.trim()));
    }

    //注册用户名检测
    @RequestMapping(value = "/checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public Status checkUsername(String username){
        return new Status(userService.checkUsername(username));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Status register(Users users){
        return new Status(userService.addUser(users));
    }
}
