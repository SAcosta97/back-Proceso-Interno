package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryAppUser;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecApplicationUser;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.mapper.SecAppUserMapper;
import com.backmantenedor.models.RelationModels.SecAppUserDTO;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.repository.RelationRepository.SecApplicationUserRepository;
import com.backmantenedor.repository.SecApplicationsRepository;
import com.backmantenedor.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecApplicationUserService {

    @Autowired
    private SecApplicationUserRepository secApplicationUserRepository;

    @Autowired
    private SecAppUserMapper secAppUserMapper;

    @Autowired
    private SecApplicationsRepository secApplicationsRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;


    @Autowired
    private Utility utility;


    public SecAppUserDTO getUserApp_NotUserApp(Long idApp) {

        SecAppUserDTO secAppuserexit = new SecAppUserDTO();
      if(idApp != null){
          List<UserEntity> lsUserApp = secApplicationUserRepository.getApp(idApp);
          List<UserEntity> lsNotUserApp = secApplicationUserRepository.getNotApp();

          secAppuserexit.setUserApp(secAppUserMapper.toUserEntityToUserEntityDTO(lsUserApp));
          secAppuserexit.setNotUserApp(secAppUserMapper.toUserEntityToUserEntityDTO(lsNotUserApp));

      }
      return secAppuserexit;

    }

    public SaveMantDTO insertDeleteAppUser (EntryAppUser entryAppUser) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryAppUser.getFlagCreation()){

            List<SecApplicationUser> secApplicationUsers= secApplicationUserRepository.findAllBy();
            SecApplications secApplications = secApplicationsRepository.findById(entryAppUser.getIdApp()).get();
            SecApplicationUser secApplicationUser = new SecApplicationUser();
            secApplicationUser.setSecApplications(secApplications);

//insert
            for(String st: entryAppUser.getUserApp()) {

                List<SecApplicationUser>  secApplicationUsersS=secApplicationUsers.stream().filter(x->(x.getSecApplications().getId().equals(entryAppUser.getIdApp()) && x.getUserEntity().getId().equals(st))).collect(Collectors.toList());


                if (!secApplicationUsersS.isEmpty()) {
                    exit.setMessage( "Usuario ya tiene una App asignada");
                    exit.setSuccess(false);

                    } else{
                    UserEntity userObt = userEntityRepository.findById(st).get();
                    secApplicationUser.setUserEntity(userObt);
                    secApplicationUserRepository.save(secApplicationUser);

                    exit.setMessage("Usuario asignados");
                    exit.setSuccess(true);
                }
            }
        }else{
        //DELETE
        for(String st: entryAppUser.getUserApp()) {

            SecApplicationUser secAppUser = new SecApplicationUser();
            secAppUser =secApplicationUserRepository.deleteId(entryAppUser.getIdApp(), st);


            if(secAppUser != null){

              secApplicationUserRepository.delete(secAppUser);
            }

        }

            exit.setMessage("Ususarios Eliminados");
        }

        return exit;
    }





}