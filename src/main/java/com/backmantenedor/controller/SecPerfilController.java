package com.backmantenedor.controller;

import com.backmantenedor.Util.EntryRolPerfil;
import com.backmantenedor.Util.EntryUserPerfil;
import com.backmantenedor.models.*;
import com.backmantenedor.models.RelationModels.SecRolPerfilDTO;
import com.backmantenedor.models.RelationModels.SecUsersPerfilDTO;
import com.backmantenedor.models.Response.ResponsePerfilPagination;
import com.backmantenedor.services.RelationServices.SecUsersPerfilService;
import com.backmantenedor.services.SecPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/SecPerfil")
public class SecPerfilController {



    @Autowired
    private SecPerfilService secPerfil;

    @Autowired
    private SecUsersPerfilService usersPerfilService;


    @PostMapping("saveUpdatePerfil")
    public SaveMantDTO saveUpdatePerfil(@RequestBody @Validated SecPerfilDTO Perfil) throws Exception {return secPerfil.saveUpdatePerfil(Perfil);}

    @PostMapping("/consult")
    public ResponsePerfilPagination consultPerfil (@RequestBody @Validated SearchDTO busqueda){ return secPerfil.consultPerfil(busqueda);}

    @GetMapping("/id")
    public List<SecPerfilDTO> getId(@RequestParam long id){ return secPerfil.getIdPerfil(id);}

    //Asignation User To Perfil
    @GetMapping("userPerfil_NotUserPerfil")
    public SecUsersPerfilDTO getUserPerfil_NotUserPerfil (@RequestParam Long idPerfil){ return usersPerfilService.getUserPerfil_NotUserPerfil(idPerfil);}

    @PostMapping("insertDeleteUserPerfil")
    public SaveMantDTO insertDeleteUserPerfil(@RequestBody @Validated EntryUserPerfil entryUserPerfil ) throws Exception {
        return usersPerfilService.insertDeleteUserPerfil(entryUserPerfil);
    }



}
