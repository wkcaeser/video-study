package com.videoStudy.service;

import com.videoStudy.data.dao.ClassListMapper;
import com.videoStudy.data.dao.QuestionInfoMapper;
import com.videoStudy.data.model.ClassList;
import com.videoStudy.data.model.QuestionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassListService {
    private final ClassListMapper classListMapper;
    private final QuestionInfoMapper questionInfoMapper;
    @Autowired
    public ClassListService(ClassListMapper classListMapper, QuestionInfoMapper questionInfoMapper) {
        this.classListMapper = classListMapper;
        this.questionInfoMapper = questionInfoMapper;
    }

    public List<ClassList> getClassList(){
        return classListMapper.selectAll();
    }

    public List<QuestionInfo> getQuestionInfoList(){
        return questionInfoMapper.selectAll();
    }
}
