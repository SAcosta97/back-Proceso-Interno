package com.backmantenedor.models;

import java.util.List;

public class SecUserCompanyDTO {

  List<GetUserDTO> usersComp;

  List<GetUserDTO> usersNotComp;


    public List<GetUserDTO> getUsersComp() {
        return usersComp;
    }

    public void setUsersComp(List<GetUserDTO> usersComp) {
        this.usersComp = usersComp;
    }

    public List<GetUserDTO> getUsersNotComp() {
        return usersNotComp;
    }

    public void setUsersNotComp(List<GetUserDTO> usersNotComp) {
        this.usersNotComp = usersNotComp;
    }
}
