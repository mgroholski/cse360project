package com.squad.project.view.studentTab;

import com.squad.project.spring.Classes.Pizza;
import com.squad.project.spring.Enum.OrderStatus;
import com.squad.project.spring.Enum.PizzaTopping;
import com.squad.project.spring.Enum.PizzaType;
import com.squad.project.spring.Enum.UserRole;
import com.squad.project.spring.MainService;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.ArrayList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.squad.project.spring.DTO.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class StudentTabController implements Initializable {
    @FXML private RadioButton cheese;
    @FXML private RadioButton vegetable;
    @FXML private RadioButton pepperoni;
    @FXML private CheckBox mushrooms;
    @FXML private CheckBox onions;
    @FXML private CheckBox olives;
    @FXML private CheckBox extraCheese;
    @FXML private Button addPizza;
    @FXML private Button placeOrder;
    @FXML private Button removePizza;
    @FXML private ListView<PizzaDTO> studentPizzas;

    private List<PizzaDTO> inCart;

    private MainService mainService;

    @Autowired
    public StudentTabController(MainService mainService) {
        this.inCart = new ArrayList<>();
        this.mainService = mainService;
    }

    public StudentTabController() {
        this.inCart = new ArrayList<>();
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
            cost += 1.50;
        }
        if (onions.isSelected()) {
            toppings.add(PizzaTopping.ONIONS);
    
            cost += 1.50;
        }
        if (olives.isSelected()) {
            toppings.add(PizzaTopping.OLIVES);
            cost += 1.50;
        }
        if (extraCheese.isSelected()) {
            toppings.add(PizzaTopping.EXTRA_CHEESE);
            cost += 1.50;
        }
        pizza.setPizzaToppings(toppings);
        if (cheese.isSelected()) {
            pizza.setPizzaType(PizzaType.CHEESE);
            cost += 10.00;
        } else if (vegetable.isSelected()) {
            pizza.setPizzaType(PizzaType.VEGETABLE);
            cost += 15.00;
        } else if (pepperoni.isSelected()) {
            pizza.setPizzaType(PizzaType.PEPPERONI);
            cost += 12.00;
        }

        pizza.setCost(cost);

        inCart.add(pizza);

        ObservableList<PizzaDTO> newList = studentPizzas.getItems();
        newList.add(pizza);
        studentPizzas.setItems(newList);
    }

    @FXML
    private void placeOrder(ActionEvent event) {
        event.consume();

        TextInputDialog inputId = new TextInputDialog("Enter student ID");
        inputId.setContentText("ID: ");
        inputId.setHeaderText("Input ID here");

        inputId.showAndWait();
        String inp = inputId.getEditor().getText();
        if(inp.length() != 10) {
            inputId.setContentText("Invalid ID, must be 10 digits long and be a number.");
            return;
        }
        Long id = Long.parseLong(inp);


        StudentDTO student = new StudentDTO(id);
        StudentDTO r = mainService.login(student);
        if (r == null) {
            student.setUserRole(UserRole.Student);
            mainService.createStudent(student);
        }

        OrderDTO newOrder = new OrderDTO();
        Double cost = 0.0;

        for (PizzaDTO pizza : inCart) {
            mainService.createPizza(pizza);
            cost += pizza.getCost();
        }

        newOrder.setPizzas(inCart);
        newOrder.setCost(cost);
        newOrder.setOrderStatus(OrderStatus.ACCEPTED);
        mainService.createOrder(newOrder);

        ObservableList<PizzaDTO> emptyList = studentPizzas.getItems();
        emptyList.clear();
        inCart.clear();
        studentPizzas.setItems(emptyList);
    }

    @FXML
    private void removePizza(ActionEvent event) {
        event.consume();
        PizzaDTO item = studentPizzas.getSelectionModel().getSelectedItem();
        
        //Remove pizza from inCart
        inCart.remove(item);

        ObservableList<PizzaDTO> newList = studentPizzas.getItems();
        newList.remove(item);
        studentPizzas.setItems(newList);            
    }

}
