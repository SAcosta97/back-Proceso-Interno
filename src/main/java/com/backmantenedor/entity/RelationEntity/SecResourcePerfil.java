package com.backmantenedor.entity.RelationEntity;

import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="sec_resource_perfil", schema = "public")
public class SecResourcePerfil {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "date_registration")
    private Date dateRegistr;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "audit")
    private Date audit;

    //Muchos a uno
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_application")
    private SecApplications secApplications;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getAudit() {
        return audit;
    }

    public void setAudit(Date audit) {
        this.audit = audit;
    }

    public SecApplications getSecApplications() {
        return secApplications;
    }

    public void setSecApplications(SecApplications secApplications) {
        this.secApplications = secApplications;
    }

    public SecPerfil getSecPerfil() {
        return secPerfil;
    }

    public void setSecPerfil(SecPerfil secPerfil) {
        this.secPerfil = secPerfil;
    }
}
