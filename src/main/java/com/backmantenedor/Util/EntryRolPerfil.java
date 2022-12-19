package com.backmantenedor.Util;

import java.util.List;

public class EntryRolPerfil {

    private Boolean flagCreation;

    private List<Long> rolPerfil;

    private Long idPerfil;

    public Boolean getFlagCreation() {
        return flagCreation;
    }

    public void setFlagCreation(Boolean flagCreation) {
        this.flagCreation = flagCreation;
    }

    public List<Long> getRolPerfil() {
        return rolPerfil;
    }

    public void setRolPerfil(List<Long> rolPerfil) {
        this.rolPerfil = rolPerfil;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }
}
