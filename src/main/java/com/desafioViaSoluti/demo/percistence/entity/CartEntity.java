package com.desafioViaSoluti.demo.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductEntity> products;

    @CreationTimestamp
    @Column(name = "creation_date",columnDefinition = "date")
    private LocalDate creationDate;
}
