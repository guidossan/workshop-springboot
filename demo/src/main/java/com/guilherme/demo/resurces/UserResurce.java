package com.guilherme.demo.resurces;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guilherme.demo.Services.UserServices;
import com.guilherme.demo.entities.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(value ="/users")
public class UserResurce {

    @Autowired
    private UserServices userService;
    @GetMapping
    public ResponseEntity<List<User>> findall(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
}
