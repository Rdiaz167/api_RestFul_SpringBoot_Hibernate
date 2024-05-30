package com.api.restful.springboot_api_restful_hibernate.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.restful.springboot_api_restful_hibernate.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
