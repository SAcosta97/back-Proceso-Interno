package com.backmantenedor.controller;

import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.UserEntityDTO;
import com.backmantenedor.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/userentity")
public class UserEntityController {



    @Autowired
    private UserEntityService userEntityService;


    @PostMapping("guardarActualizarUserEntity")
    public GuardarApirouteDTO guardarUser(@RequestBody @Validated UserEntityDTO User) throws Exception {
        return userEntityService.guardarUser(User);
    }
//    @GetMapping("/id")
//    public List<ApiRouteDTO> obtenerId(@RequestParam long id){ return api_routeService.obtenerApi(id);}
//
//    @GetMapping("/tipo")
//    public List<ApiRouteDTO> obtenerPath(@RequestParam String tipo){ return api_routeService.obtenerTipo(tipo);}
//
//    @GetMapping("/Apiroute")
//    public List<ApiRouteDTO> obtenerApiRoute(){ return api_routeService.obtenerApiroute();}
//
//    @GetMapping("/TypeFilter")
//    public List<MasterTypeElementsDTO>getMaterElement(@RequestParam String typeFilter){ return api_routeService.getMaterElement(typeFilter); }
}
