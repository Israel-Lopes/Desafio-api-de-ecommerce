package com.desafioViaSoluti.demo.repository;

import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserPassword(String password);
    UserEntity findByUserToken(String token);
}
