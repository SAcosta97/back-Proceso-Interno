package com.backmantenedor.entity;

import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecResourcePerfilOption;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="sec_resource_perfil", schema = "public")
public class SecResourcePerfil {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "reference")
    private String reference;

    @Column(name = "audit")
    private String audit;

    @Column(name = "date_registr")
    private Date dateRegistr;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "observation")
    private String observation;

    @Column(name = "path")
    private String path;

    @Column(name = "user_creation")
    private  String userCreation;

    @Column(name =  "user_update")
    private  String userUpdate;

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private SecPerfil secPerfil ;

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "_id_api_route")
    private ApiRoute apiRoute ;

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_application")
    private SecApplications secApplications ;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secResourcePerfil")
//    @org.springframework.lang.Nullable
    private Set<SecResourcePerfilOption>  secResourcePerfilOptions = new HashSet<>();






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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public SecPerfil getSecPerfil() {
        return secPerfil;
    }

    public void setSecPerfil(SecPerfil secPerfil) {
        this.secPerfil = secPerfil;
    }

    public ApiRoute getApiRoute() {
        return apiRoute;
    }

    public void setApiRoute(ApiRoute apiRoute) {
        this.apiRoute = apiRoute;
    }

    public SecApplications getSecApplications() {
        return secApplications;
    }

    public void setSecApplications(SecApplications secApplications) {
        this.secApplications = secApplications;
    }
}


