package com.squad.project.view.orderStatusTab;

import com.squad.project.spring.Classes.Pizza;
import com.squad.project.spring.Enum.OrderStatus;
import com.squad.project.spring.Enum.PizzaTopping;
import com.squad.project.spring.Enum.PizzaType;
import com.squad.project.spring.MainService;

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
import net.rgielen.fxweaver.core.FxmlView;

import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class OrderStatusTabController {
    @Autowired
    private MainService mainService;

    @FXML ListView<OrderDTO> allOrderList;


    public void initialize(URL location, ResourceBundle resources) {
        displayAllOrders();
    }

    public void displayAllOrders() {
        System.out.println("Displaying all orders");
        ObservableList<OrderDTO> list = allOrderList.getItems();
        List<OrderDTO> allOrders = mainService.getAllOrders();
        for (OrderDTO o : allOrders) {
            list.add(o);
        }
        allOrderList.setItems(list);
    }
}
