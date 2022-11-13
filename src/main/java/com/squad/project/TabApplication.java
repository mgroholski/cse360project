package com.squad.project;

import com.squad.project.spring.SpringApp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;


public class TabApplication extends Application{
    private ConfigurableApplicationContext applicationContext;
    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(primaryStage));

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/squad/project/TabView.fxml")));


        Scene scene = new Scene(root);
        primaryStage.setTitle("Welcome to SunDevil Pizza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(SpringApp.class).run();
    }

    @Override
    public void stop() {
        applicationContext.close();
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
}
