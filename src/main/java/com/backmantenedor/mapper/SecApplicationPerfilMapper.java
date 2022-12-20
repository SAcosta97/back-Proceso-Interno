package com.backmantenedor.mapper;

import com.backmantenedor.Util.GetApplicationDTO;
import com.backmantenedor.Util.GetRolDTO;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecRol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecApplicationPerfilMapper {


    List<GetApplicationDTO> toSecApplicationsToGetApplicationDTO(List<SecApplications> id);







}
