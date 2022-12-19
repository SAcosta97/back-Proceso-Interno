package com.backmantenedor.models;

import java.util.List;

public class SecRolPerfilDTO {

  List<GetRolDTO> rolPerfil;

  List<GetRolDTO> rolNotPerfil;


    public List<GetRolDTO> getRolPerfil() {
        return rolPerfil;
    }

    public void setRolPerfil(List<GetRolDTO> rolPerfil) {
        this.rolPerfil = rolPerfil;
    }

    public List<GetRolDTO> getRolNotPerfil() {
        return rolNotPerfil;
    }

    public void setRolNotPerfil(List<GetRolDTO> rolNotPerfil) {
        this.rolNotPerfil = rolNotPerfil;
    }
}
