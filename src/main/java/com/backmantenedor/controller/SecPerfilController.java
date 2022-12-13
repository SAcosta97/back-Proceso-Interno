package com.backmantenedor.controller;

import com.backmantenedor.Util.PerfilDataDTO;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.models.*;
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
    public GuardarApirouteDTO guardarPerfil(@RequestBody @Validated SecPerfilDTO Perfil) throws Exception {return secPerfil.guardarPerfil(Perfil);}

    @PostMapping("/Paginacion")
    public ResponsePerfilPagineo consultarPerfil (@RequestBody @Validated BusquedaDTO busqueda){ return secPerfil.obtenerPerfil(busqueda);}

    @GetMapping("/id")
    public List<SecPerfilDTO> obtenerId(@RequestParam long id){ return secPerfil.ObtenerIdPerfil(id);}

    @PostMapping("/Perfil")
    public List<SecPerfilDTO> obtenerPerfil(@RequestBody @Validated PerfilDataDTO perfildata){ return secPerfil.obtenerperfil(perfildata);}


}
