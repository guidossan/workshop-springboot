package com.guilherme.demo.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.demo.entities.OrderItem;

public interface OrderItemRepositorie extends JpaRepository<OrderItem, Long>{
    
    
}
