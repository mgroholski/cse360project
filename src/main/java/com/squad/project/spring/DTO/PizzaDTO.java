package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.List;

import com.squad.project.spring.Enum.PizzaTopping;
import com.squad.project.spring.Enum.PizzaType;
import lombok.Data;

import com.squad.project.spring.DTO.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {

    private Long id;

    private Collection<PizzaTopping> pizzaToppings;

    private PizzaType pizzaType;

    private Double cost;

    public PizzaDTO(Collection<PizzaTopping> pizzaToppings, PizzaType pizzaType, Double cost) {
        this.pizzaToppings = pizzaToppings;
        this.pizzaType = pizzaType;
        this.cost = cost;
    }

    public PizzaDTO() {}

    @Override
    public String toString() {
        return "PizzaDTO{" + "id=" + this.id + ", " + "pizzaToppings=" + this.pizzaToppings.toString() + ", " + "pizzaType=" + this.pizzaType + ", " + "cost=" + this.cost +"}";
    }
}
