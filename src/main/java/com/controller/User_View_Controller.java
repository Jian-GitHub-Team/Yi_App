package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.globalDatas.Global_Datas;
import com.threads.User_ScheduledService;
import com.utils.Friend_HBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class User_View_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane friends_ScrollPane;

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
    private VBox friendVBox;//13个height: 49.1 | width: 198 height: 668 | width: 183

    @FXML
    private BorderPane leftBorderPane;

    @FXML
    private ImageView backgroundImageView;

    @FXML
    void clickAddFriend(MouseEvent event) {

    }

    @FXML
    void clickUserAvatar(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {

        }
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

        userName.setText(Global_Datas.getUser().getUserName());

        User_ScheduledService user_scheduledService = new User_ScheduledService(this);
        user_scheduledService.start();
        user_scheduledService.setPeriod(Duration.millis(50));

        String fxml = "fxmls/Friend_View_FXML.fxml";
        URL url = getClass().getClassLoader().getResource(fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        for (int i = 0; i < 15; i++) {
//                HBox v = fxmlLoader.load();
//                Friend_View_Controller friend_view_controller = fxmlLoader.getController();
//                friend_view_controller.set("我好友"+i, new Image("file:src/main/resources/images/user_avatar.png"));
            System.out.println(i);
            friendVBox.getChildren().add(Friend_HBox.createFriendHBox());
            if (i >= 13) {
                friendVBox.setPrefHeight(friendVBox.getPrefHeight() + 49.05);
                friendVBox.setPrefWidth(183);
            }
        }
        friends_ScrollPane.setVvalue(0.5);
//        updateUserMsg();
    }

    //    public void test(){
//        Global_Datas.setUser_thread(new Thread(new User_Thread(this)));
//        Global_Datas.getUser_thread().start();
//    }
    public Label getUserName() {
        return userName;
    }

    public void setUserNameText(String text) {
        userName.setText(text);
    }

    public ImageView getUserAvatar() {
        return userAvatar;
    }
//    public void updateUserMsg() {
//        System.out.println("运行");
//        // set userName
//        userName.setText(Global_Datas.getUser().getUserName());
//        // set avatar
//        try {
//            Image image = Global_Datas.getUser().isAvatar() ?
//                    Image_Util.crop(
//                            new Image(
//                                    "http://resources.jian-internet.com:50000/images/"+
//                                        Base64Util.encode(Global_Datas.getUser().getUserName()) +
//                                        ".png"
//                            )
//                    )
//                    :
//                    new Image("file:src/main/resources/images/avatar.png");
//            userAvatar.setImage(image);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

}
