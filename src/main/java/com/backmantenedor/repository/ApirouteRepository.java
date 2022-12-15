package com.backmantenedor.repository;

import com.backmantenedor.entity.ApiRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.UUID;

public interface ApirouteRepository extends JpaRepository<ApiRoute, Long> {


    List<ApiRoute> findAllById(Long id);

    List<ApiRoute> findAll();

    List<ApiRoute> findByTipo(/*String method,*/ String tipo);

    @Query(nativeQuery = false, value = "SELECT api from ApiRoute api"
            + " where (api.tipo =:tipo or :tipo is null) "
            + " order by api.id desc ")
    Page<ApiRoute> getAPiFiltro(@Param("tipo") String tipo,  Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT api from ApiRoute api"
            + " where (api.tipo =:tipo or :tipo is null) "
            + " order by api.id desc ")
    List<ApiRoute> getAPiSinPag( @Param("tipo") String tipo);







}
