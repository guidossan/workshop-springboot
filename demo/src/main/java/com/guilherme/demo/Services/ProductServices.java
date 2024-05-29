package com.guilherme.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.demo.Repositorie.ProductRepositorie;
import com.guilherme.demo.entities.Product;

@Service
public class ProductServices {
    
    @Autowired
    private ProductRepositorie repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();   
    }
}
