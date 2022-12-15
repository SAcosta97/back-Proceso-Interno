package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecPerfilDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecApplicationsMapper {

List<SecApplicationsDTO> secApplicationsToSecApplicationsDTO (List<SecApplications> all);
    List<SecApplicationsDTO> toSecAppicationsDTOPageList(Page<SecApplications> all);
}
