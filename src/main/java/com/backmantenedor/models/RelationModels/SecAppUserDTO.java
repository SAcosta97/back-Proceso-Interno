package com.backmantenedor.models.RelationModels;

import com.backmantenedor.Util.GetApplicationDTO;

import java.util.List;

public class SecAppUserDTO {

  List<GetApplicationDTO> perfilApp;

  List<GetApplicationDTO> notPerfilApp ;

    public List<GetApplicationDTO> getPerfilApp() {
        return perfilApp;
    }

    public void setPerfilApp(List<GetApplicationDTO> perfilApp) {
        this.perfilApp = perfilApp;
    }

    public List<GetApplicationDTO> getNotPerfilApp() {
        return notPerfilApp;
    }

    public void setNotPerfilApp(List<GetApplicationDTO> notPerfilApp) {
        this.notPerfilApp = notPerfilApp;
    }


}
