package com.squad.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TabApplication extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("TabView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Welcome to SunDevil Pizza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
