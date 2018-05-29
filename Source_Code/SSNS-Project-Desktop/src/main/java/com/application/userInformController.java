package com.application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class userInformController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;


    @FXML
    void SaveUserInfo(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'userinfo.fxml'.";


    }

}


