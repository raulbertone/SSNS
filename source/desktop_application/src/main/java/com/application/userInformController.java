package com.application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class userInformController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private TextField address;

    @FXML
    private TextField bloodType;

    @FXML
    private TextField dateBirth;

    @FXML
    private TextField emailPerson1;

    @FXML
    private TextField emailPerson2;

    @FXML
    private TextField firstName;

    @FXML
    private ChoiceBox<?> gender;

    @FXML
    private TextField lastName;

    @FXML
    private TextField mobNumber;

    @FXML
    private TextField namePerson1;

    @FXML
    private TextField namePerson2;
    
    @FXML
    void SaveUserInfo(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'userinfo.fxml'.";


    }

}


