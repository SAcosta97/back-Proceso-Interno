package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecOption;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.SecOptionDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecOptionMapper {

    List<SecOptionDTO> secOptionLsToSecOptionDTO(List<SecOption> all);

    List<SecOptionDTO> toSecOptionDTOPageList(Page<SecOption> all);



    SecOptionDTO toSecOptionPermit (SecOption permit);


}
