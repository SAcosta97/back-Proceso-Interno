package com.backmantenedor.repository.RelationRepository;


import com.backmantenedor.entity.ApiRoute;
import com.backmantenedor.entity.RelationEntity.SecResourcePerfilOption;
import com.backmantenedor.entity.RelationEntity.SecRolPerfil;
import com.backmantenedor.entity.SecOption;
import com.backmantenedor.entity.SecPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecResourcePerfilOptionRepository extends JpaRepository<SecResourcePerfilOption, Long> {


    //Eliminar
    @Query(nativeQuery = false, value = "select rpo" +
            " from SecResourcePerfilOption rpo" +
            " where rpo.secOption.id =:idOption" +
            " and rpo.secResourcePerfil.id =:idResourcePerfil")
    SecResourcePerfilOption deleteId(@Param("idOption") Long idOption, @Param("idResourcePerfil") Long idResourcePerfil);


    @Query(nativeQuery = false, value = "select rpo.secOption " +
            "from SecResourcePerfilOption rpo " +
            "where rpo.apiRoute.id=:idApi")
    List<SecOption> getApi(@Param("idApi") Long idApi );


    @Query(nativeQuery = false, value = "select so " +
            "from SecOption so" +
            " where (select count(rpo) from SecResourcePerfilOption rpo where rpo.secOption=rpo )=0" )
    List<SecOption> getNotApi();


    List<SecResourcePerfilOption> findAllBy();



}
