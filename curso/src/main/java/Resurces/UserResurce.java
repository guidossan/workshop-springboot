package Resurces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entities.Users;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/users")

public class UserResurce {

    public ResponseEntity<Users> findAll(){
        Users usuario = new Users(1, "Guilherme", "gui@gmail.com", "12345678", "1234");
        return ResponseEntity.ok().body(usuario);
    }
}
