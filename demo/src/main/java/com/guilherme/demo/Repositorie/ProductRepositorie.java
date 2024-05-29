package com.guilherme.demo.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.demo.entities.Product;


public interface ProductRepositorie extends JpaRepository<Product, Long>{
    
    
}
