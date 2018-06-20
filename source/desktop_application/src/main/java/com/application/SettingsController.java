package com.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDef;

    @FXML
    private Button btnSave;

    @FXML
    private TextField OFFSET_TIME;
    
    @FXML
    private TextField FALL_ANGLE;

    @FXML
    private TextField IMPACT_PASS;

    @FXML
    private TextField IMPACT_POW;

    @FXML
    private TextField LAYING_POW;

    @FXML
    private TextField SKIP_MEASUR;


    @FXML
    void CancelSettings(ActionEvent event) {
    }

    @FXML
    void SaveSettings(ActionEvent event) {
    }

    @FXML
    void SetDefault(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'settings.fxml'.";
        assert btnDef != null : "fx:id=\"btnDef\" was not injected: check your FXML file 'settings.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'settings.fxml'.";


    }

	
}
