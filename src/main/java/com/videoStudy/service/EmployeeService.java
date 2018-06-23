package com.videoStudy.service;

import com.videoStudy.data.dao.*;
import com.videoStudy.data.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    private final UsersMapper usersMapper;
    private final QuestionStudyLogMapper questionStudyLogMapper;
    @Autowired
    public EmployeeService(UsersMapper usersMapper, QuestionStudyLogMapper questionStudyLogMapper) {
        this.usersMapper = usersMapper;
        this.questionStudyLogMapper = questionStudyLogMapper;
    }

    //查看题库是否学习
    public int checkQuestionStudyStatus(int qid, int uid){
        QuestionStudyLog questionStudyLog = questionStudyLogMapper.selectByQidAndUid(qid, uid);
        if(questionStudyLog != null)
            return 1;
        else
            return 0;
    }
    //添加学习记录
    public int addQuestionStudyLog(int qid, int uid){
        QuestionStudyLog questionStudyLog = questionStudyLogMapper.selectByQidAndUid(qid, uid);
        if(questionStudyLog != null)
            return 1;
        questionStudyLog = new QuestionStudyLog();
        questionStudyLog.setUid(uid);
        questionStudyLog.setQid(qid);
        return questionStudyLogMapper.insert(questionStudyLog);
    }
}
