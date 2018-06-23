package com.videoStudy.service;

import com.videoStudy.data.model.Users;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthorityService {
    //检查权限
    public String checkAuthority(HttpServletRequest request, int level){
        Users users = (Users) request.getSession().getAttribute("userInfo");
        if(users == null)
            return "ERROR";
        if(users.getRole() == level)
            return "SUCCESS";
        return "ERROR";
    }
}
