package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;

import com.squad.project.spring.Classes.Order;
import com.squad.project.spring.Enum.UserRole;
import lombok.Data;

@Data
public class StudentDTO{
    private Long id;

    private UserRole userRole;

    private List<Order> pizzaOrders;

    public StudentDTO(UserRole role, List<Order> orders) {
        this.userRole = role;
        this.pizzaOrders = orders;
    }

    public StudentDTO(Long id) {
        this.id = id;
    }

    public StudentDTO() {

    }

    @Override
    public String toString() {
        return "Student info: {id: " + this.id + ", " + "role: " + this.userRole + ", " + "order(s): " + this.pizzaOrders.toString() + "} ";
    }
}
