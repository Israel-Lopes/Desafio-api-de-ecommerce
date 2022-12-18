package com.desafioViaSoluti.demo.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long productId;
    @Column(name = "name", nullable = false)
    private String productName;
    @Column(name = "price", nullable = false)
    private Double productPrice;
    @Column(name = "description", columnDefinition = "varchar(255) default 'Produto não possui descrição'")
    private String productDescription;
}
