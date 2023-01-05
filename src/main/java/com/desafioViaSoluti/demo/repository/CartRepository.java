package com.desafioViaSoluti.demo.repository;

import com.desafioViaSoluti.demo.percistence.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByCartId(Long id);
    CartEntity deleteByCartId(Long id);
//    @Query("SELECT c FROM CartEntity c WHERE c.user.userToken = :userToken")
//    CartEntity findByUserToken(@Param("userToken") String userToken);
    CartEntity findByUser_UserToken(String userToken);

}
