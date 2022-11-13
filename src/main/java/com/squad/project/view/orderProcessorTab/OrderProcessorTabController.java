package com.squad.project.view.orderProcessorTab;

import java.net.URL;
import java.util.ResourceBundle;

import com.squad.project.spring.Classes.Order;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class OrderProcessorTabController {
    
    @FXML ListView<Order> acceptedList;

    public void initialize(URL location, ResourceBundle resources) {
        //TODO add all orders with status ACCEPTED to ListView acceptedList

    }
    
    public void updateReadyToCook(MouseEvent event) {
        int selectedID = acceptedList.getSelectionModel().getSelectedIndex();
        //TODO Change status of selected order to READY to COOK
        acceptedList.getItems().remove(selectedID);
    }

        //List<OrderDTO> getAllOrders()
}
