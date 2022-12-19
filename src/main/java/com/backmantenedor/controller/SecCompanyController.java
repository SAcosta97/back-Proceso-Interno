package com.backmantenedor.controller;

import com.backmantenedor.models.*;
import com.backmantenedor.services.SecCompanyService;
import com.backmantenedor.services.SecUserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/SecCompany")
public class SecCompanyController {


    @Autowired
    private SecCompanyService secCompany;

    @Autowired
    SecUserCompanyService secUserCompanyService;


    @PostMapping("saveUpdateSecCompany")
    public SaveMantDTO saveUpdateSecCompany(@RequestBody @Validated SecCompanyDTO secCompanyDTO ) throws Exception {
        return secCompany.saveUpdateSecCompany(secCompanyDTO);
    }

    @PostMapping("/consult")
    public ResponseCompanyPagination consultCompany (@RequestBody @Validated SearchDTO busqueda){ return secCompany.consultCompany(busqueda);}


    @GetMapping("UsersComp")
    public SecUserCompanyDTO getUsersCompany_NotCompany (@RequestParam Long idCompany){ return secUserCompanyService.getUsersCompany_NotCompany(idCompany);}

    @PostMapping("insertDeleteUserComp")
    public SaveMantDTO insertDeleteUserComp(@RequestBody @Validated EntryUserCompany entryUserCompany ) throws Exception {
        return secUserCompanyService.insertDeleteUserComp(entryUserCompany);
    }




}
