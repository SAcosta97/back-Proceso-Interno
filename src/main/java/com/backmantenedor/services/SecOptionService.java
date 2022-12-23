package com.backmantenedor.services;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecOption;
import com.backmantenedor.mapper.MasterTypeElementsMapper;
import com.backmantenedor.mapper.SecOptionMapper;
import com.backmantenedor.models.*;
import com.backmantenedor.models.Response.ResponseSecOptionPagination;
import com.backmantenedor.repository.ApirouteRepository;
import com.backmantenedor.repository.MasterTypeElementsRepository;
import com.backmantenedor.repository.SecOptionRepository;
import com.backmantenedor.repository.SecResourcePerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecOptionService {


    @Autowired
    private SecOptionMapper secOptionMapper;


    @Autowired
    private SecOptionRepository secOptionRepository;

    @Autowired
    private ApirouteRepository apirouteRepository;


    public SaveMantDTO saveOption (SecOptionDTO secOptionDTO) throws Exception{

        SaveMantDTO exit = new SaveMantDTO();
        try{
//
                //crear
                SecOption secOption = new SecOption();
                if(secOptionDTO.getId()!=null){
                    secOption.setId(secOptionDTO.getId());
                    secOption.setUserUpdate(secOptionDTO.getUserUpdate());
                }
            ApiRoute api = apirouteRepository.findById(secOptionDTO.getIdApi()).get();
                secOption.setApiRoute(api);
                secOption.setIdEvento(secOptionDTO.getIdEvento());
                secOption.setStatus("A");
                secOption.setPermit(secOptionDTO.getPermit());
                secOption.setUserCreation(secOptionDTO.getUserCreation());

                this.secOptionRepository.save(secOption);

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
    public ResponseSecOptionPagination consultEvent(SearchDTO searchDTO){

        ResponseSecOptionPagination exit = new ResponseSecOptionPagination();
        int totalReg = getOptionGeneral(searchDTO).size();
        if (totalReg > 0) {
            int page = searchDTO.getPage() > 0 ? (searchDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setOptions(getpOptionPag(pgRq, searchDTO));
            exit.setMessage("OK");
        }else {
            exit.setOptions(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }


    public List<SecOptionDTO> getOptionGeneral(SearchDTO busqueda){


            return secOptionMapper.secOptionLsToSecOptionDTO(secOptionRepository.getOptionSinPag(busqueda.getPermit()));

    }


    public List<SecOptionDTO> getpOptionPag(Pageable pagineo, SearchDTO busqueda){

        return secOptionMapper.toSecOptionDTOPageList(secOptionRepository.getOptionFiltro(busqueda.getPermit(),pagineo));

    }



}
