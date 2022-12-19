package com.backmantenedor.models.Response;

import com.backmantenedor.models.SecPerfilDTO;

import java.util.List;

public class ResponsePerfilPagination {

    private List<SecPerfilDTO> perfil;
    private String message;
    private int totalRegister;


    public List<SecPerfilDTO> getPerfil() {
        return perfil;
    }

    public void setPerfil(List<SecPerfilDTO> perfil) {
        this.perfil = perfil;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(int totalRegister) {
        this.totalRegister = totalRegister;
    }
}
