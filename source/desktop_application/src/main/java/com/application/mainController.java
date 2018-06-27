package com.application;

import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.application.bluetooth.ProcessMessage;
import com.application.bluetooth.Server;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class mainController implements Initializable {  

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    static NumberAxis accel_accel;
    
    @FXML
    static CategoryAxis accel_time;
    
    @FXML
    static LineChart<Number, String> Accelerometer;

    @FXML
    static CategoryAxis gyro_time;
    
    @FXML
    static NumberAxis gyro_accel;
    
    @FXML
    static LineChart<Number, String> Gyroscope;

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
    
    //dataChart variables
    static int xSeriesData = 0;
    
    static XYChart.Series<Number, String> accel1_series = new XYChart.Series<>();
    
    static XYChart.Series<Number, String> accel2_series = new XYChart.Series<>();
    
    
    static XYChart.Series<Number, String> gyro1_series = new XYChart.Series<>();
    
    
    static XYChart.Series<Number, String> gyro2_series = new XYChart.Series<>();
    
    static ConcurrentLinkedQueue<Number> Q1 = new ConcurrentLinkedQueue<>();    
    static ConcurrentLinkedQueue<Number> Q2 = new ConcurrentLinkedQueue<>();    
    static ConcurrentLinkedQueue<Number> Q3 = new ConcurrentLinkedQueue<>();    
    static ConcurrentLinkedQueue<Number> Q4 = new ConcurrentLinkedQueue<>();
    
    
    static void setVars() {
	
	accel_accel = new NumberAxis(0, 100, 10);
    accel_time = new CategoryAxis();
    
    gyro_accel = new NumberAxis(0, 100, 10);
    gyro_time = new CategoryAxis();
    
    accel1_series.setName("Accel1");
    accel2_series.setName("Accel2");
    gyro1_series.setName("Accel1");
    gyro2_series.setName("Accel1");
    
    Accelerometer = new LineChart<Number, String>(accel_accel, accel_time) {
        // Override to remove symbols on each data point
        @Override
        protected void dataItemAdded(Series<Number, String> series, int itemIndex, Data<Number, String> item) {
        }
    };

    Gyroscope = new LineChart<Number, String>(gyro_accel, gyro_time) {
        // Override to remove symbols on each data point
        @Override
        protected void dataItemAdded(Series<Number, String> series, int itemIndex, Data<Number, String> item) {
        }
    };
    
    Accelerometer.getData().addAll(accel1_series,accel2_series);
    Gyroscope.getData().addAll(gyro1_series,gyro2_series);
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
    	prepareTimeline();
    }

    @FXML
    void StopReceiving(ActionEvent event) {
    	
    }
       
    @FXML
    void Userinfo(ActionEvent event) throws Exception {
    	//MainAppliction file = new MainAppliction();
    	main.UserInfo();
    }
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        
        setVars();
        prepareTimeline();
       
    }
    
    //Timeline gets called in the JavaFX Main thread
    void prepareTimeline() {
        // Every frame to take any data from queue and add to chart
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                addData();
            }
        }.start();
    }
    
    //use given data to populate the charts
    private void addData() {
    	for (int i = 0; i < 20; i++) { //-- add 20 numbers to the plot+
            if (Q1.isEmpty()) break;
    		accel1_series.getData().add(new XYChart.Data<>(Q1.remove(), ""+ xSeriesData++));
            accel2_series.getData().add(new XYChart.Data<>(Q2.remove(), ""+ xSeriesData++));
            gyro1_series.getData().add(new XYChart.Data<>(Q3.remove(), ""+ xSeriesData++));
            gyro2_series.getData().add(new XYChart.Data<>(Q4.remove(), ""+ xSeriesData++));
        }
    	
    	if (accel1_series.getData().size() > 100) {
            accel1_series.getData().remove(0, accel1_series.getData().size() - 100);
        }
        if (accel2_series.getData().size() > 100) {
            accel2_series.getData().remove(0, accel2_series.getData().size() - 100);
        }
        if (gyro1_series.getData().size() > 100) {
            gyro1_series.getData().remove(0, gyro1_series.getData().size() - 100);
        }
        
        if (gyro2_series.getData().size() > 100) {
            gyro2_series.getData().remove(0, gyro2_series.getData().size() - 100);
        }
        
        // update
        accel_accel.setLowerBound(xSeriesData - 100);
        accel_accel.setUpperBound(xSeriesData - 1);
        gyro_accel.setLowerBound(xSeriesData - 100);
        gyro_accel.setUpperBound(xSeriesData - 1);
    }
}
