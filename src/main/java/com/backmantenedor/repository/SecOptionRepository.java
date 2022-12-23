package com.backmantenedor.repository;

import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.SecOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecOptionRepository extends JpaRepository<SecOption, Long> {


//    List<SecOption> findAllById(Long id);

    List<SecOption> findAll();

//    List<SecOption> findByTipo(/*String method,*/ String tipo);

    @Query(nativeQuery = false, value = "SELECT so from SecOption so"
            + " where (so.permit =:permit or :permit is null) "
            + " order by so.id desc ")
    Page<SecOption> getOptionFiltro(@Param("permit") Boolean permit,  Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT so from SecOption so"
            + " where (so.permit =:permit or :permit is null) "
            + " order by so.id desc ")
    List<SecOption> getOptionSinPag( @Param("permit") Boolean permit);







}
