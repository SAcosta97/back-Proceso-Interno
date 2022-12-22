package com.backmantenedor.repository.RelationRepository;


import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.SecApplications;
import com.backmantenedor.entity.SecPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecApplicationPerfilRepository extends JpaRepository<SecApplicationPerfil, Long> {


    //Eliminar
    @Query(nativeQuery = false, value = "select sap" +
            " from SecApplicationPerfil sap" +
            " where sap.secApplications.id =:idApplication" +
            " and sap.secPerfil.id =:idPerfil")
    SecApplicationPerfil deleteId(@Param("idApplication") Long idApplication, @Param("idPerfil") Long idPerfil);


    @Query(nativeQuery = false, value = "select sap.secPerfil " +
            "from SecApplicationPerfil sap " +
            "where sap.secApplications.id=:idApp")
    List<SecPerfil> getApp(@Param("idApp") Long idApp );


    @Query(nativeQuery = false, value = "select sp " +
            "from SecPerfil sp" +
            " where (select count(sap) from SecApplicationPerfil sap where sap.secPerfil=sp )=0" )
    List<SecPerfil> getNotApp();


    List<SecApplicationPerfil> findAllBy();



}
