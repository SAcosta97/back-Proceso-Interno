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

//    List<SecPerfil> findByNombrePerfil(String nombrePerfil);

    List<SecPerfil> findAll();


    @Query(nativeQuery = false, value = "SELECT perf from SecPerfil perf"
            + " where (perf.nombrePerfil =:nombrePerfil or :nombrePerfil is null) "
            + " order by perf.id desc ")
    Page<SecPerfil> getPerfilFiltro(@Param("nombrePerfil") String nombrePerfil, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT perf from SecPerfil perf"
            + " where (perf.nombrePerfil =:nombrePerfil or :nombrePerfil is null)"
            + " order by perf.id desc ")
    List<SecPerfil> getPerfilSinPag(@Param("nombrePerfil") String nombrePerfil);


}
