package com.backmantenedor.controller;

import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecCompanyDTO;
import com.backmantenedor.services.SecApplicationsService;
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


    @PostMapping("guardarActualizarSecCompany")
    public GuardarApirouteDTO guardarPerfil(@RequestBody @Validated SecCompanyDTO Company ) throws Exception {
        return secCompany.guardarApplicatoins(Company);
    }


    @GetMapping("/id")
    public List<SecCompanyDTO> obtenerId(@RequestParam long id){ return secCompany.ObtenerIdCompany(id);}


    @GetMapping("/Perfil")
    public List<SecCompanyDTO> obtenerApp(){ return secCompany.obtenerCompany();}


}
