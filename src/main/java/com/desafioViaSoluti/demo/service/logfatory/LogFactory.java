package com.desafioViaSoluti.demo.service.logfatory;

import com.desafioViaSoluti.demo.percistence.entity.CartEntity;
import com.desafioViaSoluti.demo.percistence.entity.ProductEntity;
import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LogFactory {
    public static final Logger log = LoggerFactory.getLogger(ProductService.class);

    public static void productInfo(ProductEntity entity, String success, String failure) {
        if (entity != null) {
            log.info(success);
        } else {
            log.info(failure);
        }
    }
    public static void productInfo(List<ProductEntity> entities, String success, String failure) {
        if (!entities.isEmpty()) {
            log.info(success);
        } else {
            log.info(failure);
        }
    }
    public static void stringInfo(String text, String success, String failure) {
        if (text != null) {
            log.info(success);
        } else {
            log.info(failure);
        }
    }
    public static void userInfo(UserEntity entity, String success, String failure) {
        if (entity != null) {
            log.info(success);
        } else {
            log.info(failure);
        }
    }
    public static void cartnfo(CartEntity entity, String success, String failure) {
        if (entity != null) {
            log.info(success);
        } else {
            log.info(failure);
        }
    }

}
