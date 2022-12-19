package com.backmantenedor.services;

import com.backmantenedor.Util.EntryRolPerfil;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.*;
import com.backmantenedor.mapper.SecRolPerfilMapper;
import com.backmantenedor.mapper.SecUserCompanyMapper;
import com.backmantenedor.Util.EntryUserCompany;
import com.backmantenedor.models.SaveMantDTO;
import com.backmantenedor.models.SecRolPerfilDTO;
import com.backmantenedor.models.SecUserCompanyDTO;
import com.backmantenedor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public SecRolPerfilDTO getRolPerfil_NotPerfil(Long idPerfil) {

        SecRolPerfilDTO secRolPerfilexit = new SecRolPerfilDTO();
      if(idPerfil != null){
          List<SecRol> lsRolPerfil = secRolPerfilRepository.getRol(idPerfil);
          List<SecRol> lsRolNotPerfil = secRolPerfilRepository.getNotRol();

          secRolPerfilexit.setRolPerfil(secRolPerfilMapper.toSecRolToUserGetRolDTO(lsRolPerfil));
          secRolPerfilexit.setRolNotPerfil(secRolPerfilMapper.toSecRolToUserGetRolDTO(lsRolNotPerfil));

      }
      return secRolPerfilexit;

    }

    public SaveMantDTO insertDeleteRolPerfil (EntryRolPerfil entryRolPerfil) throws Exception{


        SaveMantDTO exit= new SaveMantDTO();

        if(entryRolPerfil.getFlagCreation()){

            //insert
           for(Long st: entryRolPerfil.getRolPerfil()){
               SecRolPerfil secRolPerfil = new SecRolPerfil();
               SecPerfil secPerfil = secPerfilRepository.findById(entryRolPerfil.getIdPerfil()).get();
               secRolPerfil.setSecPerfil(secPerfil);
               SecRol rolObt=secRolRepository.findById(st).get();

               secRolPerfil.setSecRol(rolObt);

               secRolPerfilRepository.save(secRolPerfil);

               exit.setMessage("Roles asignados");
           }

        }else{
        //DELETE
        for(Long st: entryRolPerfil.getRolPerfil()) {

            SecRolPerfil secRolPerfil = new SecRolPerfil();
            secRolPerfil =secRolPerfilRepository.deleteId(st,entryRolPerfil.getIdPerfil());


            if(secRolPerfil != null){

              secRolPerfilRepository.delete(secRolPerfil);
            }

        }

            exit.setMessage("Roles Eliminados");
        }

        return exit;
    }





}