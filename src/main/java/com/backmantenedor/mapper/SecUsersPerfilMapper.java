package com.backmantenedor.mapper;

import com.backmantenedor.Util.GetApplicationDTO;
import com.backmantenedor.Util.GetUserDTO;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecUsersPerfilMapper {


    List<GetUserDTO> toUserEntityToGetUserDTO(List<UserEntity> id);







}
