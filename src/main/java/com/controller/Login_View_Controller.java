package com.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Login_View_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    @FXML
    private Button login_Button;

    @FXML
    private Button quit_Button;

    @FXML
    void lgoin(ActionEvent event) {

    }

    @FXML
    void login(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.headerTextProperty().set("aaaa");
            alert.showAndWait();
        }
    }

    @FXML
    void quit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert login_Button != null : "fx:id=\"login_Button\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert quit_Button != null : "fx:id=\"quit_Button\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";

    }
}
