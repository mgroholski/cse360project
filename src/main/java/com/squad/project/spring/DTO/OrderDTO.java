package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;

import com.squad.project.spring.DTO.*;

@Data
public class OrderDTO{
    private Long id;

    private List<PizzaDTO> pizzas;

    @Override
    public String toString() {
        //TODO
        return "";
    }
}