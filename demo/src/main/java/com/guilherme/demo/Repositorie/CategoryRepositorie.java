package com.guilherme.demo.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.demo.entities.Category;


public interface CategoryRepositorie extends JpaRepository<Category, Long>{
    
    
}
