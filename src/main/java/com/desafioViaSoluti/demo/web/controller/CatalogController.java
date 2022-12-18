package com.desafioViaSoluti.demo.web.controller;

import com.desafioViaSoluti.demo.service.CatalogService;
import com.desafioViaSoluti.demo.service.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/catalog")
@RestController
public class CatalogController {
    @Autowired(required=true)
    CatalogService service;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getCatalogList() throws Exception {
        return service.getCatalogList();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity getCatalog(@PathVariable Long id) throws Exception {
        return service.getCatalog(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity createCatalog(@RequestBody Catalog model) throws Exception {
        return service.createCatalog(model);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity updateCatalog(@RequestBody Catalog model) throws Exception {
        return service.updateCatalog(model);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteCatalog(@PathVariable Long id) throws Exception {
        return service.deleteCatalog(id);
    }
}
