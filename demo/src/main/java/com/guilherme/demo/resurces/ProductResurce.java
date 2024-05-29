package com.guilherme.demo.resurces;

import org.springframework.web.bind.annotation.RestController;

import com.guilherme.demo.Services.ProductServices;
import com.guilherme.demo.entities.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(value ="/products")
public class ProductResurce {

    @Autowired
    private ProductServices ProductService;
    @GetMapping
    public ResponseEntity<List<Product>> findall(){
        List<Product> list = ProductService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = ProductService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
