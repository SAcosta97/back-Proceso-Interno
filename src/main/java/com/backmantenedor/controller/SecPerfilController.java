package com.backmantenedor.controller;

import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.MasterTypeElementsDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.services.ApiRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/apiroute")
public class SecPerfilController {



//    @Autowired
//    private SecPerfil secPerfil;


//    @PostMapping("guardarActualizarApiroute")
//    public GuardarApirouteDTO guardarPerfil(@RequestBody @Validated SecPerfilDTO Perfil) throws Exception {
//        return SecPerfil.guardarPerfil(Perfil);
//    }
//
//    @GetMapping("/TypeFilter")
//    public List<MasterTypeElementsDTO>getMaterElement(@RequestParam String typeFilter){ return api_routeService.getMaterElement(typeFilter); }
}
