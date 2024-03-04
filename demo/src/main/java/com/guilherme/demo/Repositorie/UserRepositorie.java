package com.guilherme.demo.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.demo.entities.User;

public interface UserRepositorie extends JpaRepository<User, Long>{
    
    
}
