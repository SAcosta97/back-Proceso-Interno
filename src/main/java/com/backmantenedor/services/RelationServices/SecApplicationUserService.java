package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryAppPerfil;
import com.backmantenedor.Util.EntryAppUser;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.mapper.SecApplicationPerfilMapper;
import com.backmantenedor.models.RelationModels.SecAppPerfilDTO;
import com.backmantenedor.models.RelationModels.SecAppUserDTO;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.repository.RelationRepository.SecApplicationPerfilRepository;
import com.backmantenedor.repository.SecApplicationsRepository;
import com.backmantenedor.repository.SecPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecApplicationUserService {

    @Autowired
    private SecApplicationPerfilRepository secApplicationPerfilRepository;

    @Autowired
    private SecApplicationPerfilMapper secApplicationPerfilMapper;

    @Autowired
    private SecApplicationsRepository secApplicationsRepository;

    @Autowired
    private SecPerfilRepository secPerfilRepository;

    @Autowired
    private Utility utility;


    public SecAppUserDTO getUserApp_NotUserApp(Long idApp) {

        SecAppUserDTO secAppuserexit = new SecAppUserDTO();
      if(idApp != null){
          List<SecApplications> lsUserApp = secApplicationPerfilRepository.getApp(idApp);
          List<SecApplications> lsNotUserApp = secApplicationPerfilRepository.getNotApp();

          secAppuserexit.setPerfilApp(secApplicationPerfilMapper.toSecApplicationsToGetApplicationDTO(lsUserApp));
          secAppuserexit.setNotPerfilApp(secApplicationPerfilMapper.toSecApplicationsToGetApplicationDTO(lsNotUserApp));

      }
      return secAppuserexit;

    }

    public SaveMantDTO insertDeleteAppUser (EntryAppUser entryAppUser) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryAppUser.getFlagCreation()){

            //insert
           for(Long st: entryAppUser.getUserApp()){
               SecApplicationPerfil secAppPerfil = new SecApplicationPerfil();
               SecApplications secApplications = secApplicationsRepository.findById(entryAppUser.getIdApp()).get();
               secAppPerfil.setSecApplications(secApplications);
               SecPerfil perfilObt=secPerfilRepository.findById(st).get();

               secAppPerfil.setSecPerfil(perfilObt);

               secApplicationPerfilRepository.save(secAppPerfil);

               exit.setMessage("Roles asignados");
           }

        }else{
        //DELETE
        for(Long st: entryAppUser.getUserApp()) {

            SecApplicationPerfil secAppPerfil = new SecApplicationPerfil();
            secAppPerfil =secApplicationPerfilRepository.deleteId(entryAppUser.getIdApp(), st);


            if(secAppPerfil != null){

              secApplicationPerfilRepository.delete(secAppPerfil);
            }

        }

            exit.setMessage("Roles Eliminados");
        }

        return exit;
    }





}