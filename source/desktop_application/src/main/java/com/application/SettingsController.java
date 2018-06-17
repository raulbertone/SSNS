package com.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


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
