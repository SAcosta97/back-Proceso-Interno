package com.backmantenedor.services;

import com.backmantenedor.mapper.ApirouteMapper;
import com.backmantenedor.models.Api_routeDTO;
import com.backmantenedor.repository.ApirouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Api_routeService {


    @Autowired
    private ApirouteMapper apirouteMapper;

    @Autowired
    private ApirouteRepository apirouteRepository;



//    public GuardarApirouteDTO guardarApi(Api_routeDTO api_routeDTO) throws Exception{
//
//
//        Api_route api =
//    }
    public List<Api_routeDTO> obtenerApi(long id) {

        try{
            return apirouteMapper.obtenerApiList(apirouteRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }


    }

    public List<Api_routeDTO> obtenerPath(String path) {

        try {
            return apirouteMapper.obtenerApiList(apirouteRepository.findByPath(path));
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

        public List<Api_routeDTO> obtenerMethod(String method) {

            try{
                return apirouteMapper.obtenerApiList(apirouteRepository.findByMethod(method));
            }
            catch (Exception ex){
                return new ArrayList<>();
            }
        }

        public List<Api_routeDTO> obtenerTipo(String tipo) {

            try{
                return apirouteMapper.obtenerApiList(apirouteRepository.findByTipo(tipo));
            }
            catch (Exception ex){
                return new ArrayList<>();
            }
        }




}
