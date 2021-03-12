package com.controller;

import com.view.Registration_View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Login_View_Controller {

    private Registration_View registration_view = null;

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    @FXML
    private Button login_Button;

    @FXML
    private Button quit_Button;

    @FXML
    private Label registration;

    @FXML
    void lgoin(ActionEvent event) {

    }

    @FXML
    void login(KeyEvent event) {

    }

    @FXML
    void quit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void registration(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && ( registration_view == null ? true : !registration_view.isShowing() )) {
            registration_view = new Registration_View();
            registration_view.start();
        }else if (event.getButton() == MouseButton.PRIMARY && registration_view != null && registration_view.isShowing()) {
            registration_view.focus();
        }
    }

}
