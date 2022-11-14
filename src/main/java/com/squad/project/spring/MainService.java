package com.squad.project.spring;

import com.squad.project.spring.Classes.Order;
import com.squad.project.spring.Classes.Pizza;
import com.squad.project.spring.Classes.Student;
import com.squad.project.spring.DTO.OrderDTO;
import com.squad.project.spring.DTO.PizzaDTO;
import com.squad.project.spring.DTO.StudentDTO;
import com.squad.project.spring.Repositories.OrderRepository;
import com.squad.project.spring.Repositories.PizzaRepository;
import com.squad.project.spring.Repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MainService {
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public OrderDTO createOrder(OrderDTO order) {
        //Maps to order
        Order o = modelMapper.map(order, Order.class);
        //Maps back to orderDTO after save
        return modelMapper.map(orderRepository.save(o), OrderDTO.class);
    }

    public OrderDTO updateOrder(OrderDTO order) {
        Order o = orderRepository.findById(order.getId()).orElseThrow(() -> new RuntimeException("No order found with id " + order.getId()));
        o.setId(order.getId());
        o.setCost(order.getCost());
        o.setOrderStatus(order.getOrderStatus());
        o.setPizzas(order.getPizzas());

        return modelMapper.map(orderRepository.save(o), OrderDTO.class);
    }

    public StudentDTO createStudent(StudentDTO student) {
        Student s = modelMapper.map(student, Student.class);
        return modelMapper.map(studentRepository.save(s), StudentDTO.class);
    }

    //Returns null if invalid login, else returns the Student data
    public StudentDTO login(StudentDTO student) {
        Optional<Student> s = studentRepository.findById(student.getId());
        if (s.isEmpty())
            return null;
        return modelMapper.map(s, StudentDTO.class);
    }

    //Saves database
    public PizzaDTO createPizza(PizzaDTO pizza) {
        Pizza p = modelMapper.map(pizza, Pizza.class);
        return modelMapper.map(pizzaRepository.save(p), PizzaDTO.class);
    }
}