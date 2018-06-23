package com.videoStudy.data.reponse;

import com.videoStudy.data.model.Users;

public class UserInformation {
    private String status;
    private Users users;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
