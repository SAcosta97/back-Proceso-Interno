package com.backmantenedor.mapper;

import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecPerfilDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecApplicationsMapper {

List<SecApplicationsDTO> secApplicationsToSecApplicationsDTO (List<SecApplications> all);

}
