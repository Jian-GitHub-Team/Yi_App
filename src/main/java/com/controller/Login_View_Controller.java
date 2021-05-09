package com.controller;

import com.entity.ChatContent;
import com.globalDatas.Global_Datas;
import com.service.Login_Service;
import com.threads.Friend_Thread;
import com.threads.User_Thread;
import com.view.Chat_Content_Box;
import com.view.Registration_View;
import com.view.User_View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Login_View_Controller {

    private Registration_View registration_view = null;
    private Stage stage;

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
    void login_Mouse(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY) {
            if (!"".equals(userName.getText()) && !"".equals(password.getText())) {
                if (Login_Service.login(userName.getText(), password.getText())) {

                    Global_Datas.setUserUpdateThread(new User_Thread());
                    Global_Datas.getUserUpdateThread().start();//开始实时刷新本用户数据

                    Global_Datas.setFriend_thread(new Friend_Thread());
                    Global_Datas.getFriend_thread().start();//开始实时刷新本用户所有好友

                    User_View user_view = new User_View();
                    stage.close();
                    user_view.start();
                }
            }
        }
    }

    @FXML
    void login_Key(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (!"".equals(userName.getText()) && !"".equals(password.getText())) {
                if (Login_Service.login(userName.getText(), password.getText())) {

                    Global_Datas.setUserUpdateThread(new User_Thread());
                    Global_Datas.getUserUpdateThread().start();//开始实时刷新本用户数据

                    Global_Datas.setFriend_thread(new Friend_Thread());
                    Global_Datas.getFriend_thread().start();//开始实时刷新本用户所有好友

                    User_View user_view = new User_View();
                    stage.close();
                    user_view.start();
                }
            }
        }
    }

    @FXML
    void quit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void registration(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && ( registration_view == null ? true : !registration_view.isShowing() )) {
            registration_view = new Registration_View(this);
            registration_view.start();
        }else if (event.getButton() == MouseButton.PRIMARY && registration_view != null && registration_view.isShowing()) {
            registration_view.focus();
        }
    }

    public void setUser(String userName,String password){
        this.userName.setText(userName);
        this.password.setText(password);
    }

    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert login_Button != null : "fx:id=\"login_Button\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert quit_Button != null : "fx:id=\"quit_Button\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
        assert registration != null : "fx:id=\"registration\" was not injected: check your FXML file 'Login_View_FXML.fxml'.";
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
}
