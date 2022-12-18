package com.desafioViaSoluti.demo.service;

import com.desafioViaSoluti.demo.percistence.entity.ProductEntity;
import com.desafioViaSoluti.demo.percistence.entity.UserEntity;
import com.desafioViaSoluti.demo.repository.ProductRepository;
import com.desafioViaSoluti.demo.repository.UserRepository;
import com.desafioViaSoluti.demo.service.logfatory.LogFactory;
import com.desafioViaSoluti.demo.service.model.Product;
import com.desafioViaSoluti.demo.service.token.TokenVerifier;
import com.desafioViaSoluti.demo.web.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ProductService {
    private static final int BEGIN_INDEX = 7;
    @Autowired(required = true)
    ProductRepository productRepository;
    @Autowired(required = true)
    UserRepository userRepository;

    public ResponseEntity getProduct(HttpServletRequest request, Long id) {
        try {
            String token = request.getHeader("Authorization");
            ProductEntity productEntity = productRepository.findByProductId(id);
            LogFactory.productInfo(productEntity, "[GET] Product success ", "[GET] Product failure ");
            if (TokenVerifier.tokenValidation(request)) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                return productEntity != null && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token).body(ProductMapper.unmarshall(productEntity))
                        : ResponseEntity.notFound().build();
            }
            return productEntity != null
                    ? ResponseEntity.ok().body(ProductMapper.unmarshall(productEntity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    public ResponseEntity<List<Product>> getProductList(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            List<ProductEntity> entities = productRepository.findAll();
            LogFactory.productInfo(entities, "[GET - List] Products success ", "[GET - List] Products failure ");

            if (TokenVerifier.tokenValidation(request)) {
                token = token.substring(BEGIN_INDEX);
                UserEntity userEntity = userRepository.findByUserToken(token);
                return !entities.isEmpty() && userEntity.getUserToken().equals(token)
                        ? ResponseEntity.ok().header(token).body(ProductMapper.unmarshall(entities))
                        : ResponseEntity.notFound().build();
            }
            return entities != null
                    ? ResponseEntity.ok().body(ProductMapper.unmarshall(entities))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity createProduct(Product model) {
        try {
            ProductEntity entity = productRepository.save(ProductMapper.marshall(model));
            LogFactory.productInfo(entity, "[POST] Products success ", "[POST] Products failure ");
            return entity != null
                    ? ResponseEntity.ok().body(ProductMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity updateProduct(Product model) {
        try {
            ProductEntity entity = productRepository.findByProductId(model.getProductId());
            entity.setProductName(model.getProductName());
            entity.setProductDescription(model.getProductDescription());
            entity.setProductPrice(model.getProductPrice());
            productRepository.save(entity);
            LogFactory.productInfo(entity, "[PATCH] Product updated ", "[PATCH] Product failure ");
            return entity != null
                    ? ResponseEntity.ok().body(ProductMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity deleteProduct(Long id) {
        try {
            ProductEntity entity = productRepository.findByProductId(id);
            return productRepository.findById(id).map(record -> {
                LogFactory.productInfo(entity, "[DELETE] Product deleted ", "[DELETE]Product failure ");
                productRepository.deleteById(id);
                return ResponseEntity.ok().body(id);
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
