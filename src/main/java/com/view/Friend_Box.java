package com.view;

import com.entity.Friend;
import com.globalDatas.Global_Datas;
import com.utils.Base64Util;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * 好友边栏中 一位好友
 *
 * @author Qi
 * @Date 2021/5/3 9:07 下午
 */

public class Friend_Box {
    //本Box的好友
//    private Friend friend;
//
//    public Friend_Box(Friend friend) {
//        this.friend = friend;
//    }
//
//    public Friend getFriend() {
//        return friend;
//    }
//
//    public void setFriend(Friend friend) {
//        this.friend = friend;
//    }

    public static HBox createFriendHBox(Friend friend) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPickOnBounds(true);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPrefHeight(49.05);
        hBox.setPrefWidth(198);
        hBox.setStyle("-fx-background-color: gray; -fx-background-radius: 5;");
        hBox.setPadding(new Insets(10, 10, 10, 10));

        ImageView avatar = new ImageView();
        avatar.setFitHeight(40);
        avatar.setFitWidth(40);
        avatar.setPickOnBounds(true);
        avatar.setPreserveRatio(true);//设置保存缩放比例
        avatar.setSmooth(true);            //设置平滑显示图像
        avatar.setCache(true);             //设置缓冲以提高性能
        Image avatarImage = friend.isAvatar() ? new Image("http://resources.jian-internet.com:50000/images/" + Base64Util.encode(friend.getUserName()) + ".png") : new Image("file:src/main/resources/images/avatar.png");
        avatar.setImage(avatarImage);

        Label name = new Label();
        name.setPrefHeight(23);
        name.setPrefWidth(135);
        name.setText(friend.getUserName());
        name.setTextFill(Color.web("#e2e2e2"));
        name.setFont(Font.font(null, FontWeight.BOLD, 17));

        hBox.getChildren().addAll(avatar, name);
        hBox.setOnMouseClicked(
                mouseEvent -> {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        Global_Datas.setFriend(friend);
                        System.out.println("点击了 : \n\t" + friend.toString());
//                        Global_Datas.vBox.setPrefHeight(Global_Datas.vBox.getPrefHeight()+Global_Datas.hBox.getHeight()+10);
//                        Global_Datas.vBox.setPrefWidth(983);
//                        Global_Datas.hBox.setVisible(true);
//                        System.out.println("高度 : "+ Global_Datas.hBox.getHeight());
                        Global_Datas.chatScrollPane.setVvalue(1);
                        VBox x = (VBox)Global_Datas.chatScrollPane.getContent();
                        System.out.println( x.getHeight() );
                    }
                }
        );
        return hBox;
    }

    public static VBox createFriendVBox() {
        VBox vBox = new VBox();
        vBox.setPrefHeight(668);
        vBox.setPrefWidth(198);
        vBox.setSpacing(2);
        vBox.setStyle("-fx-background-color: rgb(0,0,0,255);");
//        vBox.setBackground(null);
        vBox.setPadding(new Insets(1));
        return vBox;
    }
}
