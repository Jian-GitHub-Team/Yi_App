package com.view;

import com.entity.ChatContent;
import com.globalDatas.Global_Datas;
import com.utils.Base64Util;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * @author Qi
 * @Date 2021/5/5 1:09 下午
 */
public class Chat_Content_Box {
    public static VBox createVBox(){

        return null;
    }
    public static HBox createHBox(ChatContent chatContent){
        TextArea textArea = new TextArea();
//        textArea.setPrefColumnCount(6);
        textArea.setMaxWidth(600);
//        textArea.setPrefHeight(43);
        textArea.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        textArea.setStyle("-fx-background-color: #FFFFFF33; -fx-background-radius: 19;");
//        textArea.setBackground(new Background(new BackgroundFill(Color.web("#a167ff"),null,null)));
        textArea.setWrapText(true);
        textArea.setText(chatContent.getContent());
        textArea.setFont(new Font(18));
        textArea.setPadding(new Insets(10,10,10,10));
        textArea.setEditable(false);
        textArea.autosize();

//        System.out.println("行数 : " + textArea.getText().split("\n").length);

        boolean isUser = chatContent.getUserID() == Global_Datas.getUser().getId();
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(20);
        hBox.setNodeOrientation(isUser ? NodeOrientation.RIGHT_TO_LEFT : NodeOrientation.LEFT_TO_RIGHT);

        //头像
        ImageView avatarImageView = new ImageView();
        avatarImageView.setFitHeight(40);
        avatarImageView.setFitWidth(40);
        avatarImageView.setPickOnBounds(true);
        avatarImageView.setPreserveRatio(true);
//        Image avatarImage = isUser ?
//                new Image(Global_Datas.getUser().isAvatar() ? "http://resources.jian-internet.com:50000/images/" + Base64Util.encode(Global_Datas.getUser().getUserName()) + ".png" : "file:src/main/resources/images/avatar.png") :
//                new Image(Global_Datas.getFriend().isAvatar() ? "http://resources.jian-internet.com:50000/images/" + Base64Util.encode(Global_Datas.getFriend().getUserName()) + ".png" : "file:src/main/resources/images/avatar.png") ;
        Image avatarImage = new Image("file:src/main/resources/images/avatar.png");
        avatarImageView.setImage(avatarImage);
        //头像效果
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(new Color(0.7828947305679321,0.7828947305679321,0.7828947305679321,1));
        dropShadow.setHeight(40);
        dropShadow.setWidth(40);
        dropShadow.setRadius(19.5);
        avatarImageView.setEffect(dropShadow);

        //聊天文本
        Label content = new Label();
        content.setMaxWidth(600);
//        content.setMinHeight(43);
        content.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        content.setStyle("-fx-background-color: #FFFFFF33; -fx-background-radius: 19;");
        content.setTextFill(Color.web("#a167ff"));
        content.setWrapText(true);
        content.setText(chatContent.getContent());
        content.setFont(new Font(18));
        content.setPadding(new Insets(10,10,10,10));
        content.setTranslateY(15);
        content.autosize();


        hBox.getChildren().addAll(avatarImageView,content);
//        hBox.getChildren().addAll(avatarImageView,textArea);
        hBox.autosize();
//        System.out.println(content.getPrefHeight()+15);
//        System.out.println(content.getMinHeight()+15);
//        System.out.println(content.getMaxHeight()+15);

        return hBox;
    }
}
