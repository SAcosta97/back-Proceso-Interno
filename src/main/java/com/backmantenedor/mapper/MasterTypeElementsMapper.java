package com.backmantenedor.mapper;

import com.backmantenedor.entity.MasterTypeElements;
import com.backmantenedor.models.MasterTypeElementsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MasterTypeElementsMapper {

    List<MasterTypeElementsDTO> masterTypeElementsToMasterTypeElementsDTO(List<MasterTypeElements> all);


}
