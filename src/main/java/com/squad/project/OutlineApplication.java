package com.squad.project;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class OutlineApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TilePane r = new TilePane();

        //Top Section
        VBox window = new VBox();

        //Header
        HBox titleBox = new HBox();
        titleBox.setId("titleBox");
        Label title = new Label("Welcome to SunDevil Pizza");
        title.setStyle("-fx-font-size: 35px");
        titleBox.getChildren().add(title);
        titleBox.setStyle("-fx-background-color: white; -fx-alignment: center;");
        titleBox.setPrefWidth(800);
        window.getChildren().add(titleBox);

        //Tab Box
        HBox tabBox = new HBox();
        tabBox.setStyle("-fx-background-color: gray;");
        tabBox.setPrefWidth(800);

        HBox tabGroup = new HBox();
        tabBox.setId("tabBox");
        Button student = new Button("Student");
        Button orderStatus = new Button("Order Status");
        Button orderProcessor = new Button("Order Processor");
        Button pizzaChef = new Button("Pizza Chef");

        tabGroup.setStyle("-fx-padding: 1px 0 0 10px");

        tabGroup.getChildren().add(student);
        tabGroup.getChildren().add(orderStatus);
        tabGroup.getChildren().add(orderProcessor);
        tabGroup.getChildren().add(pizzaChef);
        tabBox.getChildren().add(tabGroup);

        for (Node n: tabGroup.getChildren()) {
            if (n instanceof Button) {
                final String inactiveStyle = "-fx-background-color: #dbdbdb; -fx-border-color: black; -fx-border-radius: 3";
                n.setStyle(inactiveStyle);
            }
        }
        window.getChildren().add(tabBox);
        r.getChildren().add(window);

        //TODO: Implement middle sections
        HBox body = new HBox();
        Label sectionTitle = new Label("");
        sectionTitle.setStyle("-fx-font-size: 50px");
        body.setStyle("-fx-alignment: center");
        body.getChildren().add(sectionTitle);
        window.getChildren().add(body);

        //Button actions
        student.setOnAction(actionEvent -> {
            setActive(student, tabGroup);
            sectionTitle.setText("Student Section");
        });
        orderStatus.setOnAction(actionEvent -> {
            setActive(orderStatus, tabGroup);
            sectionTitle.setText("Order Status Section");
        });
        orderProcessor.setOnAction(actionEvent -> {
            setActive(orderProcessor, tabGroup);
            sectionTitle.setText("Order Processor Section");
        });
        pizzaChef.setOnAction(actionEvent -> {
            setActive(pizzaChef, tabGroup);
            sectionTitle.setText("Pizza Chef Section");
        });

        Scene sc = new Scene(r);
        stage.setHeight(450);
        stage.setWidth(800);
        stage.setScene(sc);
        stage.show();
    }

    private static void setActive(Button b, HBox h) {
        final String activeStyle = "-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 3";
        final String inactiveStyle = "-fx-background-color: #dbdbdb; -fx-border-color: black; -fx-border-radius: 3";

        for (Node n: h.getChildren()) {
            if (n instanceof Button) {
                n.setStyle(inactiveStyle);
            }
        }

        b.setStyle(activeStyle);
    }

    public static void main(String[] args) {
        launch();
    }
}
