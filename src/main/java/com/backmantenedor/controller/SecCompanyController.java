package com.backmantenedor.controller;

import com.backmantenedor.models.*;
import com.backmantenedor.services.SecCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/SecCompany")
public class SecCompanyController {



    @Autowired
    private SecCompanyService secCompany;


    @PostMapping("saveUpdateSecCompany")
    public SaveMantDTO saveUpdateSecCompany(@RequestBody @Validated SecCompanyDTO Company ) throws Exception {
        return secCompany.saveUpdateSecCompany(Company);
    }

    @PostMapping("/consult")
    public ResponseCompanyPagination consultCompany (@RequestBody @Validated SearchDTO busqueda){ return secCompany.consultCompany(busqueda);}


    @GetMapping("/id")
    public List<SecCompanyDTO> getId(@RequestParam long id){ return secCompany.getIdCompany(id);}




}
