package com.videoStudy.controller;

import com.videoStudy.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    private final AuthorityService authorityService;

    @Autowired
    public IndexController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    //首页跳转
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("title", "test page");
        model.addAttribute("message", "this is test page");
        return "index";
    }

    //错误页面跳转
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(){
        return "error";
    }

    //页面头部获取
    @RequestMapping(value = "/getToolBar", method = RequestMethod.GET)
    public String getToolBar(){
        return "tool/toolbar";
    }

    //登陆页面获取
    @RequestMapping(value = "/getLoginPage", method = RequestMethod.GET)
    public String getLoginPage(){
        return "tool/login";
    }
    //页面底部获取
    @RequestMapping(value = "/getFooter", method = RequestMethod.GET)
    public String getFooter(){
        return "tool/footer";
    }
    //注册页面获取
    @RequestMapping(value = "/getRegister", method = RequestMethod.GET)
    public String getRegister(){
        return "tool/register";
    }

    //管理员界面获取--------------test
    @RequestMapping(value = "/getManagerPage", method = RequestMethod.GET)
    public String getManagerPage(HttpServletRequest request){
        String st = authorityService.checkAuthority(request, 5);
        if(!("SUCCESS".equals(st)))
            return "redirect:/";
        return "manager";
    }

    //用户类型申请界面
    @RequestMapping(value = "/getRegisterKind", method = RequestMethod.GET)
    public String getRegisterKind(){
        return "tool/registerKind";
    }

    //视频管理界面
    @RequestMapping(value = "/videoEdit", method = RequestMethod.GET)
    public String getVideoEditPage(HttpServletRequest request){
        String st = authorityService.checkAuthority(request, 5);
        if(!("SUCCESS".equals(st)))
            return "redirect:/";
        return "videoEdit";
    }

    //修改密码界面
    @RequestMapping(value = "/getPasswordPage", method = RequestMethod.GET)
    public String getPasswordPage(){
        return "passwordPage";
    }

    //试题页面获取
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String getQuestionPage(){
        return "question";
    }
}
