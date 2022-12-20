package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecRol;
import com.backmantenedor.mapper.SecPerfilMapper;
import com.backmantenedor.mapper.SecRolMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponsePerfilPagination;
import com.backmantenedor.models.Response.ResponseRolPagination;
import com.backmantenedor.repository.SecRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecRolService {

    @Autowired
    private SecRolRepository secRolRepository;

    @Autowired
    private SecRolMapper secRolMapper;

    @Autowired
    private Utility utility;



    public SaveMantDTO saveUpdateSecRol (SecRolDTO secRolDTO) throws Exception {

        SaveMantDTO exit = new SaveMantDTO();
        try {

            //crear
            SecRol secRol = new SecRol();

            if (secRolDTO.getId() != null) {
                secRol.setId(secRolDTO.getId());
                secRol.setDateUpdate(utility.obtenergetdateNow());
                secRol.setUserUpdate(secRolDTO.getUserUpdate());
            }
            secRol.setAudit(secRolDTO.getAudit());
            secRol.setRol(secRolDTO.getRol());
            secRol.setDateRegistr(utility.obtenergetdateNow());
            secRol.setStatus("A");
            secRol.setObservation(secRolDTO.getObservation());
            secRol.setUserCreation(secRolDTO.getUserCreation());

            this.secRolRepository.save(secRol);

            exit.setMessage("OK");

        }catch (NullPointerException nex){
            exit.setMessage("Uno de los campos obligatorios no fue enviado");
            return exit;
        }

        catch ( Exception ex){
            exit.setMessage(ex.getMessage());
        }
        return exit;
    }


    //PAGINADO
    public ResponseRolPagination consultRol(SearchDTO searchDTO){

        ResponseRolPagination exit = new ResponseRolPagination();
        int totalReg = getRolGeneral(searchDTO).size();
        if (totalReg > 0) {
            int page = searchDTO.getPage() > 0 ? (searchDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setRol(getPerfilPag(pgRq, searchDTO));
            exit.setMessage("OK");
        }else {
            exit.setRol(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }


    public List<SecRolDTO> getRolGeneral(SearchDTO busqueda){

        return secRolMapper.secRolToSecRolDTO(secRolRepository.getRolSinPag(busqueda.getRol()));
    }


    public List<SecRolDTO> getPerfilPag(Pageable pagineo, SearchDTO busqueda){

        return secRolMapper.toRolDTOPageList(secRolRepository.getRolFiltro(busqueda.getRol(),pagineo));
    }




}