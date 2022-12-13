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

    @Query(nativeQuery = false, value = "SELECT cabe from ApiRoute cabe"
            + " where to_char(cabe.fechaCreacion,'yyyy-MM-dd') between :fechaIni and :fechaFin "
            + " order by cabe.id asc ")
    Page<ApiRoute> getAPiFiltro(@Param("fechaIni") String fechaIni, @Param("fechaFin") String fechaFin, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT cabe from ApiRoute cabe"
            + " where to_char(cabe.fechaCreacion,'yyyy-MM-dd') between :fechaIni and :fechaFin "
            + " order by cabe.id asc ")
    List<ApiRoute> getAPiSinPag(@Param("fechaIni") String fechaIni, @Param("fechaFin") String fechaFin);







}
