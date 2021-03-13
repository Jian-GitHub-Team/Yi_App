package com.threads;

import com.service.Registration_Service;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Registration_Thread extends Thread {
    private TextField textField;
    private boolean isUserNameRight;
    private Label userNameTip;
    private Color error = Color.rgb(240,0,0,0.6);

    public Registration_Thread(TextField textField,boolean isUserNameRight,Label userNameTip){
        this.textField = textField;
        this.isUserNameRight = isUserNameRight;
        this.userNameTip = userNameTip;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            if (isUserNameRight && !"".equals(textField.getText())) {
                System.out.println("GO");
                if (!Registration_Service.canUseUserName(textField.getText())) {
                    Border userNameBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
                    isUserNameRight = false;
                    userNameTip.setText(null);
                    userNameTip.setText("用户名已存在");
                    userNameTip.setPrefWidth(196);
                    textField.setBorder(userNameBorder);
                }
            }
        });
//        while (true) {
//            if (isUserNameRight && !"".equals(textField.getText())) {
//                System.out.println("GO");
//                if (!Registration_Service.canUseUserName(textField.getText())) {
//                    Border userNameBorder = new Border(new BorderStroke(error, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1.5)));
//                    isUserNameRight = false;
//                    userNameTip.setText(null);
//                    userNameTip.setText("用户名已存在");
//                    userNameTip.setPrefWidth(196);
//                    textField.setBorder(userNameBorder);
//                }
//            }
//        }
    }
}
