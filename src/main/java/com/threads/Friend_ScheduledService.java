package com.threads;

import com.controller.User_View_Controller;
import com.entity.Friend;
import com.globalDatas.Global_Datas;
import com.view.Friend_Box;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.layout.VBox;

/**
 * @author Qi
 * @Date 2021/5/4 3:19 下午
 */
public class Friend_ScheduledService extends ScheduledService<VBox> {
    private User_View_Controller user_view_controller;

    public Friend_ScheduledService(User_View_Controller user_view_controller){
        this.user_view_controller = user_view_controller;
    }
/*
        for (int i = 0; i < 15; i++) {
            System.out.println(i);
            friendVBox.getChildren().add(Friend_HBox.createFriendHBox());
            if (i >= 13) {
                friendVBox.setPrefHeight(friendVBox.getPrefHeight() + 49.05);
                friendVBox.setPrefWidth(183);
            }
        }
        friends_ScrollPane.setVvalue(0);
 */
    @Override
    protected Task createTask() {
        Task<VBox> task = new Task<VBox>() {
            @Override
            protected VBox call() {
//                System.out.println("Friend_ScheduledService : 运行中");
                if (Global_Datas.getFriends().size() != user_view_controller.getFriendVBox().getChildren().size()) {
                    VBox vBox = Friend_Box.createFriendVBox();
                    for( Friend friend : Global_Datas.getFriends() ) {
                        vBox.getChildren().add(Friend_Box.createFriendHBox(friend));
                    }
                    if (vBox.getChildren().size() >= 13) {
                        vBox.setPrefWidth( vBox.getPrefHeight() + ((vBox.getChildren().size()-13) * 49.05) );
                        vBox.setPrefWidth(183);
                    }
                    return vBox;
                }
                return null;
            }

//            @Override
//            protected void updateValue(VBox friends) {
//                super.updateValue(friends);
//                if (friends != null) {
//
//                }
//            }
        };
        return task;
    }
}
