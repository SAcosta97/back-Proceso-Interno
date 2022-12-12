package com.backmantenedor.entity;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;

@Entity
@Table(name ="sec_perfil", schema = "public")
public class SecPerfil {

    @Id
    @Column(name = "id", nullable = false)
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
    private String dateRegistr;

    @Column(name = "date_update")
    private String dateUpdate;

    @Column(name = "observa")
    private String observa;


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

    public String getDateRegistr() {
        return dateRegistr;
    }

    public void setDateRegistr(String dateRegistr) {
        this.dateRegistr = dateRegistr;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    }
}


