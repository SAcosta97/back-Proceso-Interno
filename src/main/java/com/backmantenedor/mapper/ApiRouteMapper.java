package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.models.ApiRouteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiRouteMapper {

    List<ApiRouteDTO> apiRouteLsToApiRouteDTO(List<ApiRoute> all);

    ApiRouteDTO toApiRouteTipo(ApiRoute apitipo);


}
