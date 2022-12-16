package com.backmantenedor.repository;


import com.backmantenedor.entity.SecUserCompany;

import com.backmantenedor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecUserCompanyRepository extends JpaRepository<SecUserCompany, Long> {


    @Query(nativeQuery = false, value = "select suc.userEntity " +
            "from SecUserCompany suc " +
            "where suc.secCompany.id=:idCompany")
    List<UserEntity> getUsersComp(@Param("idCompany") Long idCompany );


    @Query(nativeQuery = false, value = "select uenty " +
            "from UserEntity uenty" +
            " join uenty.realmEntity ri" +
            " where (select count(ucom) from SecUserCompany ucom where ucom.userEntity=uenty )=0" +
            " and ri.name <>'master'" +
            " and uenty.email is not null")
    List<UserEntity> getUsersNotCompany();



}
