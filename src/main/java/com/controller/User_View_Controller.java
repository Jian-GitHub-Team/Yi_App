package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.entity.ChatContent;
import com.globalDatas.Global_Datas;
import com.threads.Friend_ScheduledService;
import com.threads.User_ScheduledService;
import com.utils.Base64Util;
import com.view.Chat_Content_Box;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class User_View_Controller {


    private ImageView backgroundImageView;
    @FXML
    private BorderPane basePane;

    @FXML
    private Label userName;

    @FXML
    private ImageView userAvatar;

    @FXML
    private BorderPane leftBorderPane;

    @FXML
    private ImageView addFriend;

    @FXML
    private ScrollPane friends_ScrollPane;

    @FXML
    private VBox friendVBox;

    @FXML
    private BorderPane rightBorderPane;

    @FXML
    private BorderPane chatBorderPane;

    @FXML
    private TextArea chatTextArea;

    @FXML
    private ScrollPane chatScrollPane;

    @FXML
    private VBox chatVBox;

    @FXML
    private Label chatFriend;

    @FXML
    private ImageView friendState;

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
        assert leftBorderPane != null : "fx:id=\"leftBorderPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert addFriend != null : "fx:id=\"addFriend\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert friends_ScrollPane != null : "fx:id=\"friends_ScrollPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert friendVBox != null : "fx:id=\"friendVBox\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert rightBorderPane != null : "fx:id=\"rightBorderPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert chatBorderPane != null : "fx:id=\"chatBorderPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert chatTextArea != null : "fx:id=\"chatTextArea\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert chatScrollPane != null : "fx:id=\"chatScrollPane\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert chatVBox != null : "fx:id=\"chatVBox\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert chatFriend != null : "fx:id=\"chatFriend\" was not injected: check your FXML file 'User_View_FXML.fxml'.";
        assert friendState != null : "fx:id=\"friendState\" was not injected: check your FXML file 'User_View_FXML.fxml'.";


//        Button button = new Button("2333");
//        friendVBox.getChildren().size();
//        friendVBox.getChildren().add(button);
//        friendVBox.getChildren().remove(button);

        Image backgroundImage = new Image("file:src/main/resources/images/伊沟通85_Chat.png");
        backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);
//        rightBorderPane.setCenter(backgroundImageView);
//        rightBorderPane.setCenter(chatBorderPane);

        //498

        Global_Datas.chatScrollPane = chatScrollPane;


        ChatContent chatContent = new ChatContent();
        chatContent.setUserID(1);
        chatContent.setFriendID(2);
        chatContent.setContent("Testd好sjgksghlduhsfjdsjfsdf多万杜鹃花科风扇发动机可还是恐惧的粉红色千瓦时大");
//        chatVBox.getChildren().add(Chat_Content_Box.createHBox(chatContent));
//        chatVBox.getChildren().add(Chat_Content_Box.createHBox(chatContent));
//        chatVBox.getChildren().add(Chat_Content_Box.createHBox(chatContent));
//        chatVBox.getChildren().add(Chat_Content_Box.createHBox(chatContent));
//        chatVBox.getChildren().add(Chat_Content_Box.createHBox(chatContent));
        chatContent.setContent("Testd好sjgksghlduhsfjdsjfsdf多万杜鹃花科风扇发动机可还是恐惧的粉红色千瓦时大Testd好sjgksghlduhsfjdsjfsdf多万杜鹃花科风扇发动机可还是恐惧的粉红色千瓦时大");
        chatContent.setUserID(2);
