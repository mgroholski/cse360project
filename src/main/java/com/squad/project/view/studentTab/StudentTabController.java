package com.squad.project.view.studentTab;

import com.squad.project.spring.Classes.Pizza;
import com.squad.project.spring.MainService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.ArrayList;

import java.net.URL;
import java.util.ResourceBundle;

import com.squad.project.spring.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentTabController implements Initializable{
    @FXML private RadioButton cheese;
    @FXML private RadioButton vegetable;
    @FXML private RadioButton pepperoni;
    @FXML private ToggleGroup pizzaType;
    @FXML private CheckBox mushrooms;
    @FXML private CheckBox onions;
    @FXML private CheckBox olives;
    @FXML private CheckBox extraCheese;
    @FXML private Button addPizza;
    @FXML private Button placeOrder;
    @FXML private Button removePizza;
    @FXML private ListView studentPizzas;

    private MainService mainService;

    @Autowired
    public StudentTabController(MainService mainService) {
        this.mainService = mainService;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //Creates pizza
//        PizzaDTO newPizza = new PizzaDTO();
//        //Add attributes
//        mainService.createPizza(newPizza);
    }



//
//    public
//    FXMLLoader loader = new FXMLLoader();
//
//    pizzaType.getSelectedToggle();
//
//    //choose topping
//    cheese.setToggleGroup(pizzaType);
//    pepperoni.setToggleGroup(pizzaType);
//    vegetable.setToggleGroup(pizzaType);
//
//    cheese.setOnAction(e -> cost += 12.00);
//    pepperoni.setOnAction(e -> pizzaType = "pepperoni");
//    vegetable.setOnAction(e -> pizzaType = "vegetable");
//
//
//
//    if(mushrooms.isSelected()){
//        toppings.add("mushrooms");
//        cost += 1.5;
//    }
//    if(onions.isSelected()){
//        toppings.add("onions");
//        cost += 1.5;
//    }
//    if(olives.isSelected()){
//        toppings.add("olives");
//        cost += 1.5;
//    }
//    if(extraCheese.isSelected()){
//        toppings.add("extraCheese");
//        cost += 1.5;
//    }
//
//    //pizza.pizzaType= pizzaType;
//    //pizza.pizzaTopList= toppings;
//    //pizza.cost= cost;
//    pizza.PizzaDTO(toppings, pizzaType, cost);
//
//    addPizza.setOnAction(e -> studentPizzas.add(pizza.toString()));
//
//    removePizza.setOnAction(e -> studentPizzas.remove(0));
//
//    placeOrder.setOnAction(e -> order.addAll(pizzas));
}
