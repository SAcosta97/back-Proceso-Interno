package com.backmantenedor.repository;


import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface SecCompanyRepository extends JpaRepository<SecCompany, Long> {

    List<SecCompany> findAllById(Long id);

//    List<SecCompany> findById(Long id);

    List<SecCompany> findAll();

//    List<SecCompany> findByNameAndRuc(String name, String ruc);

    @Query(nativeQuery = false, value = "SELECT comp from SecCompany comp"
            + " where (comp.name =:name or :name is null)" +
            " and (comp.ruc =:ruc or :ruc is null)"
            + " order by comp.id desc ")
    Page<SecCompany> getCompFiltro(@Param("name") String name, @Param("ruc") String ruc, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT comp from SecCompany comp"
            + " where (comp.name =:name or :name is null)" +
            " and (comp.ruc =:ruc or :ruc is null)"
            + " order by comp.id desc ")
    List<SecCompany> getCompSinPag( @Param("name") String name, @Param("ruc")String ruc);





}
