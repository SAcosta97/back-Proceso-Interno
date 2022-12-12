package com.backmantenedor.repository;

import com.backmantenedor.entity.ApiRoute;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ApirouteRepository extends JpaRepository<ApiRoute, Long> {


    List<ApiRoute> findAllById(Long id);


    List<ApiRoute> findByTipo (String tipo);

    List<ApiRoute> findAll();








}
