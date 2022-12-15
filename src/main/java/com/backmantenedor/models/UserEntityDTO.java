package com.backmantenedor.models;

import com.backmantenedor.entity.RealmEntity;
import com.backmantenedor.entity.SecUserCompany;

import java.util.List;
import java.util.UUID;

public class UserEntityDTO {


    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean enable;
    private String realmEntity;
    private String userCompany;

    private  String userCreation;
    private  String userUpdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealmEntity() {
        return realmEntity;
    }

    public void setRealmEntity(String realmEntity) {
        this.realmEntity = realmEntity;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }


    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
}
