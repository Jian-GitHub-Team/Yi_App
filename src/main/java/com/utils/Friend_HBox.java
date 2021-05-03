package com.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * 好友边栏中 一位好友
 *
 * @author Qi
 * @Date 2021/5/3 9:07 下午
 */

public class Friend_HBox {
    public static HBox createFriendHBox() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPickOnBounds(true);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPrefHeight(49.05);
        hBox.setPrefWidth(198);
        hBox.setStyle("-fx-background-color: gray; -fx-background-radius: 5;");
        hBox.setPadding(new Insets(10,10,10,10));

        ImageView avatar = new ImageView();
        avatar.setFitHeight(40);
        avatar.setFitWidth(40);
        avatar.setPickOnBounds(true);
        avatar.setPreserveRatio(true);//设置保存缩放比例
        avatar.setSmooth(true);            //设置平滑显示图像
        avatar.setCache(true);             //设置缓冲以提高性能
        avatar.setImage(new Image("file:src/main/resources/images/avatar.png"));

        Label name = new Label();
        name.setPrefHeight(23);
        name.setPrefWidth(135);
        name.setText("我的好友");
        name.setTextFill(Color.web("#e2e2e2"));
        name.setFont(Font.font(null, FontWeight.BOLD,17));

        hBox.getChildren().addAll(avatar,name);
        return hBox;
    }
}
