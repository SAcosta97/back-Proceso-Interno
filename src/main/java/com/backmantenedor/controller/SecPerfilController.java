package com.backmantenedor.controller;

import com.backmantenedor.models.*;
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


    @PostMapping("saveUpdatePerfil")
    public SaveMantDTO saveUpdatePerfil(@RequestBody @Validated SecPerfilDTO Perfil) throws Exception {return secPerfil.saveUpdatePerfil(Perfil);}

    @PostMapping("/consult")
    public ResponsePerfilPagination consultPerfil (@RequestBody @Validated SearchDTO busqueda){ return secPerfil.consultPerfil(busqueda);}

    @GetMapping("/id")
    public List<SecPerfilDTO> getId(@RequestParam long id){ return secPerfil.getIdPerfil(id);}


}
