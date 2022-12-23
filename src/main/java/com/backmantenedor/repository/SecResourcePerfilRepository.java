package com.backmantenedor.repository;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecResourcePerfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecResourcePerfilRepository extends JpaRepository<SecResourcePerfil, Long> {


    List<ApiRoute> findAllById(Long id);
//
//    List<ApiRoute> findAll();
//
//    List<ApiRoute> findByTipo(/*String method,*/ String tipo);

    @Query(nativeQuery = false, value = "SELECT api from ApiRoute api"
            + " where (api.tipo =:tipo or :tipo is null) "
            + " order by api.id desc ")
    Page<ApiRoute> getAPiFiltro(@Param("tipo") String tipo,  Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT api from ApiRoute api"
            + " where (api.tipo =:tipo or :tipo is null) "
            + " order by api.id desc ")
    List<ApiRoute> getAPiSinPag( @Param("tipo") String tipo);







}
