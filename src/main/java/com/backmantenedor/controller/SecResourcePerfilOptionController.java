package com.backmantenedor.controller;

import com.backmantenedor.Util.EntryResourcePerfilOption;
import com.backmantenedor.Util.EntryUserPerfil;
import com.backmantenedor.models.RelationModels.SecResourcePerfilOptionDTO;
import com.backmantenedor.models.RelationModels.SecUsersPerfilDTO;
import com.backmantenedor.models.Response.ResponsePerfilPagination;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.models.SearchDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.services.RelationServices.SecResourcePerfilOptionService;
import com.backmantenedor.services.RelationServices.SecUsersPerfilService;
import com.backmantenedor.services.SecPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/secResourceOption/")
public class SecResourcePerfilOptionController {



    @Autowired
    private SecResourcePerfilOptionService secResourcePerfilOptionService;

    //Asignation User To Perfil
    @GetMapping("ApiOption_NotApiOption")
    public SecResourcePerfilOptionDTO getApiOption_NotApiOption (@RequestParam Long idApi){ return secResourcePerfilOptionService.getApiOption_NotApiOption(idApi);}

    @PostMapping("insertDeleteApiOption")
    public SaveMantDTO insertDeleteApiOption(@RequestBody @Validated EntryResourcePerfilOption entryResourcePerfilOption ) throws Exception {
        return secResourcePerfilOptionService.insertDeleteApiOption(entryResourcePerfilOption);
    }



}
