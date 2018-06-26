package com.application;

import java.net.URL;
import java.util.ResourceBundle;

import com.application.bluetooth.ProcessMessage;
import com.application.bluetooth.Server;
import com.application.util.FallNotificationService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class mainController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private LineChart<?, ?> Accelerometer;

    @FXML
    private LineChart<?, ?> Gyroscope;

    @FXML
    private Button btnClean;   
    
    @FXML
    private MenuItem btnClose;
    
    @FXML
    private Button btnConnect;

    @FXML
    private Button btnDisconnect;
    
    @FXML
    private MenuItem btnSettings;
    
    @FXML
    private Button btnStart;
    
    @FXML
    private Label btnStatus;
    
    @FXML
    private Button btnStop;

    @FXML
    private MenuItem btnUserInfo;
    
    @FXML
    private Label lblConnecting;
    
    @FXML
    private Label lblFallDet;
    
    @FXML
    private Label lblHelpReq;
    
    MainAppliction main = new MainAppliction();
    
    public void setLblHelpReqColor(String color) {
    	 lblHelpReq.setTextFill(Color.web(color));
    }
   
    public void setLblFallDetColor(String color) {
   	 	lblFallDet.setTextFill(Color.web(color));
    }
    
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
    void Disconnect(ActionEvent event) {
    }
  
    
    @FXML
    void Clean(ActionEvent event) {
    }
    
    @FXML
    void CloseApp(ActionEvent event) {
    }    
    
    @FXML
    void Settings(ActionEvent event) throws Exception {
    	
    	//MainAppliction main = new MainAppliction();
    	main.showSettings();
    }

    @FXML
    void StartReceiving(ActionEvent event) {
    }

    @FXML
    void StopReceiving(ActionEvent event) {
    }
       
    @FXML
    void Userinfo(ActionEvent event) throws Exception {
    	//MainAppliction file = new MainAppliction();
    	main.UserInfo();
    }

    @FXML
    void initialize() {
    	
    	// set a reference to this controller so that the FallNotificationService can change the colour of labels
    	FallNotificationService.setMain(this);
    	
    	Server sr = Server.getInstance();
		
		 new ProcessMessage();
		
			System.out.println("pretending server started");
			sr.DevInit();			
		
        assert btnConnect != null : "fx:id=\"btnConnect\" was not injected: check your FXML file 'main.fxml'.";
        this.lblConnecting.setVisible(false);
        assert Accelerometer != null : "fx:id=\"Accelerometer\" was not injected: check your FXML file 'main.fxml'.";
        assert Gyroscope != null : "fx:id=\"Gyroscope\" was not injected: check your FXML file 'main.fxml'.";
        assert btnClean != null : "fx:id=\"btnClean\" was not injected: check your FXML file 'main.fxml'.";
        assert btnDisconnect != null : "fx:id=\"btnDisconnect\" was not injected: check your FXML file 'main.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'main.fxml'.";
        assert btnStatus != null : "fx:id=\"btnStatus\" was not injected: check your FXML file 'main.fxml'.";
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'main.fxml'.";
        assert lblConnecting != null : "fx:id=\"lblConnecting\" was not injected: check your FXML file 'main.fxml'.";
        assert lblFallDet != null : "fx:id=\"lblFallDet\" was not injected: check your FXML file 'main.fxml'.";
        assert lblHelpReq != null : "fx:id=\"lblHelpReq\" was not injected: check your FXML file 'main.fxml'.";
 
        
    }
}
