package com.backmantenedor.models;

public class SecOptionDTO {


    private Long id;


    private String idEvento;

    private Boolean permit;

    private Long idApi;

    private String userCreation;

    private String userUpdate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public Boolean getPermit() {
        return permit;
    }

    public void setPermit(Boolean permit) {
        this.permit = permit;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }


    public Long getIdApi() {
        return idApi;
    }

    public void setIdApi(Long idApi) {
        this.idApi = idApi;
    }
}
