package com.backmantenedor.repository.RelationRepository;


import com.backmantenedor.entity.*;
import com.backmantenedor.entity.RelationEntity.SecRolPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecRolPerfilRepository extends JpaRepository<SecRolPerfil, Long> {


    //Eliminar
    @Query(nativeQuery = false, value = "select srp" +
            " from SecRolPerfil srp" +
            " where srp.secPerfil.id =:idPerfil" +
            " and srp.secRol.id =:idRol")
    SecRolPerfil deleteId(@Param("idPerfil") Long idPerfil, @Param("idRol") Long idRol);


    @Query(nativeQuery = false, value = "select srp.secRol " +
            "from SecRolPerfil srp " +
            "where srp.secPerfil.id=:idPerfil")
    List<SecRol> getRol(@Param("idPerfil") Long idPerfil );


    @Query(nativeQuery = false, value = "select sr " +
            "from SecRol sr" +
            " where (select count(srp) from SecRolPerfil srp where srp.secRol=sr )=0" )
    List<SecRol> getNotRol();



}