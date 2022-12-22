package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryAppPerfil;
import com.backmantenedor.Util.EntryAppUser;
import com.backmantenedor.Util.EntryUserPerfil;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecUserPerfil;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.mapper.SecApplicationPerfilMapper;
import com.backmantenedor.mapper.SecUsersPerfilMapper;
import com.backmantenedor.models.RelationModels.SecAppPerfilDTO;
import com.backmantenedor.models.RelationModels.SecAppUserDTO;
import com.backmantenedor.models.RelationModels.SecUsersPerfilDTO;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.repository.RelationRepository.SecApplicationPerfilRepository;
import com.backmantenedor.repository.RelationRepository.SecApplicationUserRepository;
import com.backmantenedor.repository.RelationRepository.SecUserPerfilRepository;
import com.backmantenedor.repository.SecApplicationsRepository;
import com.backmantenedor.repository.SecPerfilRepository;
import com.backmantenedor.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecUsersPerfilService {

    @Autowired
    private SecUserPerfilRepository secUserPerfilRepository;

    @Autowired
    private SecUsersPerfilMapper secUsersPerfilMapper;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private SecPerfilRepository secPerfilRepository;

    @Autowired
    private Utility utility;


    public SecUsersPerfilDTO getUserPerfil_NotUserPerfil(Long idPerfil) {

        SecUsersPerfilDTO secusersPerfilexit = new SecUsersPerfilDTO();
      if(idPerfil != null){
          List<UserEntity> lsUserPerfil = secUserPerfilRepository.getApp(idPerfil);
          List<UserEntity> lsNotUserPerfil = secUserPerfilRepository.getNotApp();

          secusersPerfilexit.setUserperfil(secUsersPerfilMapper.toUserEntityToGetUserDTO(lsUserPerfil));
          secusersPerfilexit.setNotUserPerfil(secUsersPerfilMapper.toUserEntityToGetUserDTO(lsNotUserPerfil));

      }
      return secusersPerfilexit;

    }

    public SaveMantDTO insertDeleteUserPerfil (EntryUserPerfil entryUserPerfil) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryUserPerfil.getFlagCreation())
        {
            //insert
           for(String st: entryUserPerfil.getUsersperfil()){
               SecUserPerfil secUserPerfil = new SecUserPerfil();
               SecPerfil secPerfil = secPerfilRepository.findById(entryUserPerfil.getIdPerfil()).get();
               SecUserPerfil userPerfil = new SecUserPerfil();
               userPerfil.setSecPerfil(secPerfil);
//               List<SecUserPerfil>  secUserPerfilS=secPerfil.stream().filter(x->(x.getSecApplications().getId().equals(entryAppPerfil.getIdApp()) && x.getSecPerfil().getId().equals(st))).collect(Collectors.toList());

//                   if(!secApplicationPerfilsS.isEmpty())
//               {
//                   exit.setMessage("Perfil ya tiene una App asignada");
//                   exit.setSuccess(false);

               UserEntity userObt=userEntityRepository.findById(st).get();
               secUserPerfil.setUserEntity(userObt);

                   secUserPerfilRepository.save(secUserPerfil);

                   exit.setMessage("Usuarios asignados");
                   exit.setSuccess(true);
               }


        }else{
        //DELETE
        for(String st: entryUserPerfil.getUsersperfil()) {

            SecUserPerfil secUserPerfil = new SecUserPerfil();
            secUserPerfil =secUserPerfilRepository.deleteId(entryUserPerfil.getIdPerfil(), st);


            if(secUserPerfil != null){

              secUserPerfilRepository.delete(secUserPerfil);
            }

        }

            exit.setMessage("Usuarios Eliminados");
        }

        return exit;
    }





}