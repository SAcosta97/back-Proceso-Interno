package com.backmantenedor.entity;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;

@Entity
@Table(name ="master_type_elements", schema = "public")
public class MasterTypeElements {
    @Id
    @Column(name = "id_register", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long idRegister;

    @Column(name = "description")
    private String description;

    @Column(name = "type_filter")
    private String typeFilter;

    @Column(name = "state_reg")
    private Boolean stateReg;

    public Long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Long idRegister) {
        this.idRegister = idRegister;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeFilter() {
        return typeFilter;
    }

    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
    }

    public Boolean getStateReg() {
        return stateReg;
    }

    public void setStateReg(Boolean stateReg) {
        this.stateReg = stateReg;
    }
}
