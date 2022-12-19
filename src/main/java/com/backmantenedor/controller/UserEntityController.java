package com.backmantenedor.controller;

import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponseUserPagination;
import com.backmantenedor.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/userentity")
public class UserEntityController {



    @Autowired
    private UserEntityService userEntityService;


//    @PostMapping("saveUpdateUserEntity")
//    public SaveMantDTO saveUpdateUserEntity(@RequestBody @Validated UserEntityDTO User) throws Exception {
//        return userEntityService.saveUpdateUserEntity(User);
//    }

    @PostMapping("/consult")
    public ResponseUserPagination consultUser (@RequestBody @Validated SearchDTO busqueda){ return userEntityService.consultusuario(busqueda);}


    @GetMapping("/getUserNotCompany")
    public List<GetUserDTO> getUser( ){ return userEntityService.getUserNotCompany();}

}

