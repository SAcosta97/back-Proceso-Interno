package com.backmantenedor.repository;


import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecCompanyRepository extends JpaRepository<SecCompany, Long> {

    List<SecCompany> findAllById(Long id);

    List<SecCompany> findAll();



}
