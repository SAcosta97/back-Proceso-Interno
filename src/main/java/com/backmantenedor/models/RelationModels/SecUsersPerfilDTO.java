package com.backmantenedor.models.RelationModels;

import com.backmantenedor.Util.GetApplicationDTO;
import com.backmantenedor.Util.GetUserDTO;

import java.util.List;

public class SecUsersPerfilDTO {

  List<GetUserDTO> Userperfil;

  List<GetUserDTO> notUserPerfil ;

    public List<GetUserDTO> getUserperfil() {
        return Userperfil;
    }

    public void setUserperfil(List<GetUserDTO> userperfil) {
        Userperfil = userperfil;
    }

    public List<GetUserDTO> getNotUserPerfil() {
        return notUserPerfil;
    }

    public void setNotUserPerfil(List<GetUserDTO> notUserPerfil) {
        this.notUserPerfil = notUserPerfil;
    }
}
