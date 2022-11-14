package com.squad.project.spring.Classes;

import com.squad.project.spring.Enum.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDER_TABLE")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pizza_ids")
    private List<Pizza> pizzas;

    private OrderStatus orderStatus;
    private Double cost;

    public Order(List<Pizza> pizzas, OrderStatus status, Double cost) {
        this.pizzas = pizzas;
        this.orderStatus = status;
        this.cost = cost;
    }

    public Order() {}

    @Override
    public String toString() {
        return "Order{" + "id=" + this.id + ", " + "pizzas=" + this.pizzas.toString() + ", " + "status=" + this.orderStatus + ", " + "cost=" + this.cost +  "}";
    }
}



