package com.videoStudy.data.dao;


import com.videoStudy.data.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    //根据id查找用户
    Users selectById(@Param("id") int id);
    //根据用户名查找用户
    Users selectByUsername(@Param("username") String username);
    //添加用户
    int insertUser(Users users);
}
