package com.backmantenedor.models;

import java.util.List;

public class ResponseApiRoutePagination {

    private List<ApiRouteDTO> api;
    private String message;
    private int totalRegister;


    public List<ApiRouteDTO> getApi() {
        return api;
    }

    public void setApi(List<ApiRouteDTO> api) {
        this.api = api;
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
