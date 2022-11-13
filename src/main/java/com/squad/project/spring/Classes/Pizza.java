package com.squad.project.spring.Classes;

import javax.persistence.*;
import java.util.Collection;

import com.squad.project.spring.Enum.PizzaTopping;
import com.squad.project.spring.Enum.PizzaType;
import lombok.Data;

@Entity
@Table(name = "PIZZA_TABLE")
@Data
public class Pizza{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    private Collection<PizzaTopping> pizzaToppings;

    private PizzaType pizzaType;

    private Double cost;

    public Pizza(Collection<PizzaTopping> pizzaToppings, PizzaType pizzaType, Double cost) {
        this.pizzaToppings = pizzaToppings;
        this.pizzaType = pizzaType;
        this.cost = cost;
    }

    public Pizza() {}

    @Override
    public String toString() {
        return "Pizza{" + "id=" + this.id + ", " + "pizzaToppings=" + this.pizzaToppings.toString() + ", " + "pizzaType=" + this.pizzaType + ", " + "cost=" + this.cost +"}";
    }
}
