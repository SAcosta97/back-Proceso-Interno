package com.backmantenedor.controller;

import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponseApplicationsPagination;
import com.backmantenedor.services.SecApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/SecApplications")
public class SecApplicationsController {



    @Autowired
    private SecApplicationsService secApp;


    @PostMapping("saveUpdateApplications")
    public SaveMantDTO saveUpdateApplications(@RequestBody @Validated SecApplicationsDTO App) throws Exception {
        return secApp.saveUpdateApplications(App);
    }

    @PostMapping("/consult")
    public ResponseApplicationsPagination consultApp (@RequestBody @Validated SearchDTO busqueda){ return secApp.consultApp(busqueda);}

    @GetMapping("/id")
    public List<SecApplicationsDTO> getId(@RequestParam long id){ return secApp.getIdApp(id);}



}
