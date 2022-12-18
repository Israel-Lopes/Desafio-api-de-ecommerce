package com.desafioViaSoluti.demo.service;

import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.repository.UserRepository;
import com.desafioViaSoluti.demo.service.common.PasswordHasher;
import com.desafioViaSoluti.demo.service.logfatory.LogFactory;
import com.desafioViaSoluti.demo.service.model.Registration;
import com.desafioViaSoluti.demo.web.mapper.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired(required = true)
    UserRepository repository;

    public ResponseEntity createUser(Registration model) throws Exception {
        try {
            model.setRegistrationPassword(PasswordHasher.hashPassword(model.getRegistrationPassword()));
            UserEntity entity = repository.save(RegistrationMapper.marshall(model));
            LogFactory.userInfo(entity, "[POST] User success ", "[POST] User failure ");
            return entity != null
                    ? ResponseEntity.ok().body(RegistrationMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
