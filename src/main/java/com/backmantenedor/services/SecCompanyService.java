package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecCompany;
import com.backmantenedor.mapper.SecCompanyMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.repository.SecCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecCompanyService {

    @Autowired
    private SecCompanyRepository secCompanyRepository;

    @Autowired
    private SecCompanyMapper secCompanyMapper;

    @Autowired
    private Utility utility;



    public SaveMantDTO saveUpdateSecCompany (SecCompanyDTO secCompanyDTO) throws Exception {

        SaveMantDTO exit = new SaveMantDTO();
        try {

            //crear
            SecCompany secCompany = new SecCompany();

            if (secCompanyDTO.getId() != null) {
                secCompany.setId(secCompanyDTO.getId());
                secCompany.setDateUpdate(utility.obtenergetdateNow());
                secCompany.setUserUpdate(secCompanyDTO.getUserUpdate());
            }
            secCompany.setName(secCompanyDTO.getName());
            secCompany.setRuc(secCompanyDTO.getRuc());
            secCompany.setAudit(secCompanyDTO.getAudit());
            secCompany.setDateRegistr(utility.obtenergetdateNow());
            secCompany.setStatus(secCompanyDTO.getStatus());
            secCompany.setObservation(secCompanyDTO.getObservation());
            secCompany.setUserCreation(secCompanyDTO.getUserCreation());

            this.secCompanyRepository.save(secCompany);

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


    //PAGINATION
    public ResponseCompanyPagination consultCompany(SearchDTO search){

        ResponseCompanyPagination exit = new ResponseCompanyPagination();
        int totalReg = getCompanyGeneral(search).size();
        if (totalReg > 0) {
            int page = search.getPage() > 0 ? (search.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, search.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setCompany(getCompanyPag(pgRq, search));
            exit.setMessage("OK");
        }else {
            exit.setCompany(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }


    public List<SecCompanyDTO> getCompanyGeneral(SearchDTO busqueda){

        return secCompanyMapper.secCompanyToSecCompanyDTO(secCompanyRepository.getCompSinPag(busqueda.getName(), busqueda.getRuc()));}


    public List<SecCompanyDTO> getCompanyPag(Pageable pagineo, SearchDTO busqueda){

        return secCompanyMapper.toCompanyDTOPageList(secCompanyRepository.getCompFiltro(busqueda.getName(), busqueda.getRuc(), pagineo));}





}