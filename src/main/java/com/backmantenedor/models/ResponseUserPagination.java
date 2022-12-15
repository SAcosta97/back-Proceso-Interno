package com.backmantenedor.models;

import com.backmantenedor.Util.UserEntityObject;

import java.util.List;

public class ResponseUserPagination {

    private List<UserEntityObject> user;
    private String message;
    private int totalRegister;

    public List<UserEntityObject> getUser() {
        return user;
    }

    public void setUser(List<UserEntityObject> user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(int totalRegister) {
        this.totalRegister = totalRegister;
    }
}
