package com.desafioViaSoluti.demo.web.controller;

import com.desafioViaSoluti.demo.service.CartService;
import com.desafioViaSoluti.demo.service.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired(required=true)
    CartService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getCart(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.getCart(request, id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createCart(HttpServletRequest request, @RequestBody Cart model) throws Exception {
        return service.createCart(request, model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateCart(HttpServletRequest request, @RequestBody Cart model) throws Exception {
        return service.updateCart(request, model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteCart(HttpServletRequest request, @PathVariable Long id) throws Exception {
        return service.deleteCart(request, id);
    }
}
