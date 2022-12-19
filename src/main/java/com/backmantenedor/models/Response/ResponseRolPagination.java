package com.backmantenedor.models.Response;

import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.models.SecRolDTO;

import java.util.List;

public class ResponseRolPagination {

    private List<SecRolDTO> rol;
    private String message;
    private int totalRegister;


    public List<SecRolDTO> getRol() {
        return rol;
    }

    public void setRol(List<SecRolDTO> rol) {
        this.rol = rol;
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
