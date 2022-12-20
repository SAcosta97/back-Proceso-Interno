package com.backmantenedor.entity;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="sec_rol_perfil", schema = "public")
public class SecRolPerfil {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;


    //Muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private SecRol secRol;

    //Relacion muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private SecPerfil secPerfil ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecRol getSecRol() {
        return secRol;
    }

    public void setSecRol(SecRol secRol) {
        this.secRol = secRol;
    }

    public SecPerfil getSecPerfil() {
        return secPerfil;
    }

    public void setSecPerfil(SecPerfil secPerfil) {
        this.secPerfil = secPerfil;
    }
}
