package com.backmantenedor.repository;


import com.backmantenedor.entity.SecPerfil;
import com.backmantenedor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {





//    @Query(nativeQuery = false, value ="SELECT  ue.username, ue.email_constraint,  ue.last_name +'  ' +ue.first_name as nombres_usuario, r.name as realme"




//    List<SecPerfil> findAllById(Long id);
//
//    List<SecPerfil> findAll();



}
