package com.backmantenedor.mapper;

import com.backmantenedor.entity.Api_route;
import com.backmantenedor.models.Api_routeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "sping")
public interface ApirouteMapper {


    ApirouteMapper INSTANCE = Mappers.getMapper(ApirouteMapper.class);

    List<Api_routeDTO> obtenerApiList(List<Api_route>api_route);






}