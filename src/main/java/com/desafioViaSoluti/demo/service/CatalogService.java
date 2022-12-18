package com.desafioViaSoluti.demo.service;

import com.desafioViaSoluti.demo.percistence.entity.CatalogEntity;
import com.desafioViaSoluti.demo.repository.CatalogRepository;
import com.desafioViaSoluti.demo.service.logfatory.LogFactory;
import com.desafioViaSoluti.demo.service.model.Catalog;
import com.desafioViaSoluti.demo.web.mapper.CatalogMapper;
import com.desafioViaSoluti.demo.web.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired(required = true)
    CatalogRepository catalogRepository;

    public ResponseEntity getCatalogList() {
        try {
            List<CatalogEntity> entities = catalogRepository.findAll();
            LogFactory.catalogInfo(entities, "[GET - LIST] Catalog success ", "[GET - LIST] Catalog failure ");
            return !entities.isEmpty() || entities != null
                    ? ResponseEntity.ok().body(CatalogMapper.unmarshall(entities))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity getCatalog(Long id) {
        try {
            CatalogEntity entity = catalogRepository.findByCatalogId(id);
            LogFactory.catalogInfo(entity, "[GET] Catalog success ", "[GET] Catalog failure ");
            return entity != null
                    ? ResponseEntity.ok().body(CatalogMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public  ResponseEntity createCatalog(Catalog model) {
        try {
            CatalogEntity entity = catalogRepository.save(CatalogMapper.marshall(model));
            LogFactory.catalogInfo(entity, "[POST] Catalog success ", "[POST] Catalog failure ");
            return entity != null
                    ? ResponseEntity.ok().body(CatalogMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity updateCatalog(Catalog model) {
        try {
            CatalogEntity entity = catalogRepository.findByCatalogId(model.getCatalogId());
            LogFactory.catalogInfo(entity, "[UPDATE] Catalog success ", "[UPDATE] Catalog failure ");
            entity.setCatalogName(model.getCatalogName());
            entity.setProducts(ProductMapper.marshall(model.getProducts()));
            return entity != null
                    ? ResponseEntity.ok().body(CatalogMapper.unmarshall(entity))
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity deleteCatalog(Long id) {
        try {
            CatalogEntity entity = catalogRepository.findByCatalogId(id);
            return catalogRepository.findById(id).map(record -> {
                LogFactory.catalogInfo(entity, "[DELETE] Catalog success ", "[DELETE] Catalog failure ");
                catalogRepository.deleteById(id);
                return ResponseEntity.ok().body(id);
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
