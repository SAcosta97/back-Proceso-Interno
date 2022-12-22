package com.backmantenedor.repository.RelationRepository;


import com.backmantenedor.entity.RelationEntity.SecApplicationPerfil;
import com.backmantenedor.entity.RelationEntity.SecApplicationUser;
import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecApplicationUserRepository extends JpaRepository<SecApplicationUser, Long> {


    //Eliminar
    @Query(nativeQuery = false, value = "select sau" +
            " from SecApplicationUser sau" +
            " where sau.secApplications.id =:idApplication" +
            " and sau.userEntity.id =:idUser")
    SecApplicationUser deleteId(@Param("idApplication") Long idApplication, @Param("idUser") String idUser);


    @Query(nativeQuery = false, value = "select sau.userEntity " +
            "from SecApplicationUser sau " +
            "where sau.secApplications.id=:idApp")
    List<UserEntity> getApp(@Param("idApp") Long idApp );


    @Query(nativeQuery = false, value = "select uenty " +
            "from UserEntity uenty" +
            " join uenty.realmEntity ri" +
            " where (select count(sau) from SecApplicationUser sau where sau.userEntity=uenty )=0" +
            " and ri.name <>'master'" +
            " and uenty.email is not null")
    List<UserEntity> getNotApp();

    List<SecApplicationUser>findAllBy();



}
