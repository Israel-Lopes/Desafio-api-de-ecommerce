package com.desafioViaSoluti.demo.web.mapper;

import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.service.model.Login;

public class LoginMapper {
    private LoginMapper() {
        super();
    }
    public static UserEntity marshall(Login model) {
        return UserEntity.builder()
                .userEmail(model.getLoginEmail())
                .userPassword(model.getLoginPassword())
                .build();
    }
    public static Login unmarshall(UserEntity entity) {
        return Login.builder()
                .loginId(entity.getUserId())
                .loginEmail(entity.getUserEmail())
                .build();
    }
}
