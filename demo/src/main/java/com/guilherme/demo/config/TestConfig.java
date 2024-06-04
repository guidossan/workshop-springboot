package com.guilherme.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guilherme.demo.Repositorie.CategoryRepositorie;
import com.guilherme.demo.Repositorie.OrderItemRepositorie;
import com.guilherme.demo.Repositorie.OrderRepositorie;
import com.guilherme.demo.Repositorie.ProductRepositorie;
import com.guilherme.demo.Repositorie.UserRepositorie;
import com.guilherme.demo.entities.Category;
import com.guilherme.demo.entities.Order;
import com.guilherme.demo.entities.OrderItem;
import com.guilherme.demo.entities.Payment;
import com.guilherme.demo.entities.Product;
import com.guilherme.demo.entities.User;
import com.guilherme.demo.entities.enums.OrderStatus;
@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private UserRepositorie userRepositorie;

    @Autowired
    private CategoryRepositorie categoryRepositorie;

    @Autowired
    private OrderRepositorie orderRepositorie;

    @Autowired
    private ProductRepositorie productRepositorie;

    @Autowired
    private OrderItemRepositorie orderItemRepositorie;

   
    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers"); 

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
        categoryRepositorie.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepositorie.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        
        p1.getCategories().add(cat1);
        p2.getCategories().add(cat2);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777"); 
        User u3 = new User(null, "guilherme", "gui@gmail.com", "14999992031");
        

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1,OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.SHIPERED); 
        
        productRepositorie.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        userRepositorie.saveAll(Arrays.asList(u1, u2, u3));
        orderRepositorie.saveAll(Arrays.asList(o1, o2, o3));


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepositorie.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));  
        
        Payment pay1 = new Payment(null, Instant.parse("2024-05-31T21:53:07Z"), o1);
        o1.setPayment(pay1);
        orderRepositorie.save(o1); 
         
    }


}
