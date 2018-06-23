package com.videoStudy.controller;

import com.videoStudy.data.dao.LicenseMapper;
import com.videoStudy.data.dao.ScoreMapper;
import com.videoStudy.data.dao.UsersMapper;
import com.videoStudy.data.model.*;
import com.videoStudy.data.reponse.Status;
import com.videoStudy.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final ScoreMapper scoreMapper;
    private final UsersMapper usersMapper;
    private final LicenseMapper licenseMapper;

    @Autowired
    public QuestionController(QuestionService questionService, UsersMapper usersMapper, ScoreMapper scoreMapper, LicenseMapper licenseMapper) {
        this.questionService = questionService;
        this.usersMapper = usersMapper;
        this.scoreMapper = scoreMapper;
        this.licenseMapper = licenseMapper;
    }

    @RequestMapping(value = "/addQuestionPage", method = RequestMethod.GET)
    public String addQuestionPage(){
        return "addQuestionPage";
    }

    //添加试题
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuestion(HttpServletRequest request, String description, String answerA, String answerB, String answerC, String answerD, String answer, int parent) throws IOException {
        String path = request.getServletContext().getRealPath("/static/question/");
        File file = new File(path + parent + ".sql");
        String sql = "INSERT INTO Question(description, answerA, answerB, answerC, answerD, answer, parent)" +
                "VALUES('" + description + "'," +
                " '" + answerA + "'," +
                " '" + answerB + "'," +
                " '" + answerC + "'," +
                " '" + answerD + "'," +
                " '" + answer + "', " + parent + ");\n";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
        bufferedOutputStream.write(sql.getBytes("utf8"));
        bufferedOutputStream.close();
        return "addQuestionPage";
    }

    //获取试题
    @RequestMapping(value = "/getQuestionList", method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQuestionList(){
        return questionService.getQuestionListByQid(1);
    }

    //检查答案 若及格  发放证书
    @RequestMapping(value = "/checkAnswer", method = RequestMethod.POST)
    @ResponseBody
    public Status checkAnswer(@RequestBody List<Answer> answerList, HttpServletRequest request) {
        int score = questionService.sumScore(answerList);
        Users users = (Users) request.getSession().getAttribute("userInfo");
        Score newScore  = new Score();
        newScore.setDate(new Date());
        newScore.setUid(users.getId());
        newScore.setScore(score);
        scoreMapper.insert(newScore);
        if (score > 60) {
            usersMapper.updateStatusStrById("已完成", users.getId());
            License license = new License();
            license.setUid(users.getId());
            license.setTime(new Date());
            license.setScore(score);
            licenseMapper.insert(license);
            return new Status("SUCCESS");
        } else {
            return new Status("ERROR");
        }
    }

    //获取试题练习页面
    @RequestMapping(value = "/exerciseQuestion", method = RequestMethod.GET)
    public String exerciseQuestion(int qid, Model model, HttpServletRequest request){
        QuestionInfo questionInfo = questionService.getQuestionInfo(qid);
        model.addAttribute("kind", questionInfo.getDescription());
        request.getSession().setAttribute("kind", qid);
        return "questionPractice";
    }
    //获取分类试题
    @RequestMapping(value = "/getQuestionListOfKind", method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQuestionListOfKind(HttpServletRequest request){
        return questionService.getQuestionListByQid((int)request.getSession().getAttribute("kind"));
    }

    //获取考试试题
    @RequestMapping(value = "/getQuestionListOfExam", method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQuestionListOfExam(){
        return questionService.getExamQuestionList();
    }
}
