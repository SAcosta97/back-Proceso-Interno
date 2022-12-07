package com.backmantenedor.repository;

import com.backmantenedor.entity.Api_route;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ApirouteRepository extends JpaRepository<Api_route, Long> {


    List<Api_route> findAllById(Long id);

    List<Api_route> findByPath(String path);

    List<Api_route> findByMethod(String method);

    List<Api_route> findByTipo (String tipo);




    //    @Query("select con from Api_route con where con.id = :id and con.estado =  true order by con.ºº")
//    List<Api_route>obtenerApi(@Param("id") long id);




}
