package com.backmantenedor.mapper;

import com.backmantenedor.Util.GetOptionDTO;
import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecOption;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecResourcePerfilOptionMapper {


    List<GetOptionDTO> toApiRouteToUserGetApiDTO(List<SecOption> id);







}
