package com.videoStudy.service;

import com.videoStudy.data.dao.QuestionInfoMapper;
import com.videoStudy.data.dao.QuestionMapper;
import com.videoStudy.data.dao.ScoreMapper;
import com.videoStudy.data.model.Answer;
import com.videoStudy.data.model.Question;
import com.videoStudy.data.model.QuestionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionMapper questionMapper;
    private final QuestionInfoMapper questionInfoMapper;

    @Autowired
    public QuestionService(QuestionMapper questionMapper, QuestionInfoMapper questionInfoMapper) {
        this.questionMapper = questionMapper;
        this.questionInfoMapper = questionInfoMapper;
    }

    //添加题目
    public int insertNewQuestion(String description, String answerA, String answerB, String answerC, String answerD, String answer){
        Question question = new Question();
        question.setDescription(description);
        question.setAnswerA(answerA);
        question.setAnswerB(answerB);
        question.setAnswerC(answerC);
        question.setAnswerD(answerD);
        question.setAnswer(answer);
        return questionMapper.insert(question);
    }
    //获取题目列表
    public List<Question> getQuestionListByQid(int qid){
        return questionMapper.selectQuestionByQid(qid);
    }

    //根据id获取题目描述
    public QuestionInfo getQuestionInfo(int qid){
        return questionInfoMapper.selectById(qid);
    }

    //获取考试题目
    public List<Question> getExamQuestionList(){
        int count = questionMapper.selectCount();
        List<Integer> listOfIndex = new ArrayList<>();
        while (true){
            if(listOfIndex.size() >= 100){
                break;
            }
            int i = (int)(Math.random()*count+1);
            if(!listOfIndex.contains(i)){
                listOfIndex.add(i);
            }
        }
        return questionMapper.selectByIdList(listOfIndex);
    }

    //计算分数
    public int sumScore(List<Answer> answerList){
        int score = 0;
        List<Integer> idList = new ArrayList<>();
        for(Answer answer:answerList){
            idList.add(answer.getQid());
        }
        List<Question> questionList = questionMapper.selectByIdList(idList);
        Question questionCache = new Question();
        for (Answer answer:answerList){
            questionCache.setId(answer.getQid());
            questionCache.setAnswer(answer.getAid());
            if(questionList.contains(questionCache))
                score += 1;
        }
        return score;
    }
}
