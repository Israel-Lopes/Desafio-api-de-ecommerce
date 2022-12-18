package com.desafioViaSoluti.demo.web.mapper;

import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.service.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    private UserMapper() {
        super();
    }
    public static List<UserEntity> marshall(List<User> models) {
        return models.stream().map(UserMapper::marshall).collect(Collectors.toList());
    }
    public static List<User> unmarshall(List<UserEntity> entities) {
        return entities.stream().map(UserMapper::unmarshall).collect(Collectors.toList());
    }
    public static UserEntity marshall(User model) {
        return UserEntity.builder()
                .userId(model.getUserId())
                .userName(model.getUserName())
                .userEmail(model.getUserEmail())
                .userPassword(model.getUserPassword())
                .userCreationDate(model.getUserCreationDate())
                .userToken(model.getUserToken())
                .build();
    }
    public static User unmarshall(UserEntity entity) {
        return User.builder()
                .userId(entity.getUserId())
                .userName(entity.getUserName())
                .userEmail(entity.getUserEmail())
                .userPassword(entity.getUserPassword())
                .userCreationDate(entity.getUserCreationDate())
                .userToken(entity.getUserToken())
                .build();

    }
}
