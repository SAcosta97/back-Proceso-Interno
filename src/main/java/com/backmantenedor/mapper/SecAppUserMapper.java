package com.backmantenedor.mapper;

import com.backmantenedor.Util.GetUserDTO;
import com.backmantenedor.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecAppUserMapper {


    List<GetUserDTO>toUserEntityToUserEntityDTO(List<UserEntity> id);







}
