package com.guilherme.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.demo.Repositorie.UserRepositorie;
import com.guilherme.demo.entities.User;

@Service
public class UserServices {
    
    @Autowired
    private UserRepositorie repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();   
    }

    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
