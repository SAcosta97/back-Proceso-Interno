package com.backmantenedor.mapper;

import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.Util.GetRolDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecRolPerfilMapper {


    List<GetRolDTO> toSecRolToUserGetRolDTO(List<SecPerfil> id);







}
