package com.videoStudy.data.dao;

import com.videoStudy.data.model.QuestionStudyTimeLog;
import com.videoStudy.data.reponse.QuestionStudyTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionStudyTimeLogMapper {
    int insert(QuestionStudyTimeLog questionStudyTimeLog);
    Integer getTimeCountByUid(@Param("uid") int uid);
    Integer getQuestionStudyTIme(@Param("uid") int uid, @Param("qid") int qid);
}
