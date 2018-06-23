package com.videoStudy.data.dao;

import com.videoStudy.data.model.QuestionStudyLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionStudyLogMapper {
    QuestionStudyLog selectByQidAndUid(@Param("qid") int qid, @Param("uid") int uid);
    int insert(QuestionStudyLog questionStudyLog);
    int selectNumOfStudied(@Param("uid") int uid);
}
