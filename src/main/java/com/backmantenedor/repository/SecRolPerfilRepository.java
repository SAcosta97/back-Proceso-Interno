package com.backmantenedor.repository;


import com.backmantenedor.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecRolPerfilRepository extends JpaRepository<SecRolPerfil, Long> {



    @Query(nativeQuery = false, value = "select srp" +
            " from SecRolPerfil srp" +
            " where srp.secPerfil.id =:idPerfil" +
            " and srp.secRol.id =:idRol")
    SecRolPerfil deleteId(@Param("idPerfil") String idPerfil, @Param("idRol") List<String> idRol);


    @Query(nativeQuery = false, value = "select srp.secRol " +
            "from SecRolPerfil srp " +
            "where srp.secPerfil.id=:idPerfil")
    List<SecRol> getRol(@Param("idPerfil") Long idPerfil );


    @Query(nativeQuery = false, value = "select sr " +
            "from SecRol sr" +
            " where (select count(srp) from SecRolPerfil srp where srp.secRol=sr )=0" )

    List<SecRol> getNotRol();



}
