package com.backmantenedor.services;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.mapper.ApiRouteMapper;
import com.backmantenedor.mapper.MasterTypeElementsMapper;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.MasterTypeElementsDTO;
import com.backmantenedor.repository.ApirouteRepository;
import com.backmantenedor.repository.MasterTypeElementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public GuardarApirouteDTO guardarApi(ApiRouteDTO apiroutedto) throws Exception{

        GuardarApirouteDTO apisalida = new GuardarApirouteDTO();
        try{
            if(apiroutedto==null){
                apisalida.setMensaje("debe enviar un valor valido");

                //crear
                ApiRoute apiRoute = new ApiRoute();
                apiRoute.setId(apiroutedto.getId());
                apiRoute.setPath(apiroutedto.getPath());
                apiRoute.setMethod(apiroutedto.getMethod());
                apiRoute.setUri(apiroutedto.getUri());
                apiRoute.setEstado(apiroutedto.getEstado());
                apiRoute.setIp(apiroutedto.getIp());
                apiRoute.setTipo(apiroutedto.getTipo());

                this.apirouteRepository.save(apiRoute);

                } else {
                //Actualiza
                if(apiroutedto.getId()==null){
                    ApiRoute apiencontrada =new ApiRoute();
                    if(apiencontrada != null){
                        ApiRoute verificar = this.apirouteRepository.findById(apiencontrada.getId()).get();
                        verificar.setPath(apiroutedto.getPath());
                        verificar.setMethod(apiroutedto.getMethod());
                        verificar.setUri(apiroutedto.getUri());
                        verificar.setEstado(apiroutedto.getEstado());
                        verificar.setIp(apiroutedto.getIp());
                    }
                }
            }

        }catch (NullPointerException nex){
            apisalida.setMensaje("Uno de los campos obligatorios no fue enviado");
            return apisalida;
        }

        catch ( Exception ex){
            apisalida.setMensaje(ex.getMessage());
        }
        return apisalida;
    }

    public List<ApiRouteDTO> obtenerApiroute() {

        try{
            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findAll());
        }
        catch (Exception ex){
            return new ArrayList<>();
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

    public List<ApiRouteDTO> obtenerPath(String path) {

        try {
            return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findByPath(path));
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

        public List<ApiRouteDTO> obtenerMethod(String method) {

            try{
                return apirouteMapper.apiRouteLsToApiRouteDTO(apirouteRepository.findByMethod(method));
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





}
