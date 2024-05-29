package com.guilherme.demo.resurces;

import org.springframework.web.bind.annotation.RestController;

import com.guilherme.demo.Services.CategoryService;
import com.guilherme.demo.entities.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(value ="/categories")
public class CategoryResurce {

    @Autowired
    private CategoryService CategoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findall(){
        List<Category> list = CategoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = CategoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
