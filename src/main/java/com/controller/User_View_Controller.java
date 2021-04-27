package com.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class User_View_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane basePane;

    @FXML
    private Label userName;

    @FXML
    private ImageView userAvatar;

    @FXML
    private BorderPane rightBorderPane;

    @FXML
    private ImageView addFriend;

    @FXML
    private VBox friendVBox;

    @FXML
    private BorderPane leftBorderPane;

    @FXML
    private ImageView backgroundImageView;

    @FXML
    void clickAddFriend(MouseEvent event) {

    }

    @FXML
    void clickUserAvatar(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert basePane != null : "fx:id=\"basePane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert rightBorderPane != null : "fx:id=\"rightBorderPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert addFriend != null : "fx:id=\"addFriend\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert friendVBox != null : "fx:id=\"friendVBox\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert leftBorderPane != null : "fx:id=\"leftBorderPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert backgroundImageView != null : "fx:id=\"backgroundImageView\" was not injected: check your FXML file 'User_View_FXML.fxml'.";

    }

}
