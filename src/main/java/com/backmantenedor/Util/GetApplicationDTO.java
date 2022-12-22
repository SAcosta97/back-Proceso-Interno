package com.backmantenedor.Util;

public class GetApplicationDTO {


    private Long id;
    private String nombrePerfil;
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

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    }
}
