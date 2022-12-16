package com.backmantenedor.mapper;

import com.backmantenedor.entity.SecCompany;
import com.backmantenedor.entity.SecUserCompany;
import com.backmantenedor.entity.UserEntity;
import com.backmantenedor.models.GetUserDTO;
import com.backmantenedor.models.SecCompanyDTO;
import com.backmantenedor.models.SecUserCompanyDTO;
import com.backmantenedor.models.UserEntityDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecUserCompanyMapper {


    List<GetUserDTO>toUserEntityToUserEntityDTO(List<UserEntity> id);







}
