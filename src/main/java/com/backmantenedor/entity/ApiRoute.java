package com.backmantenedor.entity;


import com.backmantenedor.entity.RelationEntity.SecResourcePerfilOption;
import com.backmantenedor.entity.RelationEntity.SecUserPerfil;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="api_route", schema = "public")
public class ApiRoute {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "path")
    private String path;

    @Column(name = "method")
    private String method;

    @Column (name = "uri")
    private String uri;

    @Column (name ="tipo")
    private String tipo;

    @Column (name = "estado")
    private Boolean estado;

    @Column (name = "ip")
    private  String ip;

    @Column(name = "user_creation")
    private  String userCreation;

    @Column(name =  "user_update")
    private  String userUpdate;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "apiRoute")
    private List<SecResourcePerfil> secResourcePerfils;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "apiRoute")
    private List<SecResourcePerfilOption> secResourcePerfilOptions;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "apiRoute")
    private List<SecOption> secOptions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<SecResourcePerfil> getSecResourcePerfils() {
        return secResourcePerfils;
    }

    public void setSecResourcePerfils(List<SecResourcePerfil> secResourcePerfils) {
        this.secResourcePerfils = secResourcePerfils;
    }

    public List<SecResourcePerfilOption> getSecResourcePerfilOptions() {
        return secResourcePerfilOptions;
    }

    public void setSecResourcePerfilOptions(List<SecResourcePerfilOption> secResourcePerfilOptions) {
        this.secResourcePerfilOptions = secResourcePerfilOptions;
    }

    public List<SecOption> getSecOptions() {
        return secOptions;
    }

    public void setSecOptions(List<SecOption> secOptions) {
        this.secOptions = secOptions;
    }
}
