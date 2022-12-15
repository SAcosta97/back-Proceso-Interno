package com.backmantenedor.mapper;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecCompany;
import com.backmantenedor.models.ApiRouteDTO;
import com.backmantenedor.models.SecApplicationsDTO;
import com.backmantenedor.models.SecCompanyDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecCompanyMapper {

List<SecCompanyDTO> secCompanyToSecCompanyDTO (List<SecCompany> all);

    List<SecCompanyDTO> toCompanyDTOPageList(Page<SecCompany> all);


}
