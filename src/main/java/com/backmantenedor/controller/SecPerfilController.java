package com.backmantenedor.controller;

import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.MasterTypeElementsDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.services.ApiRouteService;
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


    @PostMapping("guardarActualizarSecPerfil")
    public GuardarApirouteDTO guardarPerfil(@RequestBody @Validated SecPerfilDTO Perfil) throws Exception {
        return secPerfil.guardarPerfil(Perfil);
    }


    @GetMapping("/id")
    public List<SecPerfilDTO> obtenerId(@RequestParam long id){ return secPerfil.ObtenerIdPerfil(id);}


    @GetMapping("/Perfil")
    public List<SecPerfilDTO> obtenerPerfil(){ return secPerfil.obtenerperfil();}


}
