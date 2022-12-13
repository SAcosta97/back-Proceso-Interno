package com.backmantenedor.controller;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.models.*;
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

    @PostMapping("/Paginacion")
    public ResponseApiRoutePagineo consultarApi (@RequestBody @Validated BusquedaDTO busqueda){ return api_routeService.consultaApi(busqueda);}

    @PostMapping("/Apiroute")
    public List<ApiRouteDTO> obtenerApiRoute(@RequestBody @Validated ApiDataDTO data){ return api_routeService.obtenerApiroute(data);}

    @GetMapping("/TypeFilter")
    public List<MasterTypeElementsDTO>getMaterElement(@RequestParam String typeFilter){ return api_routeService.getMaterElement(typeFilter); }


}
