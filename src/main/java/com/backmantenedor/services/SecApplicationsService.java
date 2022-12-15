package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.mapper.SecApplicationsMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.repository.SecApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecApplicationsService {

    @Autowired
    private SecApplicationsRepository secApplicationsRepository;

    @Autowired
    private SecApplicationsMapper secApplicationsMapper;

    @Autowired
    private Utility utility;



    public SaveMantDTO saveUpdateApplications (SecApplicationsDTO secApplicationsDTO) throws Exception {

        SaveMantDTO applExit = new SaveMantDTO();
        try {

            //crear
            SecApplications secApplications = new SecApplications();

            if (secApplicationsDTO.getId() != null) {
                secApplications.setId(secApplicationsDTO.getId());
                secApplications.setDateUpdate(utility.obtenergetdateNow());
                secApplications.setUserUpdate(secApplicationsDTO.getUserUpdate());
            }
            secApplications.setName(secApplicationsDTO.getName());
            secApplications.setAudit(secApplicationsDTO.getAudit());
            secApplications.setDateRegistr(utility.obtenergetdateNow());
            secApplications.setStatus(secApplicationsDTO.getStatus());
            secApplications.setDescription(secApplicationsDTO.getDescription());
            secApplications.setUserCreation(secApplicationsDTO.getUserCreation());



            this.secApplicationsRepository.save(secApplications);

            applExit.setMessage("OK");

        }catch (NullPointerException nex){
            applExit.setMessage("Uno de los campos obligatorios no fue enviado");
            return applExit;
        }

        catch ( Exception ex){
            applExit.setMessage(ex.getMessage());
        }
        return applExit;
    }

    //PAGINADO

    public ResponseApplicationsPagination consultApp(SearchDTO searchDTO){

        ResponseApplicationsPagination exit = new ResponseApplicationsPagination();
        int totalReg = getAppGeneral(searchDTO).size();
        if (totalReg > 0) {
            int page = searchDTO.getPage() > 0 ? (searchDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setApp(getAppPag(pgRq, searchDTO));
            exit.setMessage("OK");
        }else {
            exit.setApp(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }


    public List<SecApplicationsDTO> getAppGeneral(SearchDTO busqueda){

        return secApplicationsMapper.secApplicationsToSecApplicationsDTO(secApplicationsRepository.getAppSinPag(busqueda.getName()));

    }


    public List<SecApplicationsDTO> getAppPag(Pageable pagineo, SearchDTO busqueda){

        return secApplicationsMapper.toSecAppicationsDTOPageList(secApplicationsRepository.getAppFiltro(busqueda.getName(),pagineo));

    }

    public List<SecApplicationsDTO> getIdApp(long id) {

        try{
            return secApplicationsMapper.secApplicationsToSecApplicationsDTO(secApplicationsRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }


}