package com.backmantenedor.entity;

import com.backmantenedor.entity.RelationEntity.SecRolPerfil;
import com.backmantenedor.entity.RelationEntity.SecUserPerfil;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="sec_perfil", schema = "public")
public class SecPerfil {

    @Id
    @Column(name = "id_perfil", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "nombre_perfil")
    private String nombrePerfil;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "audit")
    private String audit;

    @Column(name = "date_registr")
    private Date dateRegistr;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "observa")
    private String observa;

    @Column(name = "user_creation")
    private  String userCreation;

    @Column(name =  "user_update")
    private  String userUpdate;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secPerfil")
    private List<SecRolPerfil> secPerfil;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secPerfil")
    private List<SecUserPerfil> secUserPerfils;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secPerfil")
    private List<SecResourcePerfil> secResourcePerfils;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
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

    public List<SecRolPerfil> getSecPerfil() {
        return secPerfil;
    }

    public void setSecPerfil(List<SecRolPerfil> secPerfil) {
        this.secPerfil = secPerfil;
    }

    public List<SecUserPerfil> getSecUserPerfils() {
        return secUserPerfils;
    }

    public void setSecUserPerfils(List<SecUserPerfil> secUserPerfils) {
        this.secUserPerfils = secUserPerfils;
    }

    public List<SecResourcePerfil> getSecResourcePerfils() {
        return secResourcePerfils;
    }

    public void setSecResourcePerfils(List<SecResourcePerfil> secResourcePerfils) {
        this.secResourcePerfils = secResourcePerfils;
    }
}


