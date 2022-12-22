package com.backmantenedor.entity;

import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecUserCompany;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="sec_applications", schema = "public")
public class SecApplications {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "description")
    private String description;

    @Column(name = "audit")
    private String audit;

    @Column(name = "date_registr")
    private Date dateRegistr;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "user_creation")
    private  String userCreation;

    @Column(name =  "user_update")
    private  String userUpdate;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secApplications")
//    @org.springframework.lang.Nullable
    private Set<SecApplicationPerfil>  appPerfil = new HashSet<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public Date getDateRegistr() {
        return dateRegistr;
    }

    public void setDateRegistr(Date dateRegistr) {
        this.dateRegistr = dateRegistr;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SecApplicationPerfil> getAppPerfil() {
        return appPerfil;
    }

    public void setAppPerfil(Set<SecApplicationPerfil> appPerfil) {
        this.appPerfil = appPerfil;
    }
}


