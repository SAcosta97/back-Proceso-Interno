package com.backmantenedor.models;

import java.util.List;

public class ResponseApiRoutePagineo {

    private List<ApiRouteDTO> api;
    private String mensaje;
    private int totalRegistro;


    public List<ApiRouteDTO> getApi() {
        return api;
    }

    public void setApi(List<ApiRouteDTO> api) {
        this.api = api;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTotalRegistro() {
        return totalRegistro;
    }

    public void setTotalRegistro(int totalRegistro) {
        this.totalRegistro = totalRegistro;
    }
}
