package com.squad.project;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import com.squad.project.view.orderProcessorTab.OrderProcessorTabController;
import com.squad.project.view.orderStatusTab.OrderStatusTabController;
import com.squad.project.view.pizzaChefTab.PizzaChefTabController;
import com.squad.project.view.studentTab.StudentTabController;

public class TabViewController {
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab studentTab;

    @FXML
    private Tab orderStatusTab;

    @FXML
    private Tab orderProcessorTab;

    @FXML
    private Tab pizzaChefTab;

    @FXML
    private StudentTabController studentTabController;

    @FXML
    private OrderStatusTabController orderStatusTabController;

    @FXML
    private OrderProcessorTabController orderProcessorTabController;

    @FXML
    private PizzaChefTabController pizzaChefTabController;

    public void init() {
        StudentTabController.init();
        OrderStatusController.init();
        OrderProcessorTabController.init();
        PizzaChefTabController.init();
    }
}
