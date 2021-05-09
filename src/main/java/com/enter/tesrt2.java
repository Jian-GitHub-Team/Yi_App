package com.enter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class tesrt2{

    public void start() {
        Stage primaryStage = new Stage();
        URL url = null;
        try {
            url = new URL("file:src/main/resources/fxmls/User_View_Chat_FXML.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (url == null)
            System.exit(0);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        BorderPane root;
        try {
            root = fxmlLoader.load();
            root.setBackground(null);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(root);
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.show();
    }
}