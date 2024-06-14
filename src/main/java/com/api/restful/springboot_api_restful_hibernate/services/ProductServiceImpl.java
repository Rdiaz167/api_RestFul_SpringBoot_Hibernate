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
    @Override
    @Transactional
    public Product save(Product product){
        return repository.save(product);
    }

    //ACTUALIZAR
    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product){
        Optional<Product> productOptional = repository.findById(id);

        if (productOptional.isPresent()) {
            Product productDb = productOptional.orElseThrow();

            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            productDb.setDescription(product.getDescription());

            return Optional.of(repository.save(productDb));            
        }
        return productOptional;
    }

    //ELIMINAR
    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = repository.findById(id);
        productOptional.ifPresent(productDb->{
            repository.delete(productDb);;
        });
        return productOptional;
    }
}
