package com.backmantenedor.controller;

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


    @PostMapping("saveUpdateApiroute")
    public SaveMantDTO saveApi(@RequestBody @Validated ApiRouteDTO Api) throws Exception {
        return api_routeService.saveApi(Api);
    }
    @GetMapping("/id")
    public List<ApiRouteDTO> getId(@RequestParam long id){ return api_routeService.getId(id);}

    @PostMapping("/consult")
    public ResponseApiRoutePagination consultApi (@RequestBody @Validated SearchDTO busqueda){ return api_routeService.consultApi(busqueda);}

    @GetMapping("/TypeFilter")
    public List<MasterTypeElementsDTO>getMaterElement(@RequestParam String typeFilter){ return api_routeService.getMaterElement(typeFilter); }


}
