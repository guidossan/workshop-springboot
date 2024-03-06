package com.guilherme.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.demo.Repositorie.OrderRepositorie;
import com.guilherme.demo.entities.Order;

@Service
public class OrderServices {
    
    @Autowired
    private OrderRepositorie repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
