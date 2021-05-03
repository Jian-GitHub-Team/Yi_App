package com.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class Friend_View_Controller {

//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private HBox friendHBox;

    @FXML
    private ImageView avatarImageView;

    @FXML
    private Label nameLabel;

    @FXML
    void chooseFriend(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert friendHBox != null : "fx:id=\"friendHBox\" was not injected: check your FXML file 'Friend_View_FXML.fxml'.";
        assert avatarImageView != null : "fx:id=\"avatarImageView\" was not injected: check your FXML file 'Friend_View_FXML.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'Friend_View_FXML.fxml'.";
    }

    /**
     * 设置好友名称与头像
     * @param name 好友名称
     * @param avatar 好友头像
     */
    public void set(String name,Image avatar){
        nameLabel.setText(name);
        avatarImageView.setImage(avatar);
    }
}
