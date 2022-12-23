package com.backmantenedor.entity.RelationEntity;

import com.backmantenedor.entity.*;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="sec_resource_perfil_option", schema = "public")
public class SecResourcePerfilOption {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "status")
    private Boolean status;


    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sec_resource_perfil")
    private SecResourcePerfil secResourcePerfil ;

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_api_route")
    private ApiRoute apiRoute ;

    //Muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_option")
    private SecOption secOption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    public SecOption getSecOption() {
        return secOption;
    }

    public void setSecOption(SecOption secOption) {
        this.secOption = secOption;
    }

    public SecResourcePerfil getSecResourcePerfil() {
        return secResourcePerfil;
    }

    public void setSecResourcePerfil(SecResourcePerfil secResourcePerfil) {
        this.secResourcePerfil = secResourcePerfil;
    }

    public ApiRoute getApiRoute() {
        return apiRoute;
    }

    public void setApiRoute(ApiRoute apiRoute) {
        this.apiRoute = apiRoute;
    }
}
