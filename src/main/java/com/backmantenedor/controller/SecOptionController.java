package com.backmantenedor.controller;

import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponseApiRoutePagination;
import com.backmantenedor.models.Response.ResponseSecOptionPagination;
import com.backmantenedor.services.ApiRouteService;
import com.backmantenedor.services.SecOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/secOption")
public class SecOptionController {



    @Autowired
    private SecOptionService secOptionService;


    @PostMapping("saveUpdateSecOption")
    public SaveMantDTO saveApi(@RequestBody @Validated SecOptionDTO secOptionDTO) throws Exception {
        return secOptionService.saveOption(secOptionDTO);
    }
//    @GetMapping("/id")
//    public List<SecOptionDTO> getId(@RequestParam long id){ return api_routeService.getId(id);}

    @PostMapping("/consult")
    public ResponseSecOptionPagination consultEvent (@RequestBody @Validated SearchDTO busqueda){ return secOptionService.consultEvent(busqueda);}

//    @GetMapping("/TypeFilter")
//    public List<MasterTypeElementsDTO>getMaterElement(@RequestParam String typeFilter){ return api_routeService.getMaterElement(typeFilter); }
//
//
}
