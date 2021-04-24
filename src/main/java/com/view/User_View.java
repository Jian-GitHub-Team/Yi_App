package com.view;

import com.controller.Login_View_Controller;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * 用户界面
 *
 * @author qi
 */
public class User_View {

    private static Login_View_Controller login_view_controller;
    private Stage primaryStage;
    private BorderPane root;
    private Scene scene;

    //窗体拉伸属性
//    private static boolean isRight;// 是否处于右边界调整窗口状态
//    private static boolean isBottomRight;// 是否处于右下角调整窗口状态
//    private static boolean isBottom;// 是否处于下边界调整窗口状态
//    private final static int RESIZE_WIDTH = 5;// 判定是否为调整窗口状态的范围与边界距离
//    private final static double MIN_WIDTH = 500;// 窗口最小宽度
//    private final static double MIN_HEIGHT = 350;// 窗口最小高度
    private double xOffset = 0;
    private double yOffset = 0;

    public void start() {
        primaryStage = new Stage();
        // 获得屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // 设置窗口位置居中以及窗口大小
        double view_x = (screenSize.width - 500) / 2;
        double view_y = (screenSize.height - 350) / 2;

        String fxml = "fxmls/Registration_View_FXML.fxml";
        URL url = getClass().getClassLoader().getResource(fxml);
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        primaryStage.setX(view_x);
        primaryStage.setY(view_y);
        primaryStage.setTitle("Yi");

        scene = new Scene(root, 300, 500);

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

//        root.setOnMouseMoved(event -> {
//            event.consume();
//            double x = event.getSceneX();
//            double y = event.getSceneY();
//            double width = primaryStage.getWidth();
//            double height = primaryStage.getHeight();
//            javafx.scene.Cursor cursorType = javafx.scene.Cursor.DEFAULT;// 鼠标光标初始为默认类型，若未进入调整窗口状态，保持默认类型
//
//            // 先将所有调整窗口状态重置
//            isRight = isBottomRight = isBottom = false;
//            if (y >= height - RESIZE_WIDTH) {
//                if (x <= RESIZE_WIDTH) {// 左下角调整窗口状态
//
//                } else if (x >= width - RESIZE_WIDTH) {// 右下角调整窗口状态
//                    isBottomRight = true;
//                    cursorType = javafx.scene.Cursor.SE_RESIZE;
//                } else {// 下边界调整窗口状态
//                    isBottom = true;
//                    cursorType = javafx.scene.Cursor.S_RESIZE;
//                }
//            } else if (x >= width - RESIZE_WIDTH) {// 右边界调整窗口状态
//                isRight = true;
//                cursorType = Cursor.E_RESIZE;
//            }
////            // 最后改变鼠标光标
//            root.setCursor(cursorType);
//        });
//
        root.setOnMouseDragged(event -> {
            double x = event.getSceneX();
            double y = event.getSceneY();
            // 保存窗口改变后的x、y坐标和宽度、高度，用于预判是否会小于最小宽度、最小高度
            double nextX = primaryStage.getX();
            double nextY = primaryStage.getY();
//            double nextWidth = primaryStage.getWidth();
//            double nextHeight = primaryStage.getHeight();

//            if (isRight || isBottomRight) {// 所有右边调整窗口状态
//                nextWidth = x;
//            }
//            if (isBottomRight || isBottom) {// 所有下边调整窗口状态
//                nextHeight = y;
//            }
//            if (nextWidth <= MIN_WIDTH) {// 如果窗口改变后的宽度小于最小宽度，则宽度调整到最小宽度
//                nextWidth = MIN_WIDTH;
//            }
//            if (nextHeight <= MIN_HEIGHT) {// 如果窗口改变后的高度小于最小高度，则高度调整到最小高度
//                nextHeight = MIN_HEIGHT;
//            }
            // 最后统一改变窗口的x、y坐标和宽度、高度，可以防止刷新频繁出现的屏闪情况
            primaryStage.setX(nextX);
            primaryStage.setY(nextY);
//            primaryStage.setWidth(nextWidth);
//            primaryStage.setHeight(nextHeight);
//            if(!isBottom && !isBottomRight && !isRight)
//            {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
//            }
        });

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    public User_View(Login_View_Controller login_view_controller){
        this.login_view_controller = login_view_controller;
    }

    public static void setUser(String userName,String password){
        login_view_controller.setUser(userName,password);
    }

    public boolean isShowing(){
        return primaryStage.isShowing();
    }

    public void focus(){
        primaryStage.requestFocus();
    }

    private void setComponents() {
//      设置面板文字
        Label userName = new Label("用户名");
        Label password = new Label("密码");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(userName, password);
        vBox.setPadding(new Insets(30, 30, 30, 100));
        vBox.setAlignment(Pos.CENTER_LEFT);

        root.setCenter(vBox);

//      设置背景图片
        String url = "file:" + this.getClass().getResource("/").getPath() + "/images/HomepageGlass.png";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(url),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
//        root.setCenter(backgroudImage);
    }

    public void close(){
        this.primaryStage.close();
    }
}
