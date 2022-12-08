package com.backmantenedor.controller;

import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.services.ApiRouteDTO;
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

    @GetMapping("/Path")
    public List<ApiRouteDTO> obtenerPath(@RequestParam String path){ return api_routeService.obtenerPath(path);}

    @GetMapping("/Method")
    public List<ApiRouteDTO> obtenerMethod(@RequestParam String method){ return api_routeService.obtenerMethod(method);}

    @GetMapping("/Tipo")
    public List<ApiRouteDTO> obtenerTipo(@RequestParam String tipo){ return api_routeService.obtenerTipo(tipo);}

    @GetMapping("/Apiroute")
    public List<ApiRouteDTO> obtenerApiRoute(){ return api_routeService.obtenerApiroute();}

}
