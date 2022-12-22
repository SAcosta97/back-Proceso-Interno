package com.backmantenedor.services.RelationServices;

import com.backmantenedor.Util.EntryUserCompany;
import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.SecCompany;
import com.backmantenedor.entity.RelationEntity.SecUserCompany;
import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.mapper.SecUserCompanyMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.models.RelationModels.SecUserCompanyDTO;
import com.backmantenedor.repository.SecCompanyRepository;
import com.backmantenedor.repository.RelationRepository.SecUserCompanyRepository;
import com.backmantenedor.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecUserCompanyService {

    @Autowired
    private SecUserCompanyRepository secUserCompanyRepository;

    @Autowired
    private SecUserCompanyMapper secUserCompanyMapper;

    @Autowired
    private SecCompanyRepository secCompanyRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private Utility utility;


    public SecUserCompanyDTO getUsersCompany_NotCompany(Long idCompany) {

        SecUserCompanyDTO secUserCompanyexit = new SecUserCompanyDTO();
      if(idCompany != null){
          List<UserEntity> lsUserComp = secUserCompanyRepository.getUsersComp(idCompany);
          List<UserEntity> lsUserNotComp = secUserCompanyRepository.getUsersNotCompany();

          secUserCompanyexit.setUsersComp(secUserCompanyMapper.toUserEntityToUserEntityDTO(lsUserComp));
          secUserCompanyexit.setUsersNotComp(secUserCompanyMapper.toUserEntityToUserEntityDTO(lsUserNotComp));

      }
      return secUserCompanyexit;

    }

    public SaveMantDTO insertDeleteUserComp(EntryUserCompany entryUserCompany) throws Exception{



        SaveMantDTO exit= new SaveMantDTO();

        if(entryUserCompany.getFlagCreation()){

            List<SecUserCompany> secUserCompanies= secUserCompanyRepository.findAllBy();
            SecCompany secCompany = secCompanyRepository.findById(entryUserCompany.getIdCompany()).get();
            SecUserCompany secUserCompany = new SecUserCompany();
            secUserCompany.setSecCompany(secCompany);
            //insert
           for(String st: entryUserCompany.getUsercomp()){

               List<SecUserCompany>  secUserCompaniesS=secUserCompanies.stream().filter(x->(x.getSecCompany().getId().equals(entryUserCompany.getIdCompany()) && x.getUserEntity().getId().equals(st))).collect(Collectors.toList());
                if(!secUserCompaniesS.isEmpty()){
                    exit.setMessage("Usuario ya tiene una Compañia asignada");
                    exit.setSuccess(false);
                }else{
                    secUserCompany.setUserEntity(userEntityRepository.findById(st).get());
                    secUserCompany.setDateRegistr(utility.obtenergetdateNow());
                    secUserCompany.setStatus("A");

                    secUserCompanyRepository.save(secUserCompany);

                    exit.setMessage("Usuarios asignados");
                    exit.setSuccess(true);
                }

           }

        }else{
        //DELETE
        for(String st: entryUserCompany.getUsercomp()) {

            SecUserCompany secUserCompany = new SecUserCompany();
            secUserCompany =secUserCompanyRepository.deleteId(st, entryUserCompany.getIdCompany());


            if(secUserCompany != null){

              secUserCompanyRepository.delete(secUserCompany);
            }

        }

            exit.setMessage("Ususarios Eliminados");
        }

        return exit;
    }





}