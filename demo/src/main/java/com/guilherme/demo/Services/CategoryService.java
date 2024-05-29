package com.guilherme.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.demo.Repositorie.CategoryRepositorie;
import com.guilherme.demo.entities.Category;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepositorie repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();   
    }
}
