package com.videoStudy.service;

import com.videoStudy.data.dao.UsersMapper;
import com.videoStudy.data.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersMapper usersMapper;

    @Autowired
    public UserService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    //检查用户名和密码是否正确
    public Users checkUsernameAndPassword(String username, String password){
        return usersMapper.selectByUsername(username);
    }
    //检查用户名是否存在
    public String checkUsername(String username){
        Users users = usersMapper.selectByUsername(username);
        if(users == null)
            return "SUCCESS";
        return "ERROR";
    }

    //添加用户
    public String addUser(Users users){
        int st = usersMapper.insertUser(users);
        if(st > 0)
            return "SUCCESS";
        return "ERROR";
    }

    //通过id获取用户信息
    public Users getUserById(int id){
        return usersMapper.selectById(id);
    }

    //根据用户名获取用户信息
    public Users getUserByUsername(String username){
        return usersMapper.selectByUsername(username);
    }

    //更改用户密码
    public int setPassword(String password, int id){
        return usersMapper.updatePasswordById(password, id);
    }

    //分页获取所有用户
    public List<Users> getAllUsers(int beginRow, int pageSize){
        return usersMapper.selectAll(beginRow, pageSize);
    }
}
