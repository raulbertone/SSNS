package com.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConnect;

    @FXML
    private Label lblConnecting;
    
    @FXML
    void Connect(ActionEvent event) {
    	
    
    	if(this.lblConnecting.isVisible())
    	{
    		this.lblConnecting.setText("Connected");
        	
    	}
    	else
    	{
    		this.lblConnecting.setVisible(true);
    	}
  		
    	
    }

    @FXML
    void initialize() {
        assert btnConnect != null : "fx:id=\"btnConnect\" was not injected: check your FXML file 'main.fxml'.";
        this.lblConnecting.setVisible(false);
        
    }
}
