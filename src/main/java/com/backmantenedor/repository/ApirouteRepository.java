package com.backmantenedor.repository;

import com.backmantenedor.entity.ApiRoute;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ApirouteRepository extends JpaRepository<ApiRoute, Long> {


    List<ApiRoute> findAllById(Long id);

    List<ApiRoute> findByPath(String path);

    List<ApiRoute> findByMethod(String method);

    List<ApiRoute> findByTipo (String tipo);

    List<ApiRoute> findAll();




    //    @Query("select con from Api_route con where con.id = :id and con.estado =  true order by con.ºº")
//    List<Api_route>obtenerApi(@Param("id") long id);




}
