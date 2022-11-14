package com.squad.project;

import com.squad.project.spring.DTO.OrderDTO;
import com.squad.project.spring.DTO.StudentDTO;
import com.squad.project.spring.Enum.UserRole;
import com.squad.project.spring.MainService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
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


    private MainService mainService;

    private ConfigurableApplicationContext applicationContext;

    @Autowired
    public TabViewController(MainService mainService, ConfigurableApplicationContext applicationContext) {
        this.mainService = mainService;
        this.applicationContext = applicationContext;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Creates chef
        StudentDTO chef = new StudentDTO();
        chef.setId((long) 1219178441);
        chef.setUserRole(UserRole.Chef);
        mainService.createStudent(chef);
        loadStudentTab();
    }

    public void loadStudentTab() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/StudentTab.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            AnchorPane pane = fxmlLoader.load();
            studentTab.setContent(pane);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPizzaChefTab() throws InterruptedException {
        if(pizzaChefTab.isSelected()) {
            boolean value = this.login();
            if (!value)
                return;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/PizzaChefTab.fxml"));
                fxmlLoader.setControllerFactory(applicationContext::getBean);
                AnchorPane pane = fxmlLoader.load();
                pizzaChefTab.setContent(pane);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadOrderProcessorTab() throws InterruptedException {
        if (orderProcessorTab.isSelected()) {
            System.out.println("Here2");
            boolean value = this.login();
            if (!value)
                return;

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/OrderProcessorTab.fxml"));
                fxmlLoader.setControllerFactory(applicationContext::getBean);
                AnchorPane pane = fxmlLoader.load();
                orderProcessorTab.setContent(pane);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadOrderStatusTab() {
        if (orderStatusTab.isSelected()) {
            System.out.println("Here3");
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

    private Boolean login() throws InterruptedException {
        while (true) {
            TextInputDialog inputId = new TextInputDialog("Enter student ID");
            inputId.setContentText("ID: ");
            inputId.setHeaderText("Input ID here");

            inputId.showAndWait();
            String inp = inputId.getEditor().getText();
            if(inp.length() != 10) {
                inputId.setContentText("Invalid ID, must be 10 digits long and be a number.");
                wait(100);
                continue;
            }

            Long id = Long.parseLong(inp);
            StudentDTO student = new StudentDTO(id);
            student = mainService.login(student);
            if (student != null && student.getUserRole() == UserRole.Chef) {
                return true;
            }
        }
    }
}
