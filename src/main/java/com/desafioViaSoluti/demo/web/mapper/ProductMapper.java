package com.desafioViaSoluti.demo.web.mapper;

import com.desafioViaSoluti.demo.percistence.entity.ProductEntity;
import com.desafioViaSoluti.demo.service.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    private ProductMapper() {
        super();
    }
    public static List<ProductEntity> marshall(List<Product> models) {
        return models.stream().map(ProductMapper::marshall).collect(Collectors.toList());
    }
    public static List<Product> unmarshall(List<ProductEntity> entities) {
        return entities.stream().map(ProductMapper::unmarshall).collect(Collectors.toList());
    }
    public static ProductEntity marshall(Product model) {
        return ProductEntity.builder()
                .productId(model.getProductId())
                .productName(model.getProductName())
                .productPrice(model.getProductPrice())
                .productDescription(model.getProductDescription())
                .build();
    }
    public static Product unmarshall(ProductEntity entity) {
        return Product.builder()
                .productId(entity.getProductId())
                .productPrice(entity.getProductPrice())
                .productName(entity.getProductName())
                .productDescription(entity.getProductDescription())
                .build();

    }
}
