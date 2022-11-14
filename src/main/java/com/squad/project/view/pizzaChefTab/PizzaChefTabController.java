package com.squad.project.view.pizzaChefTab;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView("PizzaChefTab.fxml")
public class PizzaChefTabController {
    
    @FXML ListView readyToCookList;
    @FXML ListView cookingList;

    public void initialize(URL location, ResourceBundle resources) {
        //TODO add all orders with status  to ListView readyToCookList
    }


    public void updateCooking() {
        int selectedID = readyToCookList.getSelectionModel().getSelectedIndex();
        //TODO Change status of selected order to COOKING
        readyToCookList.getItems().remove(selectedID);
    }

    public void updateReady() {
        int selectedID = cookingList.getSelectionModel().getSelectedIndex();
        //TODO Change status of selected order to COOKING
        cookingList.getItems().remove(selectedID);
    }

    
        //Clicks studentTab

        //Ready to cook
        //OrderDTO changeStatus(long orderId, String status)
        //status = "Ready"
        
        //Finish order
        //OrderDTO changeStatus(long orderId, String status)
        //status = "Finish"
    
}
