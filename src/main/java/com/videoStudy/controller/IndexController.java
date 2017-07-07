package com.videoStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("title", "test page");
        model.addAttribute("message", "this is test page");
        return "index";
    }

    @RequestMapping(value = "/getToolBar", method = RequestMethod.GET)
    public String getToolBar(){
        return "tool/toolbar";
    }

    @RequestMapping(value = "/getLoginPage", method = RequestMethod.GET)
    public String getLoginPage(){
        return "tool/login";
    }
    @RequestMapping(value = "getFooter", method = RequestMethod.GET)
    public String getFooter(){
        return "tool/footer";
    }

    @RequestMapping(value = "getRegister", method = RequestMethod.GET)
    public String getRegister(){
        return "tool/register";
    }
}
