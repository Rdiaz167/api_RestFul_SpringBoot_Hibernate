package com.api.restful.springboot_api_restful_hibernate.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @id
    private Long id;

}
