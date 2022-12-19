package com.backmantenedor.services;

import com.backmantenedor.Util.UserEntityObject;
import com.backmantenedor.mapper.UserEntityMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponseUserPagination;
import com.backmantenedor.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

//    @Autowired
//    private SecCompanyRepository secCompanyRepository;


    @Autowired
    private UserEntityMapper userEntityMapper;



//    public SaveMantDTO saveUpdateUserEntity (UserEntityDTO userEntityDTO) throws Exception {
//
//        SaveMantDTO exit = new SaveMantDTO();
//        try {
//
//            //crear
//            UserEntity userEntity = new UserEntity();
////            SecUserCompany userCompany = new SecUserCompany();
//
//            if (userEntityDTO.getId() != null) {
//
//                userEntity.setUserUpdate(userEntityDTO.getUserUpdate());
//            }
//
//            userEntity.setId(userEntityDTO.getId());
//            userEntity.setUsername(userEntityDTO.getUsername());
//            userEntity.setEmail(userEntityDTO.getEmail());
//            userEntity.setFirstName(userEntityDTO.getFirstName());
//            userEntity.setLastName(userEntityDTO.getLastName());
//            userEntity.setEnable(userEntityDTO.getEnable());
//            userEntity.setUserCreation(userEntityDTO.getUserCreation());
//            userEntity.setUserCompany(null);
////            userEntity.setUserCompany();
////            userEntity.setRealmEntity();
//
//            this.userEntityRepository.save(userEntity);
//
//            exit.setMessage("OK");
//
//        }catch (NullPointerException nex){
//            exit.setMessage("Uno de los campos obligatorios no fue enviado");
//            return exit;
//        }
//
//        catch ( Exception ex){
//            exit.setMessage(ex.getMessage());
//        }
//        return exit;
//    }


    public ResponseUserPagination consultusuario (SearchDTO busqueda){

        ResponseUserPagination exit = new ResponseUserPagination();
        int totalReg = userEntityRepository.cantityUserPag(busqueda.getUsername());
        if (totalReg > 0) {
            int page = busqueda.getPage() > 0 ? (busqueda.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, busqueda.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setUser(getUserPagination(pgRq, busqueda));
            exit.setMessage("OK");
        }else {
            exit.setUser(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }

    public List<UserEntityObject> getUserPagination(PageRequest pgRq, SearchDTO search)
    {
        List<UserEntityObject> lsSalida=new ArrayList<>();
        Page<Object[]>  userEntityObjectLis =  userEntityRepository.getUserSinPag(search.getUsername(), pgRq);


        for (Object[] objects : userEntityObjectLis)
        {
            UserEntityObject userDTO=new UserEntityObject();
            userDTO.setId(objects[0].toString());
            userDTO.setUsername(objects[1].toString());
            userDTO.setLastName(objects[3].toString());
            userDTO.setEmail(objects[2].toString());
            userDTO.setFirstName(objects[4].toString());
            userDTO.setRealme(objects[5].toString());
            userDTO.setObservation(objects[8].toString());
            userDTO.setNameCompany(objects[6].toString());
            userDTO.setRuc(objects[7].toString());
            lsSalida.add(userDTO);
        }
        return lsSalida;
    }





    public List<GetUserDTO> getUserNotCompany() {

        try {
            return userEntityMapper.userEntityToUserEntityDTO(userEntityRepository.getUserNotCompany());
        } catch (Exception ex) {
            return new ArrayList<>();
        }

    }
}