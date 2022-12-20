package com.backmantenedor.mapper;

import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.Util.GetUserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper  {



    List<GetUserDTO> userEntityToUserEntityDTO (List<UserEntity> all);


}
