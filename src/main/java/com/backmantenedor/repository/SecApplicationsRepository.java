package com.backmantenedor.repository;


import com.backmantenedor.entity.SecApplications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecApplicationsRepository extends JpaRepository<SecApplications, Long> {

    List<SecApplications> findAllById(Long id);

    List<SecApplications> findAll();

//    List<SecApplications> findByName(String name);


    @Query(nativeQuery = false, value = "SELECT app from SecApplications app"
            + " where (app.name =:name or :name is null) "
            + " order by app.id desc ")
    Page<SecApplications> getAppFiltro(@Param("name") String name, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT app from SecApplications app"
            + " where (app.name =:name or :name is null)"
            + " order by app.id desc ")
    List<SecApplications> getAppSinPag( @Param("name") String name);



}
