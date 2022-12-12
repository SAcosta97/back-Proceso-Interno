package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.SecPerfilDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecPerfilMapper {

List<SecPerfilDTO> secPerfilToSecPerfilDTO(List<SecPerfil> all);

}
