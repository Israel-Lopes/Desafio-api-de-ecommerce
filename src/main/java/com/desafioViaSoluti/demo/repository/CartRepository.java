package com.desafioViaSoluti.demo.repository;

import com.desafioViaSoluti.demo.percistence.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByCartId(Long id);
    CartEntity deleteByCartId(Long id);
}
