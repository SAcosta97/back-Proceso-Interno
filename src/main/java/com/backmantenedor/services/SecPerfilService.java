package com.backmantenedor.services;

import com.backmantenedor.Util.PerfilDataDTO;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.mapper.SecPerfilMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.repository.SecPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        //BUSQUEDA
    public List<SecPerfilDTO> obtenerperfil( PerfilDataDTO perfildata) {

        try{
            return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.findByNombrePerfil(perfildata.getNombrePerfil()));
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

    //PAGINADO
    public ResponsePerfilPagineo obtenerPerfil(BusquedaDTO busquedaDTO){

        ResponsePerfilPagineo salida = new ResponsePerfilPagineo();
        int totalReg = obtenerPerfilGeneral(busquedaDTO).size();
        if (totalReg > 0) {
            int page = busquedaDTO.getPage() > 0 ? (busquedaDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, busquedaDTO.getReg_por_pag());
            salida.setTotalRegistro(totalReg);
            salida.setPerfil(obtenerPerfilPag(pgRq, busquedaDTO));
            salida.setMensaje("OK");
        }else {
            salida.setPerfil(null);
            salida.setTotalRegistro(0);
            salida.setMensaje("No existen datos");

        }
        return salida;
    }


    public List<SecPerfilDTO> obtenerPerfilGeneral(BusquedaDTO busqueda){
        if (busqueda.getFechaIni() != null && busqueda.getFechaFin() != null && !busqueda.getFechaIni().equals("") && !busqueda.getFechaFin().equals("")) {
            return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.getPerfilSinPag(busqueda.getFechaIni(), busqueda.getFechaFin()));
        }
        return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.findAll());
    }


    public List<SecPerfilDTO> obtenerPerfilPag(Pageable pagineo, BusquedaDTO busqueda){

        if(busqueda.getFechaIni() != null && busqueda.getFechaFin()!=null && !busqueda.getFechaIni().equals("") && !busqueda.getFechaFin().equals("")){

            return secPerfilMapper.toPerfilDTOPageList(secPerfilRepository.getPerfilFiltro(busqueda.getFechaIni(), busqueda.getFechaFin(),pagineo));
        }
        return secPerfilMapper.toPerfilDTOPageList(secPerfilRepository.findAll(pagineo));

    }




}