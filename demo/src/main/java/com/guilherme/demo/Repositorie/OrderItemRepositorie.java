package com.guilherme.demo.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.demo.entities.OrderItem;
import com.guilherme.demo.entities.entitiesPk.OrderItemPk;

public interface OrderItemRepositorie extends JpaRepository<OrderItem, OrderItemPk>{
    
    
}
