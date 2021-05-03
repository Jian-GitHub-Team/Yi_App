package com.controller;

import com.service.Registration_Service;
import com.view.Registration_View;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Registration_View_Controller {


    //输入框 边框颜色
    private final Color no = Color.rgb(0, 0, 0, 0);
    private final Color error = Color.rgb(240, 0, 0, 0.6);
    private final Color right = Color.rgb(0, 240, 0, 0.6);

    //是否输入正确 标识
    private boolean isUserNameRight;            //用户名是否正确
    private boolean isPasswordRight;            //密码是否正确
    private boolean isConfirmPasswordRight;     //确认密码是否正确

    //注册按钮 效果
    private Effect effect;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button Registration;

    @FXML
    private Button cancel;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label passwordTip;

    @FXML
    private Label userNameTip;

    @FXML
    void registration(MouseEvent event) {
//        System.out.println("鼠标事件");
        if (event.getButton() == MouseButton.PRIMARY) {
            if (isUserNameRight && isPasswordRight && isConfirmPasswordRight) {
                if (!Registration_Service.canUseUserName(userName.getText())) {
                    Border userNameBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                    isUserNameRight = false;
                    userNameTip.setText("用户名已存在");
                    userNameTip.setPrefWidth(196);
                    userName.setBorder(userNameBorder);
                    Registration.setEffect(null);
                    Registration.setDisable(true);
                    return;
                }
                Registration.setEffect(effect);
                Registration.setDisable(false);
                if (Registration_Service.registration(userName.getText(), password.getText())) {
                    Registration_View.setUser(userName.getText(), password.getText());
                    closeWindow();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.headerTextProperty().set("发生错误，请重新尝试");
                }
            }
        }
    }

    @FXML
    void registrationKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (isUserNameRight && isPasswordRight && isConfirmPasswordRight) {
                if (!Registration_Service.canUseUserName(userName.getText())) {
                    Border userNameBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                    isUserNameRight = false;
                    userNameTip.setText("用户名已存在");
                    userNameTip.setPrefWidth(196);
                    userName.setBorder(userNameBorder);
                    Registration.setEffect(null);
                    Registration.setDisable(true);
                    return;
                }
                if (Registration_Service.registration(userName.getText(), password.getText())) {
                    closeWindow();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.headerTextProperty().set("发生错误，请重新尝试");
                }
            }
        }
    }

//    @FXML
//    void checkinUserName() {
//        System.out.println(userName.getText());
//        System.out.println(userName.getText().length());
//    }
//
//    @FXML
//    void checkinPassword() {
//        System.out.println(password.getText());
//        System.out.println(password.getText().length());
//    }

    @FXML
    void cancel(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            closeWindow();
        }
    }

    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert userNameTip != null : "fx:id=\"userNameTip\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert passwordTip != null : "fx:id=\"passwordTip\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert Registration != null : "fx:id=\"Registration\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert cancel != null : "fx:id=\"cancel\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        assert confirmPassword != null : "fx:id=\"confirmPassword\" was not injected: check your FXML file 'Registration_View_FXML.fxml'.";
        passwordCheckIn();//密码框添加监听
        userNameCheckIn();//用户名框添加监听
        confirmPasswordCheckIn();//确认密码框添加监听
        Registration.setDisable(true);
        effect = Registration.getEffect();
        Registration.setEffect(null);
    }

    private void closeWindow() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    private void passwordCheckIn() {
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            Border passwordBorder = new Border(new BorderStroke(no, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            if ("".equals(password.getText())) {
                passwordTip.setText("密码需在8位与15位之间");
                isPasswordRight = false;
            } else if (!"".equals(password.getText()) && password.getText().length() > 7 && password.getText().length() <= 15) {
                passwordBorder = new Border(new BorderStroke(right, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                passwordTip.setText("");
                isPasswordRight = true;
            } else if (!"".equals(password.getText()) && (password.getText().length() < 8 || password.getText().length() > 15)) {
                passwordBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                passwordTip.setText("密码需在8位与15位之间");
                isPasswordRight = false;
            }
            password.setBorder(passwordBorder);
            i_confirmPasswordCheckIn();
            canRegistration();
        });
    }

    private void userNameCheckIn() {
        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            Border userNameBorder = null;
            if ("".equals(userName.getText())) {
                userNameBorder = new Border(new BorderStroke(no, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                userNameTip.setText("");
                isUserNameRight = false;
            } else if (!"".equals(userName.getText()) && userName.getText().length() > 1 && userName.getText().length() <= 15) {
                userNameBorder = new Border(new BorderStroke(right, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                userNameTip.setText("");
                isUserNameRight = true;
            } else if (!"".equals(userName.getText()) && (userName.getText().length() == 1 || userName.getText().length() > 15)) {
                userNameBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                userNameTip.setPrefWidth(236);
                userNameTip.setText("用户名需在2位至15位之间");
                isUserNameRight = false;
            }

            userName.setBorder(userNameBorder);
            canRegistration();
        });
    }

    private void confirmPasswordCheckIn() {
        confirmPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            i_confirmPasswordCheckIn();
        });
    }

    private void i_confirmPasswordCheckIn() {
        Border confirmPasswordBorder;

        if (password.getText().equals(confirmPassword.getText())) {
            confirmPasswordBorder = new Border(new BorderStroke(right, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            isConfirmPasswordRight = true;
        } else {
            confirmPasswordBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
            isConfirmPasswordRight = false;
        }
        confirmPassword.setBorder(confirmPasswordBorder);
        canRegistration();
    }

    private void canRegistration() {
        if (isUserNameRight && isPasswordRight && isConfirmPasswordRight) {
            Registration.setEffect(effect);
            Registration.setDisable(false);
        } else {
            Registration.setEffect(null);
            Registration.setDisable(true);
        }
    }
}