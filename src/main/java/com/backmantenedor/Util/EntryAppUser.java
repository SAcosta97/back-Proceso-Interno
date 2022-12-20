package com.backmantenedor.Util;

import java.util.List;

public class EntryAppUser {

    private Boolean flagCreation;

    private List<Long> userApp;

    private Long idApp;

    public Boolean getFlagCreation() {
        return flagCreation;
    }

    public void setFlagCreation(Boolean flagCreation) {
        this.flagCreation = flagCreation;
    }

    public List<Long> getUserApp() {
        return userApp;
    }

    public void setUserApp(List<Long> userApp) {
        this.userApp = userApp;
    }

    public Long getIdApp() {
        return idApp;
    }

    public void setIdApp(Long idApp) {
        this.idApp = idApp;
    }


}
