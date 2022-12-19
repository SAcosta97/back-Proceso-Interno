package com.backmantenedor.models.Response;

import com.backmantenedor.models.SecPerfilDTO;

import java.util.List;

public class ResponsePerfilPagineo {

    private List<SecPerfilDTO> perfil;
    private String mensaje;
    private int totalRegistro;


    public List<SecPerfilDTO> getPerfil() {
        return perfil;
    }

    public void setPerfil(List<SecPerfilDTO> perfil) {
        this.perfil = perfil;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTotalRegistro() {
        return totalRegistro;
    }

    public void setTotalRegistro(int totalRegistro) {
        this.totalRegistro = totalRegistro;
    }
}
