package com.backmantenedor.controller;

import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.services.SecApplicationsService;
import com.backmantenedor.services.SecPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/SecApplications")
public class SecApplicationsController {



    @Autowired
    private SecApplicationsService secApp;


    @PostMapping("guardarActualizarSecPerfil")
    public GuardarApirouteDTO guardarPerfil(@RequestBody @Validated SecApplicationsDTO App) throws Exception {
        return secApp.guardarApplicatoins(App);
    }


    @GetMapping("/id")
    public List<SecApplicationsDTO> obtenerId(@RequestParam long id){ return secApp.ObtenerIdApp(id);}


    @GetMapping("/Perfil")
    public List<SecApplicationsDTO> obtenerApp(){ return secApp.obtenerApp();}


}
