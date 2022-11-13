package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;

import com.squad.project.spring.Classes.Pizza;
import com.squad.project.spring.Enum.OrderStatus;
import lombok.Data;

import com.squad.project.spring.DTO.*;

@Data
public class OrderDTO{
    private Long id;
    private List<Pizza> pizzas;
    private OrderStatus orderStatus;
    private Double cost;

    public OrderDTO(List<Pizza> pizzas, OrderStatus status, Double cost) {
        this.pizzas = pizzas;
        this.orderStatus = status;
        this.cost = cost;
    }

    public OrderDTO() {}

    @Override
    public String toString() {
        return "OrderDTO{" + "id=" + this.id + ", " + "pizzas=" + this.pizzas.toString() + ", " + "status=" + this.orderStatus + ", " + "cost=" + this.cost +  "}";
    }
}
