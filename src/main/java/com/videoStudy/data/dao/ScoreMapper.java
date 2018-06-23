package com.videoStudy.data.dao;

import com.videoStudy.data.model.Score;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {
    int insert(Score score);
    Score selectMax(@Param("uid") int uid);
}
