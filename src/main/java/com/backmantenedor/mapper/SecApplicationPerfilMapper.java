package com.backmantenedor.mapper;

import com.backmantenedor.Util.GetApplicationDTO;
import com.backmantenedor.entity.SecPerfil;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecApplicationPerfilMapper {


    List<GetApplicationDTO> toSecApplicationsToGetApplicationDTO(List<SecPerfil> id);







}
