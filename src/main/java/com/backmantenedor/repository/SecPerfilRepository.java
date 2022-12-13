package com.backmantenedor.repository;


import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecPerfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecPerfilRepository extends JpaRepository<SecPerfil, Long> {

    List<SecPerfil> findAllById(Long id);

    List<SecPerfil> findByNombrePerfil(String nombrePerfil);

    List<SecPerfil> findAll();


    @Query(nativeQuery = false, value = "SELECT cabe from SecPerfil cabe"
            + " where to_char(cabe.dateRegistr,'yyyy-MM-dd') between :fechaIni and :fechaFin "
            + " order by cabe.id asc ")
    Page<SecPerfil> getPerfilFiltro(@Param("fechaIni") String fechaIni, @Param("fechaFin") String fechaFin, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT cabe from SecPerfil cabe"
            + " where to_char(cabe.dateRegistr,'yyyy-MM-dd') between :fechaIni and :fechaFin "
            + " order by cabe.id asc ")
    List<SecPerfil> getPerfilSinPag(@Param("fechaIni") String fechaIni, @Param("fechaFin") String fechaFin);





}
