package com.backmantenedor.models;

import com.backmantenedor.entity.UserEntity;

import java.util.List;
import java.util.Objects;

public class EntryUserCompany {

    private Boolean flagCreation;

    private List<String> usercomp;

    private Long idCompany;

    public List<String> getUsercomp() {
        return usercomp;
    }

    public void setUsercomp(List<String> usercomp) {
        this.usercomp = usercomp;
    }

    public Boolean getFlagCreation() {
        return flagCreation;
    }

    public void setFlagCreation(Boolean flagCreation) {
        this.flagCreation = flagCreation;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }
}
