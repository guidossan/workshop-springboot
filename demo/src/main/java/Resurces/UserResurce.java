package main.java.Resurces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.Entities.Users;

@RestController
@RequestMapping(value = "/users")
public class UserResurce {
    
    public ResponseEntity<Users> findAll(){
        
    }
}
