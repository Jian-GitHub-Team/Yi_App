package com.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Registration_View_Controller {


    private Color no = Color.rgb(0,0,0,0);
    private Color error = Color.rgb(240,0,0,0.6);
    private Color right = Color.rgb(0,240,0,0.6);

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button Registration;

    @FXML
    private Button cancel;

    @FXML
    void Registration(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY){

        }
    }
    @FXML
    void Registration(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){

        }
    }

//    @FXML
//    void checkinUserName() {
//        System.out.println(userName.getText());
//        System.out.println(userName.getText().length());
//    }
//
//    @FXML
//    void checkinPassword() {
//        System.out.println(password.getText());
//        System.out.println(password.getText().length());
//    }

    @FXML
    void cancel(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            //通过stage方式操作窗口，因为一个新的窗口就是一个新的stage
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert Registration != null : "fx:id=\"Registration\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert cancel != null : "fx:id=\"cancel\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        passwordCheckIn();
        userNameCheckIn();
    }

    private void passwordCheckIn(){
        password.textProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println(password.getText());
            Border passwordBorder = null;
            if ( password == null || "".equals(password.getText()) ){
                passwordBorder = new Border(new BorderStroke(no, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            }
            else if ( password != null && !"".equals(password.getText()) && password.getText().length() > 1 && password.getText().length() <= 15 ){
                passwordBorder = new Border(new BorderStroke(right, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            }else if ( password != null && !"".equals(password.getText()) && password.getText().length() <= 1 || password.getText().length() > 15 ){
                passwordBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            }
            password.setBorder(passwordBorder);
        });
    }

    private void userNameCheckIn(){
        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(userName.getText());
            Border userNameBorder = null;
            if ( userName == null || "".equals(userName.getText()) ){
                userNameBorder = new Border(new BorderStroke(no, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            }
            else if ( userName != null && !"".equals(userName.getText()) && userName.getText().length() > 1 && userName.getText().length() <= 15 ){
                userNameBorder = new Border(new BorderStroke(right, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            }else if ( userName != null && !"".equals(userName.getText()) && userName.getText().length() <= 1 || userName.getText().length() > 15 ){
                userNameBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            }
            userName.setBorder(userNameBorder);
        });
    }
}