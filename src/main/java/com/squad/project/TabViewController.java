package com.squad.project;

import com.squad.project.spring.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.squad.project.view.orderProcessorTab.OrderProcessorTabController;
import com.squad.project.view.orderStatusTab.OrderStatusTabController;
import com.squad.project.view.pizzaChefTab.PizzaChefTabController;
import com.squad.project.view.studentTab.StudentTabController;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@FxmlView("TabView.fxml")
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

    @Autowired
    public TabViewController(MainService mainService) {
        this.mainService = mainService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane studentPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/squad/project/StudentTab.fxml")));
            studentTab.setContent(studentPane);
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("File not found");
        }

        loader = new FXMLLoader();
        try {
            AnchorPane orderStatusPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/squad/project/StudentTab.fxml")));
            orderStatusTab.setContent(orderStatusPane);
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("File not found");
        }

        loader = new FXMLLoader();
        try {
            AnchorPane orderProcessorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/squad/project/StudentTab.fxml")));
            orderProcessorTab.setContent(orderProcessorPane);
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("File not found");
        }

        loader = new FXMLLoader();
        try {
            AnchorPane pizzaChefPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/squad/project/StudentTab.fxml")));
            pizzaChefTab.setContent(pizzaChefPane);
        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("File not found");
        }
    }
}