//        Global_Datas.sethBox(Chat_Content_Box.createHBox(chatContent));
        final double[] sum = {0};
        sum[0] = -488;
        for (int kk = 0 ; kk < 4 ; kk++){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    HBox hBox = Chat_Content_Box.createHBox(chatContent);
                    chatVBox.getChildren().add(hBox);
                    hBox.setMinHeight(hBox.getBoundsInParent().getHeight());
                    hBox.autosize();
                    hBox.setMinHeight(hBox.getBoundsInParent().getHeight());
                    System.out.println("HBOX : min-"+hBox.getMinHeight());
                    System.out.println("HBOX : "+hBox.getBoundsInParent().getHeight());
                    chatVBox.layout();
                    sum[0] += hBox.getBoundsInParent().getHeight() + 10;
                    if (sum[0] >= 0){
                        System.out.println("sum : " + sum[0] );
                        System.out.println("old Height : " + chatVBox.getHeight() );
                        chatVBox.setPrefHeight(chatVBox.getHeight() + sum[0] + 10);
                        System.out.println("\nVBOX : "+ chatVBox.getHeight());
                    }
                    chatScrollPane.layout();
                    System.out.println(chatScrollPane.getVvalue());
                    chatScrollPane.setVvalue(1);
                }

            });
        }
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                HBox hBox = Chat_Content_Box.createHBox(chatContent);
//                chatVBox.getChildren().add(hBox);
//                hBox.autosize();
//                hBox.setMinHeight(hBox.getBoundsInParent().getHeight());
//                System.out.println("HBOX : min-"+hBox.getMinHeight());
//                System.out.println("HBOX : "+hBox.getBoundsInParent().getHeight());
////                System.out.println("高度 ： " + Global_Datas.hBox.getHeight());
//                sum[0] += hBox.getHeight();
//                if (sum[0] > 498) {
//                    chatVBox.setPrefHeight(chatVBox.getPrefHeight() + sum[0]-488);
//                }
//                chatScrollPane.setVvalue(1);
//            }
//
//        });
        Global_Datas.vBox = chatVBox;
        chatScrollPane.setVvalue(1);
//        Global_Datas.hBox.setVisible(false);
//        for(int i = 0 ; i < 6 ; i++) {
//        chatVBox.getChildren().add(Global_Datas.hBox);

//            chatVBox.getChildren().add(Global_Datas.hBox);
//        chatVBox.applyCss();
//        chatVBox.layout();
//        System.out.println("高度 ： "+Global_Datas.hBox.getHeight());
//            chatVBox.getChildren().add(Chat_Content_Box.createHBox(chatContent));
//            chatVBox.autosize();
//        }
//        Global_Datas.hBox = Chat_Content_Box.createHBox(chatContent);
//        Global_Datas.hBox.setVisible(false);
//        chatVBox.getChildren().add(Global_Datas.hBox);


        String name = Global_Datas.getUser().getUserName();
        userName.setText(name);
        if (Global_Datas.getUser().isAvatar()) {
            userAvatar.setImage(new Image("http://resources.jian-internet.com:50000/images/" + Base64Util.encode(name) + ".png"));
        }

        //开始刷新界面右上角用户相关信息
        User_ScheduledService user_scheduledService = new User_ScheduledService(this);
        user_scheduledService.start();
        user_scheduledService.setPeriod(Duration.millis(50));

        user_scheduledService.valueProperty().addListener(
                (observableValue, oldName, newName) -> {
                    if (newName != null) {
                        userName.setText(newName);
                    }
                }
        );

        //好友边栏
        Friend_ScheduledService friend_scheduledService = new Friend_ScheduledService(this);
        friend_scheduledService.start();
        friend_scheduledService.setPeriod(Duration.millis(50));
        friend_scheduledService.valueProperty().addListener(new ChangeListener<VBox>() {
            @Override
            public void changed(ObservableValue<? extends VBox> observableValue, VBox oldVBox, VBox newVBox) {
                if (newVBox != null) {
                    friendVBox = newVBox;
                    friends_ScrollPane.setContent(newVBox);
                }
            }
        });

    }

    public Label getUserName() {
        return userName;
    }

    public void setUserNameText(String text) {
        userName.setText(text);
    }

    public ImageView getUserAvatar() {
        return userAvatar;
    }

    public VBox getFriendVBox() {
        return friendVBox;
    }

}
