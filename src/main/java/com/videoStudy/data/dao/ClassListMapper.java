package com.videoStudy.data.dao;

import com.videoStudy.data.model.ClassList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassListMapper {
    List<ClassList> selectAll();
}
