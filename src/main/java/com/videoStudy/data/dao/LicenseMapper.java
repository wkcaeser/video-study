package com.videoStudy.data.dao;

import com.videoStudy.data.model.License;
import com.videoStudy.data.model.LicenseDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseMapper {
    int insert(License license);
    int update(@Param("status") int status,@Param("id") int id);
    License selectByUid(@Param("uid") int uid);
    List<LicenseDetail> selectPage(@Param("beginRow") int beginRow, @Param("pageSize") int pageSize);
}
