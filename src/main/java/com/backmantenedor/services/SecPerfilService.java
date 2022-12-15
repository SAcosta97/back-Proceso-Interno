package com.backmantenedor.services;

import com.backmantenedor.Util.Utility;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.mapper.SecPerfilMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.repository.SecPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecPerfilService {

    @Autowired
    private SecPerfilRepository secPerfilRepository;

    @Autowired
    private SecPerfilMapper secPerfilMapper;

    @Autowired
    private Utility utility;



    public SaveMantDTO saveUpdatePerfil (SecPerfilDTO secPerfilDTO) throws Exception {

        SaveMantDTO exit = new SaveMantDTO();
        try {

            //crear
            SecPerfil secPerfil = new SecPerfil();

            if (secPerfilDTO.getId() != null) {
                secPerfil.setId(secPerfilDTO.getId());
                secPerfil.setDateUpdate(utility.obtenergetdateNow());
                secPerfil.setUserUpdate(secPerfilDTO.getUserUpdate());
            }
            secPerfil.setNombrePerfil(secPerfilDTO.getNombrePerfil());
            secPerfil.setAudit(secPerfilDTO.getAudit());
            secPerfil.setDateRegistr(utility.obtenergetdateNow());
            secPerfil.setEstado(secPerfilDTO.getEstado());
            secPerfil.setObserva(secPerfilDTO.getObserva());
            secPerfil.setUserCreation(secPerfilDTO.getUserCreation());

            this.secPerfilRepository.save(secPerfil);

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
    public ResponsePerfilPagination consultPerfil(SearchDTO searchDTO){

        ResponsePerfilPagination exit = new ResponsePerfilPagination();
        int totalReg = getPerfilGeneral(searchDTO).size();
        if (totalReg > 0) {
            int page = searchDTO.getPage() > 0 ? (searchDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setPerfil(getPerfilPag(pgRq, searchDTO));
            exit.setMessage("OK");
        }else {
            exit.setPerfil(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }


    public List<SecPerfilDTO> getPerfilGeneral(SearchDTO busqueda){

        return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.getPerfilSinPag(busqueda.getNombrePerfil()));
    }


    public List<SecPerfilDTO> getPerfilPag(Pageable pagineo, SearchDTO busqueda){

        return secPerfilMapper.toPerfilDTOPageList(secPerfilRepository.getPerfilFiltro(busqueda.getNombrePerfil(),pagineo));
    }
    public List<SecPerfilDTO> getIdPerfil(long id) {

        try{
            return secPerfilMapper.secPerfilToSecPerfilDTO(secPerfilRepository.findAllById(id));
        }
        catch (Exception ex){
            return new ArrayList<>();
        }

    }


}