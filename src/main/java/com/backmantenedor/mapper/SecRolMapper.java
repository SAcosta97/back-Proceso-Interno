package com.backmantenedor.mapper;

import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.SecRol;
import com.backmantenedor.models.SecPerfilDTO;
import com.backmantenedor.models.SecRolDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecRolMapper {

List<SecRolDTO> secRolToSecRolDTO(List<SecRol> all);

List<SecRolDTO> toRolDTOPageList(Page<SecRol> all);

}
