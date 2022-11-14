package com.squad.project;

import com.squad.project.spring.DTO.OrderDTO;
import com.squad.project.spring.MainService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import com.squad.project.view.orderProcessorTab.OrderProcessorTabController;
import com.squad.project.view.orderStatusTab.OrderStatusTabController;
import com.squad.project.view.pizzaChefTab.PizzaChefTabController;
import com.squad.project.view.studentTab.StudentTabController;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TabViewController implements Initializable {
    @FXML TabPane tabPane;
    @FXML Tab studentTab;
    @FXML Tab orderStatusTab;
    @FXML Tab orderProcessorTab;
    @FXML Tab pizzaChefTab;
    @FXML StudentTabController studentTabController;
    @FXML OrderStatusTabController orderStatusTabController;
    @FXML OrderProcessorTabController orderProcessorTabController;
    @FXML PizzaChefTabController pizzaChefTabController;

    private MainService mainService;

    private ConfigurableApplicationContext applicationContext;

    @Autowired
    public TabViewController(MainService mainService, ConfigurableApplicationContext applicationContext) {
        this.mainService = mainService;
        this.applicationContext = applicationContext;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadStudentTab();
    }

    public void loadStudentTab() {
        System.out.println("studentT");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/StudentTab.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            AnchorPane pane = fxmlLoader.load();
            studentTab.setContent(pane);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPizzaChefTab() {
        System.out.println("pizzaC");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/PizzaChefTab.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            AnchorPane pane = fxmlLoader.load();
            pizzaChefTab.setContent(pane);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadOrderProcessorTab() {
        System.out.println("orderP");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/OrderProcessorTab.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            AnchorPane pane = fxmlLoader.load();
            orderProcessorTab.setContent(pane);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadOrderStatusTab() {
        System.out.println("orderS");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/OrderStatusTab.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            AnchorPane pane = fxmlLoader.load();
            orderStatusTab.setContent(pane);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
