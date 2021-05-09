package com.threads;
/**
 * 负责更新用户界面-用户名称
 * @author Qi
 * @Date 2021/5/4 12:18 上午
 */

import com.controller.User_View_Controller;
import com.globalDatas.Global_Datas;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class User_ScheduledService extends ScheduledService<String> {
    private User_View_Controller user_view_controller;

    public User_ScheduledService(User_View_Controller user_view_controller){
        this.user_view_controller = user_view_controller;
    }
    @Override
    protected Task<String> createTask() {
//        System.out.println("User_ScheduledService : 运行中");
        Task<String> task = new Task<String>() {
            @Override
            protected String call() {
                String name = Global_Datas.getUser().getUserName();
                if (!name.equals(user_view_controller.getUserName().getText())) {
                    Global_Datas.getUser().setUserName(name);
                    return name;
                }
                return null;
            }
//            @Override
//            protected void updateValue(String unused) {
//                super.updateValue(unused);
////                System.out.println("    执行");
//                if ( unused != null) {
////                    System.out.println("        执行更改了");
//                    user_view_controller.setUserNameText(unused);
//                }
//            }
        };
        return task;
    }
}