package com.desafioViaSoluti.demo.web.controller;

import com.desafioViaSoluti.demo.service.RegistrationService;
import com.desafioViaSoluti.demo.service.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/registration")
@RestController
public class RegistrationController {
    @Autowired(required=true)
    private RegistrationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createUser(@RequestBody Registration model) throws Exception {
        return service.createUser(model);
    }
}
