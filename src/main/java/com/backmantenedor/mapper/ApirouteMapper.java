package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.models.ApiRouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "sping")
public interface ApirouteMapper {


    ApirouteMapper INSTANCE = Mappers.getMapper(ApirouteMapper.class);

    List<ApiRouteDTO> obtenerApiList(List<ApiRoute>api_route);






}