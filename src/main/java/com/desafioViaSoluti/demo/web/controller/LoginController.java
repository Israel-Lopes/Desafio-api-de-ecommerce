package com.desafioViaSoluti.demo.web.controller;

import com.desafioViaSoluti.demo.service.LoginService;
import com.desafioViaSoluti.demo.service.ProductService;
import com.desafioViaSoluti.demo.service.model.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class LoginController {
    public static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired(required=true)
    private LoginService service;
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity login(@RequestBody Login model) throws Exception {
        return service.loginUser(model);
    }
}
