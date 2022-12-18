package com.desafioViaSoluti.demo.web.mapper;

import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.service.model.Registration;

public class RegistrationMapper {
    private RegistrationMapper() {
        super();
    }
    public static UserEntity marshall(Registration model) {
        return UserEntity.builder()
                .userName(model.getRegistrationName())
                .userEmail(model.getRegistrationEmail())
                .userPassword(model.getRegistrationPassword())
                .build();
    }
    public static Registration unmarshall(UserEntity entity) {
        return Registration.builder()
                .registrationId(entity.getUserId())
                .registrationName(entity.getUserName())
                .registrationEmail(entity.getUserEmail())
                .registrationPassword(entity.getUserPassword())
                .registrationCreationDate(entity.getUserCreationDate())
                .build();
    }
}
