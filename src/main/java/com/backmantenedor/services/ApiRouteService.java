package com.backmantenedor.services;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.mapper.ApirouteMapper;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.repository.ApirouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApiRouteService {


    @Autowired
    private ApirouteMapper apirouteMapper;

    @Autowired
    private ApirouteRepository apirouteRepository;



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
                apiRoute.setIp(apiroutedto.getIp());
                apiRoute.setTipo(apiroutedto.getTipo());

                //Actualiza
                ApiRoute api = new ApiRoute();
                if(apiroutedto.getId()==null){
                    ApiRoute apiencontrada =new ApiRoute();
                    if(apiencontrada != null){
                        Optional<ApiRoute> verificar = this.apirouteRepository.findById(apiencontrada.getId());
                        if (verificar.isPresent()){
                            throw new Exception(MessageFormat.format("Uri {0} ya se encuentra registrada{1}."));
                        }
                    }

                    apiroutedto.setEstado(Boolean.TRUE);

                }
                this.apirouteRepository.save(apiRoute);

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



    public List<ApiRouteDTO> obtenerApi(long id) {

        try{
            return apirouteMapper.obtenerApiList(apirouteRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }


    }

    public List<ApiRouteDTO> obtenerPath(String path) {

        try {
            return apirouteMapper.obtenerApiList(apirouteRepository.findByPath(path));
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

        public List<ApiRouteDTO> obtenerMethod(String method) {

            try{
                return apirouteMapper.obtenerApiList(apirouteRepository.findByMethod(method));
            }
            catch (Exception ex){
                return new ArrayList<>();
            }
        }

        public List<ApiRouteDTO> obtenerTipo(String tipo) {

            try{
                return apirouteMapper.obtenerApiList(apirouteRepository.findByTipo(tipo));
            }
            catch (Exception ex){
                return new ArrayList<>();
            }
        }




}
