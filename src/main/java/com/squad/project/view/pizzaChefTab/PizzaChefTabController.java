package com.squad.project.view.pizzaChefTab;

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
public class PizzaChefTabController implements Initializable {
    
    @FXML ListView<OrderDTO> readyToCookList;
    @FXML ListView<OrderDTO> cookingList;
    
    @Autowired
    private MainService mainService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayAllOrders(OrderStatus.READY_TO_COOK, readyToCookList);
        displayAllOrders(OrderStatus.COOKING, cookingList);
    }

    public void displayAllOrders(OrderStatus status, ListView<OrderDTO> view) {
        ObservableList<OrderDTO> list = view.getItems();
        List<OrderDTO> allOrders = mainService.getAllOrders(status);
        for (OrderDTO o : allOrders) {
            list.add(o);
        }
        view.setItems(list);
    }


    public void updateCooking(OrderDTO order) {
        ObservableList<OrderDTO> list = readyToCookList.getItems();
        list.remove(order);
        readyToCookList.setItems(list);              
    }

    public void updateReady(OrderDTO order) {
        ObservableList<OrderDTO> list = readyToCookList.getItems();
        list.remove(order);
        readyToCookList.setItems(list);
        list = cookingList.getItems();
        list.add(order);
        cookingList.setItems(list);
    }

        //Ready to cook
        //OrderDTO changeStatus(long orderId, String status)
        //status = "Ready"
    @FXML
    public void changeStatusToCooking() {
        OrderDTO o = readyToCookList.getSelectionModel().getSelectedItem();
        if (o.getOrderStatus() == OrderStatus.READY_TO_COOK) 
        {
            o.setOrderStatus(OrderStatus.COOKING);
        }
        updateReady(o);
        mainService.updateOrder(o);
    }
        //Finish order
        //OrderDTO changeStatus(long orderId, String status)
        //status = "Finish"
    @FXML
    public void changeStatusToFinished()
    {
        OrderDTO o = cookingList.getSelectionModel().getSelectedItem();
        if(o.getOrderStatus() == OrderStatus.COOKING)
        {
            o.setOrderStatus(OrderStatus.FINISHED);
        }
        updateCooking(o);
        mainService.updateOrder(o);
    }
}
