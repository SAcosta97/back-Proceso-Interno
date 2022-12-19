package com.backmantenedor.repository;


import com.backmantenedor.entity.SecCompany;
import com.backmantenedor.entity.SecRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecRolRepository extends JpaRepository<SecRol, Long> {

    List<SecRol> findAll();



    @Query(nativeQuery = false, value = "SELECT sr from SecRol sr"
            + " where (sr.rol =:rol or :rol is null)" +
            " order by sr.id desc")
    Page<SecRol> getRolFiltro(@Param("rol") String rol, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT sr from SecRol sr"
            + " where (sr.rol =:rol or :rol is null)" +
            " order by sr.id desc ")
    List<SecRol> getRolSinPag( @Param("rol") String rol);










}
