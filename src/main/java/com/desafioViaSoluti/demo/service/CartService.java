package com.desafioViaSoluti.demo.service;

import com.desafioViaSoluti.demo.percistence.entity.CartEntity;
import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.repository.CartRepository;
import com.desafioViaSoluti.demo.repository.UserRepository;
import com.desafioViaSoluti.demo.service.logfatory.LogFactory;
import com.desafioViaSoluti.demo.service.model.Cart;
import com.desafioViaSoluti.demo.service.token.TokenVerifier;
import com.desafioViaSoluti.demo.web.mapper.CartMapper;
import com.desafioViaSoluti.demo.web.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CartService {
    private static final int BEGIN_INDEX = 7;
    @Autowired(required = true)
    CartRepository cartRepository;
    @Autowired(required = true)
    UserRepository userRepository;

    public ResponseEntity getCart(HttpServletRequest request, Long id) {
        try {
            String token = request.getHeader("Authorization");
            CartEntity entity = cartRepository.findByCartId(id);
            LogFactory.cartnfo(entity, "[GET] Cart success ", "[GET] Cart failure ");
            if (TokenVerifier.tokenValidation(request)) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                return entity != null && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token).body(CartMapper.unmarshall(entity))
                        : ResponseEntity.notFound().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    public ResponseEntity getCartByToken(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            CartEntity entity = cartRepository.findByUser_UserToken(token);
            LogFactory.cartnfo(entity, "[GET] Cart success ", "[GET] Cart failure ");
            if (TokenVerifier.tokenValidation(request)) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                return entity != null && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token).body(CartMapper.unmarshall(entity))
                        : ResponseEntity.notFound().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    public ResponseEntity createCart(HttpServletRequest request, Cart model) {
        try {
            String token = request.getHeader("Authorization");
            CartEntity entity = new CartEntity();
            entity.setProducts(ProductMapper.marshall(model.getProducts()));
            LogFactory.cartnfo(entity, "[POST] Cart success ", "[POST] Cart failure ");
            if (TokenVerifier.tokenValidation(request)) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                entity.setUser(userEntity);
                return entity != null && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token)
                            .body(cartRepository.save(entity))
                        : ResponseEntity.notFound().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity updateCart(HttpServletRequest request, Cart model) {
        try {
            String token = request.getHeader("Authorization");
            CartEntity entity = CartMapper.marshall(model);
            LogFactory.cartnfo(entity, "[UPDATE] Cart success ", "[UPDATE] Cart failure ");
            if (TokenVerifier.tokenValidation(request)) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                return entity != null && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token).body(cartRepository.save(entity))
                        : ResponseEntity.notFound().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity deleteCart(HttpServletRequest request, Long id) {
        try {
            String token = request.getHeader("Authorization");
            CartEntity entity = cartRepository.findByCartId(id);
            LogFactory.cartnfo(entity, "[DELETE] Cart success ", "[DELETE] Cart failure ");
            if (TokenVerifier.tokenValidation(request) && entity != null) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                cartRepository.delete(entity);
                return entity != null && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token).body(HttpStatus.OK)
                        : ResponseEntity.notFound().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
