package com.backmantenedor.entity;


import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="user_entity", schema = "public")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable*/
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column (name ="first_name")
    private String firstName;

    @Column (name = "last_name")
    private  String lastName;

    @Column (name = "enable")
    private Boolean enable;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "realm_id")
    private RealmEntity realmEntity;


    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userEntity")
    @org.springframework.lang.Nullable
    private List<SecUserCompany> userCompany;

    @Column(name = "user_creation")
    private  String userCreation;

    @Column(name =  "user_update")
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


    public RealmEntity getRealmEntity() {
        return realmEntity;
    }

    public void setRealmEntity(RealmEntity realmEntity) {
        this.realmEntity = realmEntity;
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

    public List<SecUserCompany> getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(List<SecUserCompany> userCompany) {
        this.userCompany = userCompany;
    }
}





