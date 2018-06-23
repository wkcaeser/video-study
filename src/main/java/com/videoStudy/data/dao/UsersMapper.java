package com.videoStudy.data.dao;


import com.videoStudy.data.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    //根据id查找用户
    Users selectById(@Param("id") int id);
    //根据用户名查找用户
    Users selectByUsername(@Param("username") String username);
    //添加用户
    int insertUser(Users users);
    //修改用户权限
    int updateStatusById(@Param("role") int role, @Param("id") int id);
    //获取所有用户
    List<Users> selectAll(@Param("beginRow") int beginRow, @Param("pageSize") int pageSize);
    int updatePasswordById(@Param("password") String password, @Param("id") int id);
    //修改用户状态
    int updateStatusStrById(@Param("status") String status, @Param("uid") int uid);
    //获取用户状态
    String selectStatusStrById(@Param("uid") int uid);
    //获取用户及单位信息
//    UserWithCompany selectUserWithCompanyById(@Param("id") int id);
}
