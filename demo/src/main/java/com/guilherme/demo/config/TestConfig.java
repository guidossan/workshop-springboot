package com.guilherme.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guilherme.demo.Repositorie.UserRepositorie;
import com.guilherme.demo.entities.User;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private UserRepositorie userRepositorie;


    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777"); 
        User u3 = new User(null, "guilherme", "gui@gmail.com", "14999992031");
        

        userRepositorie.saveAll(Arrays.asList(u1, u2, u3));
    }


}
