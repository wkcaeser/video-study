package com.videoStudy.controller;

import com.videoStudy.data.dao.LicenseMapper;
import com.videoStudy.data.dao.QuestionStudyLogMapper;
import com.videoStudy.data.model.License;
import com.videoStudy.data.model.PayDetail;
import com.videoStudy.data.model.QuestionStudyLog;
import com.videoStudy.data.model.Users;
import com.videoStudy.data.reponse.Status;
import com.videoStudy.service.OrderService;
import com.videoStudy.service.StudyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    private final OrderService orderService;
    private final StudyLogService studyLogService;
    private final LicenseMapper licenseMapper;
    private final QuestionStudyLogMapper questionStudyLogMapper;

    @Autowired
    public StudentController(OrderService orderService, StudyLogService studyLogService, LicenseMapper licenseMapper, QuestionStudyLogMapper questionStudyLogMapper) {
        this.orderService = orderService;
        this.studyLogService = studyLogService;
        this.licenseMapper = licenseMapper;
        this.questionStudyLogMapper = questionStudyLogMapper;
    }

    @RequestMapping(value = "/getStudentInfo", method = RequestMethod.GET)
    @ResponseBody
    public Users getStudentInfo(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        return users;
    }

    //购买课程
    @RequestMapping(value = "/buyClass", method = RequestMethod.POST)
    @ResponseBody
    public Status buyClass(int classId, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        return new Status(orderService.addNewOrder(classId, users.getId()));
    }

    //获取订单信息
    @RequestMapping(value = "/getPayedClass", method = RequestMethod.GET)
    @ResponseBody
    public List<PayDetail> getPayedClassList(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        return orderService.getUserOrderList(users.getId());
    }

    //跳转学习界面
    @RequestMapping(value = "/studyPage", method = RequestMethod.GET)
    public String getStudyPage(int classId, HttpServletRequest request, Model model){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        if(users == null)
            return "redirect:/";
        Integer answer = studyLogService.getQuestionStudyTimeCount(users.getId());
        int time = 0;
        if(answer != null)
            time = answer;
        model.addAttribute("time", time==0?0:String.format("%.2f", (double)time/45));
        return "studyPage";
    }

    //获取学习时长
    @RequestMapping(value = "/getQuestionStudyTime", method = RequestMethod.GET)
    @ResponseBody
    public Status getQuestionStudyTime(int qid, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        Integer answer = studyLogService.getQuestionStudyTime(users.getId(),qid);
        int time = 0;
        if(answer != null)
            time = answer;
        String rep = String.format("%.2f",time==0?0:(double)time/45);
        return new Status(rep);
    }

    //增加学习时长
    @RequestMapping(value = "/setNewStudyTime", method = RequestMethod.POST)
    @ResponseBody
    public Status setNewStudyTime(int time, HttpServletRequest request){
        int qid = (int) request.getSession().getAttribute("qid");
        Users users = (Users) request.getSession().getAttribute("userInfo");
        int st = studyLogService.addQuestionStudyTimeLog(qid, users.getId(), time);
        if(st > 0)
            return new Status("SUCCESS");
        else
            return new Status("ERROR");
    }

    //检查学习时长是够符合证书条件
    @RequestMapping(value = "/checkTimeEnough", method = RequestMethod.POST)
    @ResponseBody
    public Status checkTimeEnough(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        Integer time = studyLogService.getQuestionStudyTimeCount(users.getId());
        if(time != null && time/45>40){
            License license = licenseMapper.selectByUid(users.getId());
            if(license != null)
                return new Status("WARNING");
            return new Status("SUCCESS");
        }else {
            return new Status("ERROR");
        }
    }

    //获取课程学习状态
    @RequestMapping(value = "/getQuestionStudyStatus", method = RequestMethod.GET)
    @ResponseBody
    public Status getQuestionStudyStatus(int qid, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        QuestionStudyLog questionStudyLog = questionStudyLogMapper.selectByQidAndUid(qid, users.getId());
        if(questionStudyLog != null){
            return new Status("SUCCESS");
        }else {
            return new Status("ERROR");
        }
    }
}
