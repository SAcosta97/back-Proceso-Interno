package com.backmantenedor.models.Response;

import com.backmantenedor.entity.SecOption;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.SecOptionDTO;

import java.util.List;

public class ResponseSecOptionPagination {

    private List<SecOptionDTO> options;
    private String message;
    private int totalRegister;


    public List<SecOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<SecOptionDTO> options) {
        this.options = options;
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
