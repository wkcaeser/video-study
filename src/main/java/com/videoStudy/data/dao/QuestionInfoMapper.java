package com.videoStudy.data.dao;

import com.videoStudy.data.model.QuestionInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionInfoMapper {
    List<QuestionInfo> selectAll();
    QuestionInfo selectById(@Param("id") int id);
}
