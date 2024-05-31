package com.guilherme.demo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.demo.entities.entitiesPk.OrderItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_order_item")
public class OrderItem implements Serializable{

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quatity;
    private Double price;

    public OrderItem(){

    }

    public OrderItem(Order order, Product product, Integer quatity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quatity = quatity;
        this.price = price;
    }
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }
  
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuatity() {
        return quatity;
    }
    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
