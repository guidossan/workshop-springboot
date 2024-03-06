package com.guilherme.demo.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.demo.Services.OrderServices;
import com.guilherme.demo.entities.Order;

@RestController
@RequestMapping(value ="/orders")
public class OrderResurce {
    

    @Autowired
    private OrderServices OrderService;
    @GetMapping
    public ResponseEntity<List<Order>> findall(){
        List<Order> list = OrderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = OrderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
