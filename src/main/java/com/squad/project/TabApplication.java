package com.squad.project;

import com.squad.project.spring.MainService;
import com.squad.project.spring.Repositories.OrderRepository;
import com.squad.project.spring.Repositories.PizzaRepository;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import net.rgielen.fxweaver.core.FxWeaver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Objects;

@SpringBootApplication
@ComponentScan("com.squad.project.spring")
@ComponentScan("com.squad.project.view")
public class TabApplication extends Application{
    private ConfigurableApplicationContext applicationContext;
    private Parent rootNode;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(rootNode);
        primaryStage.setTitle("Welcome to SunDevil Pizza");
        primaryStage.setHeight(1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        applicationContext = SpringApplication.run(TabApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/squad/project/TabView.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        rootNode = fxmlLoader.load();
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return (Stage) getSource();
        }
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
