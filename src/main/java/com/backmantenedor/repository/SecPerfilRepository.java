package com.backmantenedor.repository;


import com.backmantenedor.entity.SecPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecPerfilRepository extends JpaRepository<SecPerfil, Long> {

    List<SecPerfil> findAllById(Long id);

    List<SecPerfil> findAll();



}