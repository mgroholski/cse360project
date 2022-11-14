package com.squad.project.spring.Classes;

import javax.persistence.*;
import java.util.List;

import com.squad.project.spring.Enum.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STUDENT_TABLE")
@Getter
@Setter
public class Student{
    @Id
    private Long id;

    private Long studentId;

    private UserRole userRole;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pizza_order_id")
    private List<Order> pizzaOrders;

    public Student(UserRole role, List<Order> orders) {
        this.userRole = role;
        this.pizzaOrders = orders;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" + "id=" + this.id + ", " + "role=" + this.userRole + ", " + "orders=" + this.pizzaOrders.toString() + "}";
    }
}



