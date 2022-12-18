package com.desafioViaSoluti.demo.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private LocalDate userCreationDate;
    private String userToken;
}
