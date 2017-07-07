package com.videoStudy.service;

import com.videoStudy.data.dao.UsersMapper;
import com.videoStudy.data.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UsersMapper usersMapper;

    @Autowired
    public UserService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    //检查用户名和密码是否正确
    public String checkUsernameAndPassword(String username, String password){
        Users users = usersMapper.selectByUsername(username);
        if(users != null && users.getPassword().equals(password))
            return "SUCCESS";
        return "ERROR";
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
}
