package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;

import com.squad.project.spring.DTO.*;

@Data
public class PizzaDTO{
    private Long id;

    private List<String> pizzaTopList;

    private String pizzaType;

    private double cost;

    public PizzaDTO(List<String> pizzaTopList, String pizzaType, double cost) {
        this.pizzaTopList = pizzaTopList;
        this.pizzaType = pizzaType;
        this.cost = cost;
    }


    @Override
    public String toString() 
    {
        //TODO
        return "";
    }
}
