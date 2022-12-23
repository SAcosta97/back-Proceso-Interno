package com.backmantenedor.entity;


import com.backmantenedor.entity.RelationEntity.SecResourcePerfilOption;
import com.backmantenedor.entity.RelationEntity.SecUserCompany;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="sec_option", schema = "public")
public class SecOption {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "id_evento")
    private String idEvento;

    @Column (name = "status")
    private String status;

    @Column (name = "permit")
    private Boolean permit;

    @Column(name = "user_creation")
    private  String userCreation;

    @Column(name =  "user_update")
    private  String userUpdate;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secOption")
//    @org.springframework.lang.Nullable
    private Set<SecResourcePerfilOption> secResourcePerfilOptions = new HashSet<>();

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_api_route")
    private ApiRoute apiRoute ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPermit() {
        return permit;
    }

    public void setPermit(Boolean permit) {
        this.permit = permit;
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

    public Set<SecResourcePerfilOption> getSecResourcePerfilOptions() {
        return secResourcePerfilOptions;
    }

    public void setSecResourcePerfilOptions(Set<SecResourcePerfilOption> secResourcePerfilOptions) {
        this.secResourcePerfilOptions = secResourcePerfilOptions;
    }

    public ApiRoute getApiRoute() {
        return apiRoute;
    }

    public void setApiRoute(ApiRoute apiRoute) {
        this.apiRoute = apiRoute;
    }
}
