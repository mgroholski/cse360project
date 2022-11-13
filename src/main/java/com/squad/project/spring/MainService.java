package com.squad.project.spring;

import com.squad.project.spring.DTO.OrderDTO;
import com.squad.project.spring.DTO.PizzaDTO;
import com.squad.project.spring.DTO.StudentDTO;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class MainService {
    public OrderDTO createOrder(OrderDTO order) {
        //TODO
        return order;
    }

    public OrderDTO updateOrder(OrderDTO order) {
        //TODO
        return order;
    }

    public StudentDTO createStudent(StudentDTO student) {
        //TODO
        return student;
    }

    //Returns null if invalid login, else returns the Student data
    public StudentDTO login(StudentDTO student) {
        //TODO
        return student;
    }

    public PizzaDTO createPizza(PizzaDTO pizza) {
        //TODO
        return pizza;
    }
}