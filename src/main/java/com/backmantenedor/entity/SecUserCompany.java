package com.backmantenedor.entity;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="sec_users_company", schema = "public")
public class SecUserCompany {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;


    @Column(name = "status")
    private String status;

    @Column(name = "observation")
    private String observation;

    @Column(name = "audit")
    private String audit;

    //    @Column(name = "reference")
//    private String reference;

    @Column(name = "date_registration")
    private Date dateRegistr;

    @Column(name = "date_update")
    private Date dateUpdate;

    //Muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private SecCompany secCompany;

   //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity userEntity ;

//    @Column(name = "user_creation")
//    private  String userCreation;
//
//    @Column(name =  "user_update")
//    private  String userUpdate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    public SecCompany getSecCompany() {
        return secCompany;
    }

    public void setSecCompany(SecCompany secCompany) {
        this.secCompany = secCompany;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
