package com.api.restful.springboot_api_restful_hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    

    //AGREGAR

    //ACTUALIZAR

    //ELIMINAR

}
