package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryResourcePerfilOption;
import com.backmantenedor.Util.EntryRolPerfil;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.*;
import com.backmantenedor.entity.RelationEntity.SecResourcePerfilOption;
import com.backmantenedor.entity.RelationEntity.SecRolPerfil;
import com.backmantenedor.mapper.SecResourcePerfilOptionMapper;
import com.backmantenedor.mapper.SecRolPerfilMapper;
import com.backmantenedor.models.RelationModels.SecResourcePerfilOptionDTO;
import com.backmantenedor.models.RelationModels.SecRolPerfilDTO;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.repository.*;
import com.backmantenedor.repository.RelationRepository.SecResourcePerfilOptionRepository;
import com.backmantenedor.repository.RelationRepository.SecRolPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecResourcePerfilOptionService {

    @Autowired
    private SecOptionRepository secOptionRepository;

    @Autowired
    private SecResourcePerfilOptionMapper secResourcePerfilOptionMapper;

    @Autowired
    private ApirouteRepository apirouteRepository;

    @Autowired
    private SecResourcePerfilOptionRepository secResourcePerfilOptionRepository;

    @Autowired
    private Utility utility;


    public SecResourcePerfilOptionDTO getApiOption_NotApiOption(Long idApi) {

        SecResourcePerfilOptionDTO exit = new SecResourcePerfilOptionDTO();
      if(idApi != null){
          List<SecOption>  lsAPi = secResourcePerfilOptionRepository.getApi(idApi);
          List<SecOption> lsNotApi = secResourcePerfilOptionRepository.getNotApi();

          exit.setEventApi(secResourcePerfilOptionMapper.toApiRouteToUserGetApiDTO(lsAPi));
          exit.setEventNotApi(secResourcePerfilOptionMapper.toApiRouteToUserGetApiDTO(lsNotApi));

      }
      return exit;

    }

    public SaveMantDTO insertDeleteApiOption (EntryResourcePerfilOption entryResourcePerfilOption) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryResourcePerfilOption.getFlagCreation()){

            List<SecResourcePerfilOption> secResourcePerfilOptions= secResourcePerfilOptionRepository.findAllBy();
            ApiRoute apiRoute = apirouteRepository.findById(entryResourcePerfilOption.getIdApiroute()).get();
            SecResourcePerfilOption secResourcePerfilOption = new SecResourcePerfilOption();
            secResourcePerfilOption.setApiRoute(apiRoute);

            //insert
           for(Long st: entryResourcePerfilOption.getApievent()){

               List<SecResourcePerfilOption>  secResourcePerfilOptionsS=secResourcePerfilOptions.stream().filter(x->(x.getApiRoute().getId().equals(entryResourcePerfilOption.getIdApiroute()) && x.getApiRoute().getId().equals(st))).collect(Collectors.toList());

               if( !secResourcePerfilOptionsS.isEmpty()){
                   exit.setMessage("Este perfil ya tiene un rol asignado");
                   exit.setSuccess(false);

               } else{
                   SecOption optionObt=secOptionRepository.findById(st).get();
                   secResourcePerfilOption.setSecOption(optionObt);
                   secResourcePerfilOptionRepository.save(secResourcePerfilOption);
                   exit.setMessage("Roles asignados");
                   exit.setSuccess(true);
               }
           }

        }else{
        //DELETE
        for(Long st: entryResourcePerfilOption.getApievent()) {

            SecResourcePerfilOption secResourcePerfilOption = new SecResourcePerfilOption();
            secResourcePerfilOption =secResourcePerfilOptionRepository.deleteId(st, entryResourcePerfilOption.getIdApiroute());


            if(secResourcePerfilOption != null){

              secResourcePerfilOptionRepository.delete(secResourcePerfilOption);
            }

        }

            exit.setMessage("Roles Eliminados");
        }

        return exit;
    }





}