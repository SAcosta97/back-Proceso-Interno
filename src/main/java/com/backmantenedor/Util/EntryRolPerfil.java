package com.backmantenedor.Util;

import java.util.List;

public class EntryRolPerfil {

    private Boolean flagCreation;

    private List<String> rolPerfil;

    private Long idPerfil;

    public Boolean getFlagCreation() {
        return flagCreation;
    }

    public void setFlagCreation(Boolean flagCreation) {
        this.flagCreation = flagCreation;
    }

    public List<String> getRolPerfil() {
        return rolPerfil;
    }

    public void setRolPerfil(List<String> rolPerfil) {
        this.rolPerfil = rolPerfil;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }
}
