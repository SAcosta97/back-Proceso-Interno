package com.backmantenedor.models;

public class MasterTypeElementsDTO {
    private Long idRegister;
    private String description;
    private String typeFilter;
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
