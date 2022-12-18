package com.desafioViaSoluti.demo.web.mapper;

import com.desafioViaSoluti.demo.percistence.entity.CartEntity;
import com.desafioViaSoluti.demo.service.model.Cart;

import java.util.List;
import java.util.stream.Collectors;
public class CartMapper {
    private CartMapper() { super(); }
    public static List<CartEntity> marshall(List<Cart> models) {
        return models.stream().map(CartMapper::marshall).collect(Collectors.toList());
    }
    public static List<Cart> unmarshall(List<CartEntity> entities) {
        return entities.stream().map(CartMapper::unmarshall).collect(Collectors.toList());
    }
    public static CartEntity marshall(Cart model) {
        return CartEntity.builder()
                .cartId(model.getCartId())
                .user(UserMapper.marshall(model.getUser()))
                .products(ProductMapper.marshall(model.getProducts()))
                .creationDate(model.getUserCreationDate())
                .build();
    }
    public static Cart unmarshall(CartEntity entity) {
        return Cart.builder()
                .cartId(entity.getCartId())
                .user(UserMapper.unmarshall(entity.getUser()))
                .products(ProductMapper.unmarshall(entity.getProducts()))
                .userCreationDate(entity.getCreationDate())
                .build();
    }
}
