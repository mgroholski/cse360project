package com.squad.project.view.opLoginPage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OPLoginPageController {
    @FXML TextField opLogin;
    @FXML Label loginPrompt;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent event) throws IOException {
		
		String username = opLogin.getText();

        //TODO create orderProcessor database with login as all team members with Firstname123
        //TODO make isValidID function to check if login ID matches IDs in database
		//Boolean valid = opLogin.isValidOPID();
        Boolean valid = false;
        if (valid == true) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderProcessorTab.fxml"));	
		    root = loader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		    scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
        }
        else {
            loginPrompt.setText("Incorrect, try again!");
        }
    }
}
