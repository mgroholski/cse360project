package com.squad.project.view.studentTab;

import com.squad.project.spring.Classes.Pizza;
import com.squad.project.spring.Enum.PizzaTopping;
import com.squad.project.spring.Enum.PizzaType;
import com.squad.project.spring.MainService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.ArrayList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.squad.project.spring.DTO.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@FxmlView("StudentTab.fxml")
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

    private List<PizzaDTO> inCart;

    @Autowired
    private MainService mainService;

    public StudentTabController() {
        inCart = new ArrayList<>();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    private void addPizza(ActionEvent event) {
        event.consume();
        double cost = 0;
        PizzaDTO pizza = new PizzaDTO();
        List<PizzaTopping> toppings = new ArrayList<>();

        if (mushrooms.isSelected()) {
            toppings.add(PizzaTopping.MUSHROOMS);
            //TODO: Add cost
        }
        if (onions.isSelected()) {
            toppings.add(PizzaTopping.ONIONS);
            //TODO: Add cost
        }
        if (olives.isSelected()) {
            toppings.add(PizzaTopping.OLIVES);
            //TODO: Add cost
        }
        if (extraCheese.isSelected()) {
            toppings.add(PizzaTopping.EXTRA_CHEESE);
            //TODO: Add cost
        }
        pizza.setPizzaToppings(toppings);
        if (cheese.isSelected()) {
            pizza.setPizzaType(PizzaType.CHEESE);
            //TODO: Add cost
        } else if (vegetable.isSelected()) {
            pizza.setPizzaType(PizzaType.VEGETABLE);
            //TODO: Add cost
        } else if (pepperoni.isSelected()) {
            pizza.setPizzaType(PizzaType.PEPPERONI);
            //TODO: Add cost
        }

        pizza.setCost(cost);
        inCart.add(pizza);

        //TODO: Display pizza on pizzas in cart
    }

    @FXML
    private void placeOrder(ActionEvent event) {
        event.consume();
        //TODO: Create pizza order
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
