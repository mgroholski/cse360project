package com.squad.project.spring;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "ORDER")
@Data
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany()
    private List<Pizza> pizzas;

    @Override
    public String toString() {
        //TODO
        return "";
    }

}



