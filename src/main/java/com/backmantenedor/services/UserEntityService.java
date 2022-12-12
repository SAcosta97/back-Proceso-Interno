package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.mapper.SecPerfilMapper;
import com.backmantenedor.models.GuardarApirouteDTO;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.models.UserEntityDTO;
import com.backmantenedor.repository.SecPerfilRepository;
import com.backmantenedor.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

//    @Autowired
//    private SecPerfilMapper secPerfilMapper;

//    @Autowired
//    private Utility utility;


    public GuardarApirouteDTO guardarUser(UserEntityDTO userEntityDTO) throws Exception {

        GuardarApirouteDTO usersalida = new GuardarApirouteDTO();
        try {

            //crear
            UserEntity userEntity = new UserEntity();

            if (userEntityDTO.getId() != null) {
                userEntity.setId(userEntityDTO.getId());
//                userEntity.s(utility.obtenergetdateNow());
                userEntity.setUserUpdate(userEntityDTO.getUserUpdate());
            }
            userEntity.setUsername(userEntityDTO.getUsername());
            userEntity.setFirstName(userEntityDTO.getFirstName());
            userEntity.setLastName(userEntityDTO.getFirstName());
            userEntity.setEmail(userEntityDTO.getEmail());
            userEntity.setEnable(userEntityDTO.getEnable());
            userEntity.setUserCreation(userEntityDTO.getUserCreation());


            this.userEntityRepository.save(userEntity);

            usersalida.setMensaje("OK");

        }catch (NullPointerException nex){
            usersalida.setMensaje("Uno de los campos obligatorios no fue enviado");
            return usersalida;
        }

        catch ( Exception ex){
            usersalida.setMensaje(ex.getMessage());
        }
        return usersalida;
    }

//    public List<SecPerfilDTO> obtenerperfil() {
//
//        try{
//            return secPerfilMapper.secPerfilToSecPerfilDTO(userEntityRepository.findAll());
//        }
//        catch (Exception ex){
//            return new ArrayList<>();
//        }
//
//    }
//
//    public List<SecPerfilDTO> ObtenerIdPerfil(long id) {
//
//        try{
//            return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.findAllById(id));
//        }
//        catch (Exception ex){
//            return new ArrayList<>();
//        }
//
//    }


}