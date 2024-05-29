package com.guilherme.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guilherme.demo.Repositorie.CategoryRepositorie;
import com.guilherme.demo.Repositorie.OrderRepositorie;
import com.guilherme.demo.Repositorie.UserRepositorie;
import com.guilherme.demo.entities.Category;
import com.guilherme.demo.entities.Order;
import com.guilherme.demo.entities.User;
import com.guilherme.demo.entities.enums.OrderStatus;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private UserRepositorie userRepositorie;

    @Autowired
    private CategoryRepositorie categoryRepositorie;

    @Autowired
    private OrderRepositorie orderRepositorie;


    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers"); 

        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777"); 
        User u3 = new User(null, "guilherme", "gui@gmail.com", "14999992031");
        

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1,OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.SHIPERED); 
        

        categoryRepositorie.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepositorie.saveAll(Arrays.asList(u1, u2, u3));
        orderRepositorie.saveAll(Arrays.asList(o1, o2, o3));
    }


}
