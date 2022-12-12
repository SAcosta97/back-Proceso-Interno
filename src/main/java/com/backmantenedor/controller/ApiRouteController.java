package com.backmantenedor.controller;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.models.ApiDataDTO;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.MasterTypeElementsDTO;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.services.ApiRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/apiroute")
public class ApiRouteController {



    @Autowired
    private ApiRouteService api_routeService;


    @PostMapping("guardarActualizarApiroute")
    public GuardarApirouteDTO guardarApi(@RequestBody @Validated ApiRouteDTO Api) throws Exception {
        return api_routeService.guardarApi(Api);
    }
    @GetMapping("/id")
    public List<ApiRouteDTO> obtenerId(@RequestParam long id){ return api_routeService.obtenerApi(id);}

//    @GetMapping("/tipo")
//    public List<ApiRouteDTO> obtenerTipo(@RequestParam String tipo){ return api_routeService.obtenerTipo(tipo);}

    @PostMapping("/Apiroute")
    public List<ApiRouteDTO> obtenerApiRoute(@RequestBody @Validated ApiDataDTO data){ return api_routeService.obtenerApiroute(data);}

    @GetMapping("/TypeFilter")
    public List<MasterTypeElementsDTO>getMaterElement(@RequestParam String typeFilter){ return api_routeService.getMaterElement(typeFilter); }
}
