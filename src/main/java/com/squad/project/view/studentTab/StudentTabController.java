package com.squad.project.view.studentTab;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

import com.squad.project.spring.DTO.*;

public class StudentTabController {

    @FXML private RadioButton cheese;
    @FXML private RadioButton vegatable;
    @FXML private RadioButton pepperoni;
    @FXML private ToggleGroup pizzaType;
    @FXML private CheckBox mushrooms;
    @FXML private CheckBox onions;
    @FXML private CheckBox olives;
    @FXML private CheckBox extraCheese;
    @FXML private Button addPizza;
    @FXML private Button placeOrder;
    @FXML private Button removePizza;
    
    public void init() {
        FXMLLoader loader = new FXMLLoader();

        pizzaType.getSelectedToggle();

        String pizzaType = "PPI";
        ArrayList<String> toppings = new ArrayList();
        double cost = 40.00;

        PizzaDTO pizza = new PizzaDTO(toppings, pizzaType, cost);
        //bool createPizza(PizzaDTO pizza)

        long id = 1218442420;
        StudentDTO matthew = new StudentDTO(id);
        //StudentDTO login(StudentDTO student)
        //If null bad login
        //Else returns studentDTO

        //Gets all orders under student
        for(OrderDTO order: matthew.getOrders()) {
            System.out.println(order.toString());

            for (PizzaDTO za: order.getPizzas()) {
                System.out.println(za.toString());
            }
        }
    }
}
