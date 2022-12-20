package com.backmantenedor.Util;

import java.util.List;

public class EntryRolPerfil {

    private Boolean flagCreation;

    private List<Long> rolPerfil;

    private Long idRol;

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

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
