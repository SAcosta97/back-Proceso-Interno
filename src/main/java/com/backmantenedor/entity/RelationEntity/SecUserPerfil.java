package com.backmantenedor.entity.RelationEntity;

import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="sec_user_perfil", schema = "public")
public class SecUserPerfil {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "reference")
    private String reference;

    @Column(name = "audit")
    private String audit;

    @Column(name = "observation")
    private String observation;

    @Column(name = "description")
    private String description;

    @Column(name = "date_registration")
    private Date dateRegistr;

    @Column(name = "date_update")
    private Date dateUpdate;

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private SecPerfil secPerfil ;

    //Muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

    public SecPerfil getSecPerfil() {
        return secPerfil;
    }

    public void setSecPerfil(SecPerfil secPerfil) {
        this.secPerfil = secPerfil;
    }

    public String getAudit() {
        return audit;
    }
}
