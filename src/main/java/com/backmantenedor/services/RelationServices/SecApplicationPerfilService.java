package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryAppPerfil;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.mapper.SecApplicationPerfilMapper;
import com.backmantenedor.models.RelationModels.SecAppPerfilDTO;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.repository.RelationRepository.SecApplicationPerfilRepository;
import com.backmantenedor.repository.SecApplicationsRepository;
import com.backmantenedor.repository.SecPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecApplicationPerfilService {

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


    public SecAppPerfilDTO getPerfilApp_NotPerfilApp(Long idApp) {

        SecAppPerfilDTO secAppPerfilexit = new SecAppPerfilDTO();
      if(idApp != null){
          List<SecApplications> lsPerfilApp = secApplicationPerfilRepository.getApp(idApp);
          List<SecApplications> lsNotPerfilApp = secApplicationPerfilRepository.getNotApp();

          secAppPerfilexit.setPerfilApp(secApplicationPerfilMapper.toSecApplicationsToGetApplicationDTO(lsPerfilApp));
          secAppPerfilexit.setNotPerfilApp(secApplicationPerfilMapper.toSecApplicationsToGetApplicationDTO(lsNotPerfilApp));

      }
      return secAppPerfilexit;

    }

    public SaveMantDTO insertDeleteAppPerfil (EntryAppPerfil entryAppPerfil) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryAppPerfil.getFlagCreation()){

            //insert
           for(Long st: entryAppPerfil.getPerfilApp()){
               SecApplicationPerfil secAppPerfil = new SecApplicationPerfil();
               SecApplications secApplications = secApplicationsRepository.findById(entryAppPerfil.getIdApp()).get();
               secAppPerfil.setSecApplications(secApplications);
               SecPerfil perfilObt=secPerfilRepository.findById(st).get();

               secAppPerfil.setSecPerfil(perfilObt);

               secApplicationPerfilRepository.save(secAppPerfil);

               exit.setMessage("Roles asignados");
           }

        }else{
        //DELETE
        for(Long st: entryAppPerfil.getPerfilApp()) {

            SecApplicationPerfil secAppPerfil = new SecApplicationPerfil();
            secAppPerfil =secApplicationPerfilRepository.deleteId(entryAppPerfil.getIdApp(), st);


            if(secAppPerfil != null){

              secApplicationPerfilRepository.delete(secAppPerfil);
            }

        }

            exit.setMessage("Roles Eliminados");
        }

        return exit;
    }





}