package com.backmantenedor.repository.RelationRepository;


import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecUserPerfil;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecUserPerfilRepository extends JpaRepository<SecUserPerfil, Long> {


    //Eliminar
    @Query(nativeQuery = false, value = "select sup" +
            " from SecUserPerfil sup" +
            " where sup.userEntity.id =:idPerfil" +
            " and sup.secPerfil.id =:idUser")
    SecUserPerfil deleteId(@Param("idPerfil") Long idPerfil, @Param("idUser") String idUser);

    @Query(nativeQuery = false, value = "select sup.secPerfil " +
            "from SecUserPerfil sup " +
            "where sup.secPerfil.id=:idPerfil")
    List<UserEntity> getApp(@Param("idPerfil") Long idPerfil );


    @Query(nativeQuery = false, value = "select ue " +
            "from UserEntity ue" +
            " where (select count(sup) from SecUserPerfil sup where sup.secPerfil=ue )=0" )
    List<UserEntity> getNotApp();


    List<SecUserPerfil> findAllBy();

    @Query(nativeQuery = false, value =  " select count (sup)" +
            " from SecUserPerfil sup" +
            " where sup.secPerfil.id =:idPerfil" +
            " and sup.userEntity.id =:idUser")
    Long getcnatityId(@Param("idPerfil") Long idPerfil, @Param("idUser") String idUser);



}
