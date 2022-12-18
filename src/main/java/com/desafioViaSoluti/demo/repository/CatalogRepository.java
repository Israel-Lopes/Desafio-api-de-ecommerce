package com.desafioViaSoluti.demo.repository;

import com.desafioViaSoluti.demo.percistence.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
    CatalogEntity findByCatalogId(Long id);
}
