package com.desafioViaSoluti.demo.percistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long userId;
    @Column(name = "name", nullable = false)
    private String userName;
    @Column(name = "email", nullable = false)
    private String userEmail;
    @Column(name = "password", nullable = false)
    private String userPassword;
    @CreationTimestamp
    @Column(name = "creation_date",columnDefinition = "date")
    private LocalDate userCreationDate;
    @Column(name = "token")
    private String userToken;
}
