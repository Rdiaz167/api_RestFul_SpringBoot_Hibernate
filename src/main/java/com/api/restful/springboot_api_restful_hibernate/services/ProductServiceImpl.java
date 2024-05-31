package com.api.restful.springboot_api_restful_hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.restful.springboot_api_restful_hibernate.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
}
