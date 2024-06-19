package com.api.restful.springboot_api_restful_hibernate.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restful.springboot_api_restful_hibernate.entities.Product;
import com.api.restful.springboot_api_restful_hibernate.services.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    //MOSTRAR TODO
    @GetMapping
    public List<Product> list() {
        return (List<Product>) service.findAll();
    }

    //BUSCAR ID
    @GetMapping("/{id}")    
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //AGREGAR
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    //ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = service.update(id, product);
        if(productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //ELIMINAR

}
