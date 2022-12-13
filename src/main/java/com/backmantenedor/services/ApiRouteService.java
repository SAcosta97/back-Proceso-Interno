package com.backmantenedor.services;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.mapper.ApiRouteMapper;
import com.backmantenedor.mapper.MasterTypeElementsMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.repository.ApiRouterRepositor;
import com.backmantenedor.repository.ApirouteRepository;
import com.backmantenedor.repository.MasterTypeElementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiRouteService {


    @Autowired
    private ApiRouteMapper apirouteMapper;

    @Autowired
    private ApirouteRepository apirouteRepository;

    @Autowired
    private MasterTypeElementsMapper masterTypeElementsMapper;

    @Autowired
    private MasterTypeElementsRepository masterTypeElementsRepository;

    @Autowired
    private ApiRouterRepositor apiRouterRepositor;


    public GuardarApirouteDTO guardarApi(ApiRouteDTO apiroutedto) throws Exception{

        GuardarApirouteDTO apisalida = new GuardarApirouteDTO();
        try{
//            if(apiroutedto!=null){
//                apisalida.setMensaje("debe enviar un valor valido");

                //crear
                ApiRoute apiRoute = new ApiRoute();
                if(apiroutedto.getId()!=null){
                    apiRoute.setId(apiroutedto.getId());
                    apiRoute.setUserUpdate(apiroutedto.getUserUpdate());
                }
                apiRoute.setPath(apiroutedto.getPath());
                apiRoute.setMethod(apiroutedto.getMethod());
                apiRoute.setUri(apiroutedto.getUri());
                apiRoute.setEstado(apiroutedto.getEstado());
                apiRoute.setIp(apiroutedto.getIp());
                apiRoute.setTipo(apiroutedto.getTipo());
                apiRoute.setUserCreation(apiroutedto.getUserCreation());

                this.apirouteRepository.save(apiRoute);

            apisalida.setMensaje("OK");

        }catch (NullPointerException nex){
            apisalida.setMensaje("Uno de los campos obligatorios no fue enviado");
            return apisalida;
        }

        catch ( Exception ex){
            apisalida.setMensaje(ex.getMessage());
        }
        return apisalida;
    }

    public List<ApiRouteDTO> obtenerApiroute(ApiDataDTO data) {

        try{
            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findByTipo(/*data.getMethod(),*/ data.getTipo()));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }

    public List<MasterTypeElementsDTO> getMaterElement(String typeFilter){
        try{
            return masterTypeElementsMapper.masterTypeElementsToMasterTypeElementsDTO(masterTypeElementsRepository.findByTypeFilterAndStateReg(typeFilter, Boolean.TRUE));

        }catch (Exception ex){
            return new ArrayList();
        }
    }

    public List<ApiRouteDTO> obtenerApi(long id) {

        try{
            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }

    public ResponseApiRoutePagineo consultaApi(BusquedaDTO busquedaDTO){

        ResponseApiRoutePagineo salida = new ResponseApiRoutePagineo();
        int totalReg = obtenerApiGeneral(busquedaDTO).size();
        if (totalReg > 0) {
            int page = busquedaDTO.getPage() > 0 ? (busquedaDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, busquedaDTO.getReg_por_pag());
            salida.setTotalRegistro(totalReg);
            salida.setApi(obtenerApiPag(pgRq, busquedaDTO));
            salida.setMensaje("OK");
        }else {
            salida.setApi(null);
            salida.setTotalRegistro(0);
            salida.setMensaje("No existen datos");

        }
        return salida;
    }

        //PAGINADO
    public List<ApiRouteDTO> obtenerApiGeneral(BusquedaDTO busqueda){
        if (busqueda.getFechaIni() != null && busqueda.getFechaFin() != null && !busqueda.getFechaIni().equals("") && !busqueda.getFechaFin().equals("")) {
            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.getAPiSinPag(busqueda.getFechaIni(), busqueda.getFechaFin()));
        }
        return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findAll());
    }


    public List<ApiRouteDTO> obtenerApiPag(Pageable pagineo, BusquedaDTO busqueda){

        if(busqueda.getFechaIni() != null && busqueda.getFechaFin()!=null && !busqueda.getFechaIni().equals("") && !busqueda.getFechaFin().equals("")){

            return apirouteMapper.toApiRouteDTOPageList(apirouteRepository.getAPiFiltro(busqueda.getFechaIni(), busqueda.getFechaFin(),pagineo));
        }
        return apirouteMapper.toApiRouteDTOPageList(apirouteRepository.findAll(pagineo));

    }





}
