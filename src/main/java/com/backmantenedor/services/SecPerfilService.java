package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.mapper.SecPerfilMapper;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.repository.SecPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecPerfilService {

    @Autowired
    private SecPerfilRepository secPerfilRepository;

    @Autowired
    private SecPerfilMapper secPerfilMapper;

    @Autowired
    private Utility utility;



    public GuardarApirouteDTO guardarPerfil (SecPerfilDTO secPerfilDTO) throws Exception {

        GuardarApirouteDTO perfilsalida = new GuardarApirouteDTO();
        try {

            //crear
            SecPerfil secPerfil = new SecPerfil();

            if (secPerfilDTO.getId() != null) {
                secPerfil.setId(secPerfilDTO.getId());
                secPerfil.setDateUpdate(utility.obtenergetdateNow());
                secPerfil.setUserUpdate(secPerfilDTO.getUserUpdate());
            }
            secPerfil.setNombrePerfil(secPerfilDTO.getNombrePerfil());
            secPerfil.setAudit(secPerfilDTO.getAudit());
            secPerfil.setDateRegistr(utility.obtenergetdateNow());
            secPerfil.setEstado(secPerfilDTO.getEstado());
            secPerfil.setObserva(secPerfilDTO.getObserva());
            secPerfil.setUserCreation(secPerfilDTO.getUserCreation());


            this.secPerfilRepository.save(secPerfil);

            perfilsalida.setMensaje("OK");

        }catch (NullPointerException nex){
            perfilsalida.setMensaje("Uno de los campos obligatorios no fue enviado");
            return perfilsalida;
        }

        catch ( Exception ex){
            perfilsalida.setMensaje(ex.getMessage());
        }
        return perfilsalida;
    }

    public List<SecPerfilDTO> obtenerperfil() {

        try{
            return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.findAll());
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }

    public List<SecPerfilDTO> ObtenerIdPerfil(long id) {

        try{
            return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }




}