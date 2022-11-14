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
import lombok.NoArgsConstructor;
import org.jboss.jandex.Main;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.squad.project.spring.Enum.OrderStatus;

@Service
public class MainService {

    private final OrderRepository orderRepository;

    private final PizzaRepository pizzaRepository;

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    MainService(OrderRepository orderRepository, PizzaRepository pizzaRepository, StudentRepository studentRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    private List<Pizza> convertToPizza(List<PizzaDTO> l) {
        List<Pizza> pizzas = new ArrayList<>();
        for(PizzaDTO pizza: l) {
            pizzas.add(modelMapper.map(pizza, Pizza.class));
        }
        return pizzas;
    }

    public OrderDTO createOrder(OrderDTO order) {
        //Maps to order
        Order o = modelMapper.map(order, Order.class);

        o = orderRepository.save(o);
        //Maps back to orderDTO after save
        return modelMapper.map(o, OrderDTO.class);
    }

    public OrderDTO updateOrder(OrderDTO order) {
        Order o = orderRepository.findById(order.getId()).orElseThrow(() -> new RuntimeException("No order found with id " + order.getId()));
        o.setId(order.getId());
        o.setCost(order.getCost());
        o.setOrderStatus(order.getOrderStatus());
        o.setPizzas(convertToPizza(order.getPizzas()));

        return modelMapper.map(orderRepository.save(o), OrderDTO.class);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> r = new ArrayList<>();
        for (Order o : orders) {
            r.add(modelMapper.map(o, OrderDTO.class));
        }
        return r;
    }

    public List<OrderDTO> getAllOrders(OrderStatus status) {
        List<Order> orders = orderRepository.getAllByStatus(status);
        List<OrderDTO> mapped = new ArrayList<>();
        for (Order o : orders) {
            mapped.add(modelMapper.map(o, OrderDTO.class));
        }
        return mapped;
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