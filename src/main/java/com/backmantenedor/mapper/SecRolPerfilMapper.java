package com.backmantenedor.mapper;

import com.backmantenedor.entity.SecRol;
import com.backmantenedor.models.GetRolDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecRolPerfilMapper {


    List<GetRolDTO> toSecRolToUserGetRolDTO(List<SecRol> id);







}
