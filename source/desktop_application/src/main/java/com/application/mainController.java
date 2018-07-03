package com.application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.application.bluetooth.Application;
import com.application.bluetooth.DbSave;
import com.application.bluetooth.ProcessMessage;
import com.application.bluetooth.Sensor;
import com.application.bluetooth.Server;
import com.application.bluetooth.Utils;
import com.application.util.FallNotificationService;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class mainController {

	//region
/**
 * @author Elis
 * 
 * Some counters for the series update and graph update
 * 
 * */
	int Accel1SerieCnt=0;
	//endregion
	Server sr = Server.getInstance();
	
	public static StringProperty Scan = new SimpleStringProperty(null);
	public static StringProperty status = new SimpleStringProperty(Server.STATUS);
	
	private XYChart.Series<Number, Number> Accel1Serie = new XYChart.Series<>(); 
	private XYChart.Series<Number, Number> Accel2Serie = new XYChart.Series<>(); 
	NumberAxis xAxis = new NumberAxis(0, 50, 1);
	NumberAxis yAxis = new NumberAxis(0,5,0.1);
	
    
	
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
    static NumberAxis accel_accel;
    
    @FXML
    static CategoryAxis accel_time;

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
    
    @FXML
    private Button btnScan;
    
    @FXML
    private ChoiceBox<String> ddlAvSensors;
    
    @FXML
    private AnchorPane idGraphAccl;
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
    	
    	String dev = this.ddlAvSensors.getValue();   	
    	sr.connectTo(Utils.reverseHexString(dev), this);
    	
    }
    
    @FXML
    void Disconnect(ActionEvent event) {
    	sr.WriteToPort("01030C00");
    	//sr.AutoDiscover();
    	//new Application();
    
    }
  
    
    @FXML
    void Clean(ActionEvent event) {
    	 //sr.WriteToPort("01030C00");
     //   new DbSave();
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
    	sr.readData();
    	
    	// new Application();
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
          	Scan.setValue(null);
          	sr.Scan(this);
    
    }
    
    
    /**End of Actions of main View Buttons */
    
    @FXML
    void initialize() {
    	
    	 initializeGraph(idGraphAccl,Accel1Serie,Accel2Serie);
    	 prepareTimeline();
    	// set a reference to this controller so that the FallNotificationService can change the colour of labels
    	FallNotificationService.setMain(this);
		sr.DevInit(this);
				
		this.ddlAvSensors.getItems().add("Select a Sensor");
		this.ddlAvSensors.getSelectionModel().selectFirst();
//		this.ddlAvSensors.getSelectionModel().select(1);
		this.lblConnecting.textProperty().bind(status);
        this.btnConnect.disableProperty().bind(BooleanExpression.booleanExpression(Scan.isEmpty()));
        this.btnDisconnect.disableProperty().bind(BooleanExpression.booleanExpression(Scan.isEmpty()));
		//this.btnConnect.disableProperty().bind(observable);
        assert btnConnect != null : "fx:id=\"btnConnect\" was not injected: check your FXML file 'main.fxml'.";       
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
	 *         TODO: Please Use this section t add other functions that you will
	 *         need for help
	 * 
	 *         Apply Rule1
	 * 
	 */

	public void addAccqDataToSerie() {
		for (int i = 0; i < 20; i++) { // -- add 20 numbers to the plot+
			if (!Server.absAcc1Queue.isEmpty() || !Server.absAcc2Queue.isEmpty()) {
				int tmp = Accel1SerieCnt++;
				if (!Server.absAcc1Queue.isEmpty()) {
					Accel1Serie.getData().add(new XYChart.Data<>(tmp, Server.absAcc1Queue.remove()));
				} else {
					Accel1Serie.getData().add(new XYChart.Data<>(tmp, 0));
				}
				if (!Server.absAcc2Queue.isEmpty()) {
					Accel2Serie.getData().add(new XYChart.Data<>(tmp, Server.absAcc2Queue.remove()));
				} else {
					Accel2Serie.getData().add(new XYChart.Data<>(tmp, 0));
				}
			} else {
				break;
			}

		}

		if (Accel1Serie.getData().size() > 50) {
			Accel1Serie.getData().remove(0, Accel1Serie.getData().size() - 50);
		}
		if (Accel2Serie.getData().size() > 50) {
			Accel2Serie.getData().remove(0, Accel2Serie.getData().size() - 50);
		}
		if (Accel1SerieCnt > 50) {
			xAxis.setLowerBound(Accel1SerieCnt - 50);
		} else {
			xAxis.setLowerBound(0);
		}
		if (Accel1SerieCnt != 0) {
			xAxis.setUpperBound(Accel1SerieCnt - 1);
		} else {
			xAxis.setUpperBound(0);
		}
	}
    
    
//    private void addDataToSeries() {
//        for (int i = 0; i < 3; i++) { //-- add 20 numbers to the plot+
//            if (blood.getBloodQue().isEmpty()) 
//            break;
//            
//            series1.getData().add(new XYChart.Data<>(xSeriesData++, blood.removeHead()));    
//        }
//       
//        if (series1.getData().size() > 300) {
//            series1.getData().remove(0, series1.getData().size() - 300);
//        }
//        
//        // update
//        if(xSeriesData>100)
//        {
//        	xAxis.setLowerBound(xSeriesData-100);
//        }
//        else
//        {
//        	xAxis.setLowerBound(0);
//        }
//       
//        xAxis.setUpperBound(xSeriesData - 1);
//    }
//    
    
    
    private void prepareTimeline() {
        // Every frame to take any data from queue and add to chart
        new AnimationTimer() {
            @Override
            public void handle(long now) {
            	addAccqDataToSerie();
            }
        }.start();
    }
    
    private void initializeGraph(AnchorPane graphAnchorPane, XYChart.Series<Number, Number> Accel1Series,  XYChart.Series<Number, Number> Accel2Series) {
    	
    	xAxis.setLabel("time in minutes");
        yAxis.setLabel("Acceleration");
         
         final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis) {
             // Override to remove symbols on each data point
             @Override
             protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {
             }
         };
        
         lineChart.setAnimated(true);
         lineChart.setTitle("Acceleromtere");
         lineChart.setHorizontalGridLinesVisible(true);
         lineChart.setVerticalGridLinesVisible(false);
    	
         Accel1Series.setName("Accelerometer1");
         lineChart.getData().addAll(Accel1Series);
         Accel2Series.setName("Accelerometer2");
         lineChart.getData().addAll(Accel2Serie);
         
         graphAnchorPane.getChildren().add(lineChart);
    }
    
    
    public Button getbtnConnect()
    {
    	return this.btnConnect;
    }
    public Button getbtnDisconnect()
    {
    	return this.btnDisconnect;
    }

    public void showSensorsFound()
    {
    	this.ddlAvSensors.getItems().addAll(sr.devicesFound);
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
