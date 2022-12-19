package com.backmantenedor.controller;

import com.backmantenedor.Util.EntryRolPerfil;
import com.backmantenedor.Util.EntryUserCompany;
import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponseRolPagination;
import com.backmantenedor.services.SecRolPerfilService;
import com.backmantenedor.services.SecRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/SecRol")
public class SecRolController {


    @Autowired
    private SecRolService secRolService;

    @Autowired
    SecRolPerfilService secRolPerfil;


    @PostMapping("saveUpdateRol")
    public SaveMantDTO saveUpdateSecRol (@RequestBody @Validated SecRolDTO secRolDTO ) throws Exception {
        return secRolService.saveUpdateSecRol(secRolDTO);
    }

    @PostMapping("/consult")
    public ResponseRolPagination consultCompany (@RequestBody @Validated SearchDTO busqueda){ return secRolService.consultRol(busqueda);}

    @GetMapping("RolPerfil_NotPerfil")
    public SecRolPerfilDTO getRolPerfil_NotPerfil (@RequestParam Long idPerfil){ return secRolPerfil.getRolPerfil_NotPerfil(idPerfil);}


    @PostMapping("insertDeleteRolPerfil")
    public SaveMantDTO insertDeleteRolPerfil(@RequestBody @Validated EntryRolPerfil entryRolPerfil ) throws Exception {
        return secRolPerfil.insertDeleteRolPerfil(entryRolPerfil);
    }




}
