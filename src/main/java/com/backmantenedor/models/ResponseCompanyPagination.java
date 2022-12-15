package com.backmantenedor.models;

import java.util.List;

public class ResponseCompanyPagination {

    private List<SecCompanyDTO> company;
    private String message;
    private int totalRegister;

    public List<SecCompanyDTO> getCompany() {
        return company;
    }

    public void setCompany(List<SecCompanyDTO> company) {
        this.company = company;
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
