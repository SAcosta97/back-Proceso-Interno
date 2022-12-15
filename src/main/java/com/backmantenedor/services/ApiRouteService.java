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


    public SaveMantDTO saveApi (ApiRouteDTO apiroutedto) throws Exception{

        SaveMantDTO apisalida = new SaveMantDTO();
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

            apisalida.setMessage("OK");

        }catch (NullPointerException nex){
            apisalida.setMessage("Uno de los campos obligatorios no fue enviado");
            return apisalida;
        }

        catch ( Exception ex){
            apisalida.setMessage(ex.getMessage());
        }
        return apisalida;
    }


    public List<MasterTypeElementsDTO> getMaterElement(String typeFilter){
        try{
            return masterTypeElementsMapper.masterTypeElementsToMasterTypeElementsDTO(masterTypeElementsRepository.findByTypeFilterAndStateReg(typeFilter, Boolean.TRUE));

        }catch (Exception ex){
            return new ArrayList();
        }
    }

    public List<ApiRouteDTO> getId (long id) {

        try{
            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }


    //PAGINADO
    public ResponseApiRoutePagination consultApi(SearchDTO searchDTO){

        ResponseApiRoutePagination exit = new ResponseApiRoutePagination();
        int totalReg = obtenerApiGeneral(searchDTO).size();
        if (totalReg > 0) {
            int page = searchDTO.getPage() > 0 ? (searchDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setApi(obtenerApiPag(pgRq, searchDTO));
            exit.setMessage("OK");
        }else {
            exit.setApi(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }


    public List<ApiRouteDTO> obtenerApiGeneral(SearchDTO busqueda){



            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.getAPiSinPag(busqueda.getTipo()));

    }


    public List<ApiRouteDTO> obtenerApiPag(Pageable pagineo, SearchDTO busqueda){

        return apirouteMapper.toApiRouteDTOPageList(apirouteRepository.getAPiFiltro(busqueda.getTipo(),pagineo));

    }



}
