package com.backmantenedor.models;

public class SearchDTO {

    private int page;
    private int reg_por_pag;

    //ApiRoute
    private String tipo;
    //Perfil
    private String nombrePerfil;

    //App-Company
    private String name;

    //user
    private String username;

    //Company
    private String ruc;

    //Rol
    private String rol;

    //Option
    private Boolean permit;

    //option-Api
    private long idApi;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getReg_por_pag() {
        return reg_por_pag;
    }

    public void setReg_por_pag(int reg_por_pag) {
        this.reg_por_pag = reg_por_pag;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getPermit() {
        return permit;
    }

    public void setPermit(Boolean permit) {
        this.permit = permit;
    }

    public long getIdApi() {
        return idApi;
    }

    public void setIdApi(long idApi) {
        this.idApi = idApi;
    }
}
