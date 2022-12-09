package com.backmantenedor.repository;

import com.backmantenedor.entity.MasterTypeElements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterTypeElementsRepository extends JpaRepository<MasterTypeElements, Long> {

    List<MasterTypeElements> findByTypeFilterAndStateReg(String typeFilter, Boolean stateReg);

}
