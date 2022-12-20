package com.backmantenedor.controller;

import com.backmantenedor.Util.EntryAppPerfil;
import com.backmantenedor.Util.EntryAppUser;
import com.backmantenedor.models.*;
import com.backmantenedor.models.RelationModels.SecAppPerfilDTO;
import com.backmantenedor.models.RelationModels.SecAppUserDTO;
import com.backmantenedor.models.Response.ResponseApplicationsPagination;
import com.backmantenedor.services.RelationServices.SecApplicationPerfilService;
import com.backmantenedor.services.RelationServices.SecApplicationUserService;
import com.backmantenedor.services.SecApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/SecApplications")
public class SecApplicationsController {



    @Autowired
    private SecApplicationsService secApp;

    @Autowired
    private SecApplicationPerfilService secAppPerfil;

    @Autowired
    private SecApplicationUserService appUser;


    @PostMapping("saveUpdateApplications")
    public SaveMantDTO saveUpdateApplications(@RequestBody @Validated SecApplicationsDTO App) throws Exception {
        return secApp.saveUpdateApplications(App);
    }

    @PostMapping("insertDeleteAppPerfil")
    public SaveMantDTO insertDeleteAppPerfil(@RequestBody @Validated EntryAppPerfil entryAppPerfil ) throws Exception {
        return secAppPerfil.insertDeleteAppPerfil(entryAppPerfil);
    }

    @GetMapping("perfilApp_NotPerfilApp")
    public SecAppPerfilDTO getPerfilApp_NotPerfilApp (@RequestParam Long idApp){ return secAppPerfil.getPerfilApp_NotPerfilApp(idApp);}

    @PostMapping("insertDeleteAppUser")
    public SaveMantDTO insertDeleteAppUser(@RequestBody @Validated EntryAppUser entryAppUser ) throws Exception {
        return appUser.insertDeleteAppUser(entryAppUser);
    }

    @GetMapping("UserApp_NotUserApp")
    public SecAppUserDTO getUserApp_NotUserApp (@RequestParam Long idApp){ return appUser.getUserApp_NotUserApp(idApp);}


    @PostMapping("/consult")
    public ResponseApplicationsPagination consultApp (@RequestBody @Validated SearchDTO busqueda){ return secApp.consultApp(busqueda);}

    @GetMapping("/id")
    public List<SecApplicationsDTO> getId(@RequestParam long id){ return secApp.getIdApp(id);}



}
