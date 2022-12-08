package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.services.ApiRouteDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiRouteMapper {

    List<ApiRouteDTO> apiRouteLsToApiRouteDTO(List<ApiRoute> all);
}
