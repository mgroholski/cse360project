package com.squad.project.view.orderProcessorTab;

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
public class OrderProcessorTabController implements Initializable {
    
    @FXML ListView<OrderDTO> acceptedList;

    @Autowired
    private MainService mainService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayAllReadyOrders();
    }

    public void displayAllReadyOrders() {
        ObservableList<OrderDTO> list = acceptedList.getItems();
        List<OrderDTO> allOrders = mainService.getAllOrders(OrderStatus.ACCEPTED);
        for (OrderDTO o : allOrders) {
            list.add(o);
        }
        acceptedList.setItems(list);
    }

    public void changeStatusToAccepted() {
        OrderDTO o = acceptedList.getSelectionModel().getSelectedItem();
        if (o.getOrderStatus() == OrderStatus.ACCEPTED) {
            o.setOrderStatus(OrderStatus.READY_TO_COOK);
        }
        mainService.updateOrder(o);

        ObservableList<OrderDTO> list = acceptedList.getItems();
        list.remove(o);
        acceptedList.setItems(list);
    }

}
