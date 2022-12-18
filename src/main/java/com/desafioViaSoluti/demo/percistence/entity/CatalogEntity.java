package com.desafioViaSoluti.demo.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_catalog")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long catalogId;
    @Column(name = "name", nullable = false)
    private String catalogName;
    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<ProductEntity> products;

}
