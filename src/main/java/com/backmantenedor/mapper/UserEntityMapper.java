package com.backmantenedor.mapper;

import com.backmantenedor.Util.UserEntityObject;
import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.models.GetUserDTO;
import com.backmantenedor.models.UserEntityDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper  {



    List<GetUserDTO> userEntityToUserEntityDTO (List<UserEntity> all);


}
