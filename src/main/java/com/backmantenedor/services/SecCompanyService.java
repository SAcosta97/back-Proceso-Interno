package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecCompany;
import com.backmantenedor.mapper.SecApplicationsMapper;
import com.backmantenedor.mapper.SecCompanyMapper;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecCompanyDTO;
import com.backmantenedor.repository.SecApplicationsRepository;
import com.backmantenedor.repository.SecCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecCompanyService {

    @Autowired
    private SecCompanyRepository secCompanyRepository;

    @Autowired
    private SecCompanyMapper secCompanyMapper;

    @Autowired
    private Utility utility;



    public GuardarApirouteDTO guardarApplicatoins (SecCompanyDTO secCompanyDTO) throws Exception {

        GuardarApirouteDTO companysalida = new GuardarApirouteDTO();
        try {

            //crear
            SecCompany secCompany = new SecCompany();

            if (secCompanyDTO.getId() != null) {
                secCompany.setId(secCompanyDTO.getId());
                secCompany.setDateUpdate(utility.obtenergetdateNow());
                secCompany.setUserUpdate(secCompanyDTO.getUserUpdate());
            }
            secCompany.setName(secCompanyDTO.getName());
            secCompany.setRuc(secCompanyDTO.getRuc());
            secCompany.setAudit(secCompanyDTO.getAudit());
            secCompany.setDateRegistr(utility.obtenergetdateNow());
            secCompany.setStatus(secCompanyDTO.getStatus());
            secCompanyDTO.setObservation(secCompanyDTO.getObservation());
            secCompanyDTO.setUserCreation(secCompanyDTO.getUserCreation());

            this.secCompanyRepository.save(secCompany);

            companysalida.setMensaje("OK");

        }catch (NullPointerException nex){
            companysalida.setMensaje("Uno de los campos obligatorios no fue enviado");
            return companysalida;
        }

        catch ( Exception ex){
            companysalida.setMensaje(ex.getMessage());
        }
        return companysalida;
    }

    public List<SecCompanyDTO> obtenerCompany() {

        try{
            return secCompanyMapper.secCompanyToSecCompanyDTO(secCompanyRepository.findAll());
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }

    public List<SecCompanyDTO> ObtenerIdCompany(long id) {

        try{
            return secCompanyMapper.secCompanyToSecCompanyDTO(secCompanyRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }


}