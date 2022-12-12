package com.backmantenedor.repository;


import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecApplicationsRepository extends JpaRepository<SecApplications, Long> {

    List<SecApplications> findAllById(Long id);

    List<SecApplications> findAll();



}
