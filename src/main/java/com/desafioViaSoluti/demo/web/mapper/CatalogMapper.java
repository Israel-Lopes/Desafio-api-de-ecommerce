package com.desafioViaSoluti.demo.web.mapper;

import com.desafioViaSoluti.demo.percistence.entity.CatalogEntity;
import com.desafioViaSoluti.demo.service.model.Catalog;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogMapper {
    private CatalogMapper() {
        super();
    }
    public static List<CatalogEntity> marshall(List<Catalog> models) {
        return models.stream().map(CatalogMapper::marshall).collect(Collectors.toList());
    }
    public static List<Catalog> unmarshall(List<CatalogEntity> entities) {
        return entities.stream().map(CatalogMapper::unmarshall).collect(Collectors.toList());
    }
    public static CatalogEntity marshall(Catalog model) {
        return CatalogEntity.builder()
                .catalogId(model.getCatalogId())
                .catalogName(model.getCatalogName())
                .products(ProductMapper.marshall(model.getProducts()))
                .build();
    }
    public static Catalog unmarshall(CatalogEntity entity) {
        return Catalog.builder()
                .catalogId(entity.getCatalogId())
                .catalogName(entity.getCatalogName())
                .products(ProductMapper.unmarshall(entity.getProducts()))
                .build();
    }
}
