package com.guilherme.demo.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guilherme.demo.entities.Order;

public interface OrderRepositorie extends JpaRepository<Order, Long>{
    
}
