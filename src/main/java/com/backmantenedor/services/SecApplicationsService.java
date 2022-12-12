package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.mapper.SecApplicationsMapper;
import com.backmantenedor.mapper.SecPerfilMapper;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.repository.SecApplicationsRepository;
import com.backmantenedor.repository.SecPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecApplicationsService {

    @Autowired
    private SecApplicationsRepository secApplicationsRepository;

    @Autowired
    private SecApplicationsMapper secApplicationsMapper;

    @Autowired
    private Utility utility;



    public GuardarApirouteDTO guardarApplicatoins (SecApplicationsDTO secApplicationsDTO) throws Exception {

        GuardarApirouteDTO applsalida = new GuardarApirouteDTO();
        try {

            //crear
            SecApplications secApplications = new SecApplications();

            if (secApplicationsDTO.getId() != null) {
                secApplications.setId(secApplicationsDTO.getId());
                secApplications.setDateUpdate(utility.obtenergetdateNow());
                secApplications.setUserUpdate(secApplicationsDTO.getUserUpdate());
            }
            secApplications.setName(secApplicationsDTO.getName());
            secApplications.setAudit(secApplicationsDTO.getAudit());
            secApplications.setDateRegistr(utility.obtenergetdateNow());
            secApplications.setStatus(secApplicationsDTO.getStatus());
            secApplications.setDescription(secApplicationsDTO.getDescription());
            secApplications.setUserCreation(secApplicationsDTO.getUserCreation());



            this.secApplicationsRepository.save(secApplications);

            applsalida.setMensaje("OK");

        }catch (NullPointerException nex){
            applsalida.setMensaje("Uno de los campos obligatorios no fue enviado");
            return applsalida;
        }

        catch ( Exception ex){
            applsalida.setMensaje(ex.getMessage());
        }
        return applsalida;
    }

    public List<SecApplicationsDTO> obtenerApp() {

        try{
            return secApplicationsMapper.secApplicationsToSecApplicationsDTO(secApplicationsRepository.findAll());
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }

    public List<SecApplicationsDTO> ObtenerIdApp(long id) {

        try{
            return secApplicationsMapper.secApplicationsToSecApplicationsDTO(secApplicationsRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }


}