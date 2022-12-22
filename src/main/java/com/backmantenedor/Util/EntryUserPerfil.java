package com.backmantenedor.Util;

import java.util.List;

public class EntryUserPerfil {

    private Boolean flagCreation;

    private List<String> Usersperfil;

    private Long idPerfil;

    public Boolean getFlagCreation() {
        return flagCreation;
    }

    public void setFlagCreation(Boolean flagCreation) {
        this.flagCreation = flagCreation;
    }


    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;

    }

    public List<String> getUsersperfil() {
        return Usersperfil;
    }

    public void setUsersperfil(List<String> usersperfil) {
        Usersperfil = usersperfil;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }
}
