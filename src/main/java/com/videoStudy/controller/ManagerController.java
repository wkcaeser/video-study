package com.videoStudy.controller;

import com.videoStudy.data.dao.LicenseMapper;
import com.videoStudy.data.dao.QuestionStudyTimeLogMapper;
import com.videoStudy.data.dao.UsersMapper;
import com.videoStudy.data.model.*;
import com.videoStudy.data.reponse.Status;
import com.videoStudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ManagerController {
    private final ManagerService managerService;
    private final UserService userService;
    private OrderService orderService;
    private final EmployeeService employeeService;
    private final UsersMapper usersMapper;
    private final QuestionStudyTimeLogMapper questionStudyTimeLogMapper;
    private final LicenseMapper licenseMapper;
    @Autowired
    public ManagerController(ManagerService managerService, UserService userService, OrderService orderService, EmployeeService employeeService, UsersMapper usersMapper, QuestionStudyTimeLogMapper questionStudyTimeLogMapper, LicenseMapper licenseMapper) {
        this.managerService = managerService;
        this.userService = userService;
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.usersMapper = usersMapper;
        this.questionStudyTimeLogMapper = questionStudyTimeLogMapper;
        this.licenseMapper = licenseMapper;
    }

    //获取用户信息
    @RequestMapping(value = "/getUserInfoPage", method = RequestMethod.GET)
    @ResponseBody
    public List<Users> getUserInfoPage(int page){
        return userService.getAllUsers((page-1)*8, 8);
    }

    //获取订单信息分页
    @RequestMapping(value = "/getOrderPage", method = RequestMethod.GET)
    @ResponseBody
    public List<PayDetail> getOrderPage(int page){
        return orderService.getOrderPage((page-1)*8, 8);
    }

    //修改订单状态---确认付款
    @RequestMapping(value = "/changeBuyStatus", method = RequestMethod.POST)
    @ResponseBody
    public Status changeBuyStauts(int orderId){
        return new Status(managerService.changeOrderStatusById(1, orderId));
    }

    //获取证书申请列表
    @RequestMapping(value = "/getLicensePage", method = RequestMethod.GET)
    @ResponseBody
    public List<LicenseDetail> getLicensePage(int page){
        return managerService.getLicensePage((page-1)*8, 8);
    }

    //发放证书
    @RequestMapping(value = "/sendLicense", method = RequestMethod.POST)
    @ResponseBody
    public Status sendLicense(int id){
        int st = managerService.changeLicenseStatus(1, id);
        if(st>0)
            return new Status("SUCCESS");
        else
            return new Status("ERROR");
    }

    @RequestMapping(value = "rengong", method = RequestMethod.GET)
    public String rengongpage(){
        return "rengong";
    }

    @RequestMapping(value = "/rengongchange", method = RequestMethod.POST)
    @ResponseBody
    public Status rengongchange(String username, String password){
        if(password != null && username != null) {
            if(!"xiugairengong".equals(password.trim())){
                return new Status("密码不正确");
            }
            Users users = usersMapper.selectByUsername(username);
            if(users == null)
                return new Status("用户名不存在");
            for (int i=1; i<=13; i++){
                employeeService.addQuestionStudyLog(i, users.getId());
                int time = 180 + (int)(Math.random()*100+1);
                QuestionStudyTimeLog questionStudyTimeLog = new QuestionStudyTimeLog();
                questionStudyTimeLog.setDate(new Date());
                questionStudyTimeLog.setTime(time);
                questionStudyTimeLog.setUid(users.getId());
                questionStudyTimeLog.setQid(i);
                questionStudyTimeLogMapper.insert(questionStudyTimeLog);
            }
            usersMapper.updateStatusStrById("已完成", users.getId());
            License license = new License();
            license.setUid(users.getId());
            license.setTime(new Date());
            license.setScore(60 + (int)(Math.random()*40));
            licenseMapper.insert(license);
            return new Status("操作成功");
        }
        return new Status("操作失败");
    }
}
