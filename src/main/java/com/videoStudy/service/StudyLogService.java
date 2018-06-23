package com.videoStudy.service;

import com.videoStudy.data.dao.QuestionStudyTimeLogMapper;
import com.videoStudy.data.model.QuestionStudyTimeLog;
import com.videoStudy.data.reponse.QuestionStudyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudyLogService {
    private final QuestionStudyTimeLogMapper questionStudyTimeLogMapper;

    @Autowired
    public StudyLogService(QuestionStudyTimeLogMapper questionStudyTimeLogMapper) {
        this.questionStudyTimeLogMapper = questionStudyTimeLogMapper;
    }

    //添加记录
    public int addQuestionStudyTimeLog(int qid, int uid, int time){
        QuestionStudyTimeLog questionStudyTimeLog = new QuestionStudyTimeLog();
        questionStudyTimeLog.setQid(qid);
        questionStudyTimeLog.setUid(uid);
        questionStudyTimeLog.setTime(time);
        questionStudyTimeLog.setDate(new Date());
        return questionStudyTimeLogMapper.insert(questionStudyTimeLog);
    }

    //获取用户学习总时间
    public Integer getQuestionStudyTimeCount(int uid){
        return questionStudyTimeLogMapper.getTimeCountByUid(uid);
    }

    //获取用户学习时间列表
    public Integer getQuestionStudyTime(int uid, int qid){
        return questionStudyTimeLogMapper.getQuestionStudyTIme(uid, qid);
    }
}
