package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.models.ApiRouteDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiRouteMapper {

    List<ApiRouteDTO> apiRouteLsToApiRouteDTO(List<ApiRoute> all);

    List<ApiRouteDTO> toApiRouteDTOPageList(Page<ApiRoute> all);



    ApiRouteDTO toApiRouteTipo(ApiRoute apitipo);


}
