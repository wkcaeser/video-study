package com.videoStudy.controller;

import com.videoStudy.data.model.ClassList;
import com.videoStudy.data.model.Question;
import com.videoStudy.data.model.QuestionInfo;
import com.videoStudy.data.model.Users;
import com.videoStudy.data.reponse.Status;
import com.videoStudy.service.ClassListService;
import com.videoStudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClassController {
    private final ClassListService classListService;
    private final EmployeeService employeeService;

    @Autowired
    public ClassController(ClassListService classListService, EmployeeService employeeService) {
        this.classListService = classListService;
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/getClassList", method = RequestMethod.GET)
    @ResponseBody
    public List<ClassList> getClassList(){
        return classListService.getClassList();
    }

    @RequestMapping(value = "/getQuestionInfoList", method = RequestMethod.GET)
    @ResponseBody
    public List<QuestionInfo> getQuestionInfoList(){
        return classListService.getQuestionInfoList();
    }

    //获取题库学习界面
    @RequestMapping(value = "/StudyQuestion/{qid}", method = RequestMethod.GET)
    public String getStudyQuestionPage(@PathVariable("qid") int qid, Model model, HttpServletRequest request){
        model.addAttribute("qid", qid);
        request.getSession().setAttribute("qid", qid);
        return "lawPages/lawPage" + qid;
    }

    //添加学习记录
    @RequestMapping(value ="/addQuestionStudyLog", method = RequestMethod.POST)
    @ResponseBody
    public Status addQuestionStudyLog(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        int qid = (int) request.getSession().getAttribute("kind");
        int st = employeeService.addQuestionStudyLog(qid, users.getId());
        if(st>0)
            return new Status("SUCCESS");
        else
            return new Status("ERROR");
    }
}
