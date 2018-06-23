package com.videoStudy.data.dao;

import com.videoStudy.data.model.Answer;
import com.videoStudy.data.model.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    int insert(Question question);
    List<Question> selectQuestionByQid(@Param("qid") int qid);
    Question selectById(@Param("id") int id);
    int selectCount();
    List<Question> selectByIdList(List list);
}
