package com.backmantenedor.models.RelationModels;

import com.backmantenedor.Util.GetApplicationDTO;
import com.backmantenedor.Util.GetUserDTO;

import java.util.List;

public class SecAppUserDTO {

  List<GetUserDTO> UserApp;

  List<GetUserDTO> notUserApp ;

    public List<GetUserDTO> getUserApp() {
        return UserApp;
    }

    public void setUserApp(List<GetUserDTO> userApp) {
        UserApp = userApp;
    }

    public List<GetUserDTO> getNotUserApp() {
        return notUserApp;
    }

    public void setNotUserApp(List<GetUserDTO> notUserApp) {
        this.notUserApp = notUserApp;
    }
}
