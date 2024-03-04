package com.guilherme.demo.resurces;

import org.springframework.web.bind.annotation.RestController;

import com.guilherme.demo.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value ="/users")
public class UserResurce {

    @GetMapping
    public ResponseEntity<User> findall(){
        User u = new User(1L, "guilherme", "gui@gmail.com", "14999992031");
        return ResponseEntity.ok().body(u);
    }
}
