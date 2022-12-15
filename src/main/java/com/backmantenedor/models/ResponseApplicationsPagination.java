package com.backmantenedor.models;

import java.util.List;

public class ResponseApplicationsPagination {

    private List<SecApplicationsDTO> app;
    private String message;
    private int totalRegister;


    public List<SecApplicationsDTO> getApp() {
        return app;
    }

    public void setApp(List<SecApplicationsDTO> app) {
        this.app = app;
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
