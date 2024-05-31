package com.guilherme.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.demo.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant time;


    private Integer orderStatus;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
    @JsonIgnore
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Order(){
        
    }
    public Order(Long id, Instant time, User client, OrderStatus orderStatus) {
        this.id = id;
        this.time = time;
        setOrderStatus(orderStatus);
        this.client = client;
    }
    public Long getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){

            this.orderStatus = orderStatus.getCode();
        }
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getTime() {
        return time;
    }
    public void setTime(Instant time) {
        this.time = time;
    }
    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItens(){
        return items;
    }
    public Double getTotal(){
        double soma = 0;
        for(OrderItem x: items){
            soma += x.getSubTotal();
        }
        return soma;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    


}
