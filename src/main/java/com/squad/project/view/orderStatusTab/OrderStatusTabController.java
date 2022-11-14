package com.squad.project.view.orderStatusTab;

import java.net.URL;
import java.util.ResourceBundle;

import com.squad.project.spring.Classes.Student;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView("OrderStatusTab.fxml")
public class OrderStatusTabController {
    
    @FXML ListView<Student> allOrderList;

    public void initialize(URL location, ResourceBundle resources) {
        
    }
    

        //List<OrderDTO> getAllOrders()
    
}
