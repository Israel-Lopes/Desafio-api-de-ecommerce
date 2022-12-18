package com.desafioViaSoluti.demo.service;

import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.repository.UserRepository;
import com.desafioViaSoluti.demo.service.common.PasswordHasher;
import com.desafioViaSoluti.demo.service.logfatory.LogFactory;
import com.desafioViaSoluti.demo.service.model.Login;
import com.desafioViaSoluti.demo.service.token.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired(required = true)
    UserRepository repository;

    public ResponseEntity loginUser(Login model) {
        try {
            String hash = PasswordHasher.hashPassword(model.getLoginPassword());
            UserEntity entity = repository.findByUserPassword(hash);
            String token = TokenGenerator.generateToken(hash);
            HttpHeaders headers = new HttpHeaders();
            if (token != null) {
                entity.setUserToken(token);
                headers.add("X-Auth-Token", token);
                repository.save(entity);
            }
            LogFactory.stringInfo(token, "[TOKEN] created", "[TOKEN] canceled");
            LogFactory.userInfo(entity, "[POST] User success ", "[POST] User failure ");
            return entity != null && entity.getUserPassword().equals(hash) && entity.getUserEmail().equals(model.getLoginEmail())
                    ? ResponseEntity.ok().headers(headers).body(entity)
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
