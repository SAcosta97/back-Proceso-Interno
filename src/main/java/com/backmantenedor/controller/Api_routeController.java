package com.backmantenedor.controller;

import com.backmantenedor.models.Api_routeDTO;

import com.backmantenedor.services.Api_routeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/apiroute/")
public class Api_routeController {



    @Autowired
    private   Api_routeService api_routeService;




//    @PostMapping("guardarActualizarApiroute")
//    public GuardarApirouteDTO guardarApi(@RequestBody @Validated Api_routeDTO Api){
//        return api_routeService.guardarApi(Api);

    @GetMapping("/id")
    public List<Api_routeDTO> obtenerId(@RequestParam long id){ return api_routeService.obtenerApi(id);}

    @GetMapping("/Path")
    public List<Api_routeDTO> obtenerPath(@RequestParam String path){ return api_routeService.obtenerPath(path);}

    @GetMapping("/Method")
    public List<Api_routeDTO> obtenerMethod(@RequestParam String method){ return api_routeService.obtenerMethod(method);}

    @GetMapping("/Tipo")
    public List<Api_routeDTO> obtenerTipo(@RequestParam String tipo){ return api_routeService.obtenerTipo(tipo);}











//
//    @GetMapping("path/")
//
//    public List<Api_routeDTO>obtenerPath (@RequestMapping Long id){
//        return api_routeSInterface.obtenerPath(id);
//    }
}
