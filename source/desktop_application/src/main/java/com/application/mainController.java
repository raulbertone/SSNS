package com.application;

import java.net.URL;
import java.util.ResourceBundle;

import com.application.bluetooth.ProcessMessage;
import com.application.bluetooth.Server;
import com.application.util.FallNotificationService;


import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class mainController {


	Server sr = Server.getInstance();
	
	public static StringProperty Scan = new SimpleStringProperty(null);
	public static StringProperty status = new SimpleStringProperty(Server.STATUS);
	
	//BooleanBinding b= Bindings.and(sr.SCAN_COMPLETE, sr.LUNCHPAD_READY);
			//.and(sr.SCAN_COMPLETE);
	
    /**
     * @author Elis
     * 
     *   All IDs ofr mainView elements
     * 
     * TODO: From now one all new elements that you create for mainView 
     *       please add the IDs in this section
     *       
     *       Rule 1: always add a new ID at the end
     * */
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
    
    @FXML
    private Button btnScan;
    
    /* End of IDs of mainView */
    
    /**
     * @author Elis
     * 
     * Actions of main View Buttons f
     * 
     * TODO: From now one all actions that you create for this controller
     *       please add them in this section
     *       
     *       Apply Rule 1
     * */
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
    void ScanForBluetoothDevices(ActionEvent event) {
    	Server.STATUS="Scanning...";
    	//this.btnConnect.setDisable(true);
      //this.btnDisconnect.setDisable(true);
      	Scan.setValue(null);
      	Platform.runLater(new Runnable() {    		 
		        @Override
		        public void run() {
		        	sr.Scan();
		        }
		    });
  
//      	Runnable r = new Runnable() {
//      	  @Override
//	        public void run() {
//	        	//sr.Scan();
//	          System.out.println("Helllo from runnable");  
//      	  }
//      	};
//      	
//      	r.run();
//      	new Runnable()
//      	{
//      	  @Override
//	        public void run() {
//	        	sr.Scan();
//	        }
//      	}.run();
//    	
    
    }
    
    
    /* End of Actions of main View Buttons */
    
    @FXML
    void initialize() {
    	
    	// set a reference to this controller so that the FallNotificationService can change the colour of labels
    	FallNotificationService.setMain(this);
    	
     	
    		
			sr.DevInit();
						
		this.lblConnecting.textProperty().bind(status);
        this.btnConnect.disableProperty().bind(BooleanExpression.booleanExpression(Scan.isEmpty()));
        this.btnDisconnect.disableProperty().bind(BooleanExpression.booleanExpression(Scan.isEmpty()));
		//this.btnConnect.disableProperty().bind(observable);
        assert btnConnect != null : "fx:id=\"btnConnect\" was not injected: check your FXML file 'main.fxml'.";       
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
    
    /**
     * @author Elis
     * 
     * TODO: Please Use this section t add other functions that you will need for help 
     * 
     *   Apply Rule1
     
     * */
    public Button getbtnConnect()
    {
    	return this.btnConnect;
    }
    public Button getbtnDisconnect()
    {
    	return this.btnDisconnect;
    }

    public static void StatusChanger() {

    	Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
            	
            	while(Server.LUNCHPAD_READY)
            	{
            		Thread.sleep(10);
              	  
             	   Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                        	status.setValue(String.valueOf(Server.STATUS));
                        	
                        	if(Server.SCAN_COMPLETE)
                        	{
                        		Scan.setValue("1");
                        	}
                        	
                        }
                    });
             	   
            	}
            	return null;
              
            }
         };
         Thread th = new Thread(task);
         th.setDaemon(true);
         th.start();
         
    }
    
    
    
}
