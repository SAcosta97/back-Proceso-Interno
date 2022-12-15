package com.backmantenedor.repository;


import com.backmantenedor.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {


    @Query(nativeQuery = false, value =  " select ue.id, ue.username, ue.lastName, ue.firstName, ri.name as realme, sc.name, sc.ruc,sc.observation" +
            " from UserEntity ue" +
            " join ue.realmEntity ri" +
            " join ue.userCompany uc" +
            " join uc.secCompany sc"+
            " where (ue.username =: username or :username is null)"+
            " and ri.name <>'master'")
    Page<Object[]> getUserSinPag (@Param("username") String username, Pageable pageable);



    @Query(nativeQuery = false, value =  " select count(ue)" +
            " from UserEntity ue" +
            " join ue.realmEntity ri" +
            " join ue.userCompany uc" +
            " join uc.secCompany sc" +
            " where (ue.username =: username or :username is null)"+
            " and ri.name <>'master'")
    int cantityUserPag (@Param("username") String username);


    @Query(nativeQuery = false, value =  " select ue.username" +
            " from UserEntity ue" +
            " join ue.realmEntity r"+
            " where  r.name <>'master'")
    List<UserEntity> getUser ( );





}
