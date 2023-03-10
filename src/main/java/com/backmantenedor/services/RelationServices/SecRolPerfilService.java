package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryRolPerfil;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.*;
import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecRolPerfil;
import com.backmantenedor.mapper.SecRolPerfilMapper;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.models.RelationModels.SecRolPerfilDTO;
import com.backmantenedor.repository.*;
import com.backmantenedor.repository.RelationRepository.SecRolPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecRolPerfilService {

    @Autowired
    private SecRolPerfilRepository secRolPerfilRepository;

    @Autowired
    private SecRolPerfilMapper secRolPerfilMapper;

    @Autowired
    private SecRolRepository secRolRepository;

    @Autowired
    private SecPerfilRepository secPerfilRepository;

    @Autowired
    private Utility utility;


    public SecRolPerfilDTO getRolPerfil_NotPerfil(Long idRol) {

        SecRolPerfilDTO secRolPerfilexit = new SecRolPerfilDTO();
      if(idRol != null){
          List<SecPerfil> lsRolPerfil = secRolPerfilRepository.getRol(idRol);
          List<SecPerfil> lsRolNotPerfil = secRolPerfilRepository.getNotRol();

          secRolPerfilexit.setRolPerfil(secRolPerfilMapper.toSecRolToUserGetRolDTO(lsRolPerfil));
          secRolPerfilexit.setRolNotPerfil(secRolPerfilMapper.toSecRolToUserGetRolDTO(lsRolNotPerfil));

      }
      return secRolPerfilexit;

    }

    public SaveMantDTO insertDeleteRolPerfil (EntryRolPerfil entryRolPerfil) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryRolPerfil.getFlagCreation()){

            List<SecRolPerfil> secRolPerfils= secRolPerfilRepository.findAllBy();
            SecRol secRol = secRolRepository.findById(entryRolPerfil.getIdRol()).get();
            SecRolPerfil secRolPerfil = new SecRolPerfil();
            secRolPerfil.setSecRol(secRol);

            //insert
           for(Long st: entryRolPerfil.getRolPerfil()){

               List<SecRolPerfil>  secRolPerfilsS=secRolPerfils.stream().filter(x->(x.getSecPerfil().getId().equals(entryRolPerfil.getIdRol()) && x.getSecRol().getId().equals(st))).collect(Collectors.toList());

               if( !secRolPerfilsS.isEmpty()){
                   exit.setMessage("Este perfil ya tiene un rol asignado");
                   exit.setSuccess(false);

               } else{
                   SecPerfil perfilObt=secPerfilRepository.findById(st).get();
                   secRolPerfil.setSecPerfil(perfilObt);
                   secRolPerfilRepository.save(secRolPerfil);
                   exit.setMessage("Roles asignados");
                   exit.setSuccess(true);
               }
           }

        }else{
        //DELETE
        for(Long st: entryRolPerfil.getRolPerfil()) {

            SecRolPerfil secRolPerfil = new SecRolPerfil();
            secRolPerfil =secRolPerfilRepository.deleteId(st, entryRolPerfil.getIdRol());


            if(secRolPerfil != null){

              secRolPerfilRepository.delete(secRolPerfil);
            }

        }

            exit.setMessage("Roles Eliminados");
        }

        return exit;
    }





}