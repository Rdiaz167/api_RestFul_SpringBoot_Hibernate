package com.api.restful.springboot_api_restful_hibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.restful.springboot_api_restful_hibernate.entities.Product;
import com.api.restful.springboot_api_restful_hibernate.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    //MOSTRAR TODO
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return (List<Product>) repository.findAll();
    }

    //BUSCAR POR ID
    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id){
        return repository.findById(id);
    }

    //AGREGAR

    //ACTUALIZAR

    //ELIMINAR
}
