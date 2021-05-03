package com.threads;

import com.controller.User_View_Controller;
import com.entity.User;
import com.globalDatas.Global_Datas;
import com.service.User_Service;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

/*
new Thread(new Task<Void>() {

        // call方法里面的线程非JavaFX线程
        @Override
        protected Void call() throws Exception {
            button.setText("1xxx");  // 这里会报错
            return null;
        }

        @Override
        protected void succeeded() {
            button.setText("xxx");
            System.out.println(Thread.currentThread());

            super.succeeded();
        }

    }).start();
 */

public class User_ScheduledService extends ScheduledService<String> {
    private User_View_Controller user_view_controller;

    public User_ScheduledService(User_View_Controller user_view_controller){
        this.user_view_controller = user_view_controller;
    }
    @Override
    protected Task<String> createTask() {
        Task<String> task = new Task<String>() {
            @Override
            protected String call() {
                User user = User_Service.selectByUserID(Global_Datas.getUser().getId());
                if (!user.getUserName().equals(user_view_controller.getUserName().getText())) {
                    System.out.println("更改");
                    System.out.println(user.getUserName());
                    System.out.println(user_view_controller.getUserName().getText());
                    Global_Datas.getUser().setUserName(user.getUserName());
                    return user.getUserName();
                }
                return null;
            }
            @Override
            protected void updateValue(String unused) {
                super.updateValue(unused);
                System.out.println("    执行");
                if ( unused != null) {
                    System.out.println("        执行更改了");
                    user_view_controller.setUserNameText(unused);
                }
            }
        };
        return task;
    }
}


//public class User_Thread extends Task<String> {
//    private User_View_Controller user_view_controller;
//    private boolean flag = true;
//
//    public User_Thread(User_View_Controller user_view_controller) {
//        this.user_view_controller = user_view_controller;
//    }
//
//    @Override
//    protected void updateValue(String unused) {
//        System.out.println("    执行");
//        if ( !"".equals(unused)) {
//            user_view_controller.setUserNameText(unused);
//        }
//        super.updateValue(unused);
//    }
//
//    //    @Override
////    public void run() {
////        System.out.println("运行");
////        // set avatar
////            Image image = Global_Datas.getUser().isAvatar() ?
//////                    Image_Util.crop(
////                            new Image(
////                                    "http://resources.jian-internet.com:50000/images/"+
////                                            Base64Util.encode(Global_Datas.getUser().getUserName()) +
////                                            ".png"
////                            )
//////                    )
////                    :
////                    new Image("file:src/main/resources/images/avatar.png");
//////        while (flag) {
////            Platform.runLater(
////                    () -> {
////                            user_view_controller.getUserAvatar().setImage(image);
////                            // set userName
////                            user_view_controller.getUserName().setText(Global_Datas.getUser().getUserName());
////                    }
////            );
//////        }
////
////    }
//
//
//    @Override
//    protected String call() {
//
//        while (flag) {
//            System.out.println("运行");
//            User user = User_Service.selectByUserID(Global_Datas.getUser().getId());
//            if (!user.getUserName().equals(user_view_controller.getUserName().getText())) {
//                System.out.println("更改");
//                System.out.println(user.getUserName());
//                System.out.println(user_view_controller.getUserName().getText());
//                Global_Datas.getUser().setUserName(user.getUserName());
////                this.updateValue(user.getUserName());
//                return user.getUserName();
////                user_view_controller.setUserNameText(user.getUserName());
////                Platform.runLater(
//////                        () -> user_view_controller.getUserName().setText(user.getUserName())
////                        () -> user_view_controller.setUserNameText(user.getUserName())
////                );
////                flag = false;
////            }
////            try {
////                Thread.sleep(5000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//                // set avatar
////            Image image = Global_Datas.getUser().isAvatar() ?
//////                Image_Util.crop(
////                    new Image(
////                            "http://resources.jian-internet.com:50000/images/" +
////                                    Base64Util.encode(Global_Datas.getUser().getUserName()) +
////                                    ".png"
////                    )
//////                )
////                    :
////                    new Image("file:src/main/resources/images/avatar.png");
////            Platform.runLater(
////                    () -> {
////                        user_view_controller.getUserAvatar().setImage(image);
////                        // set userName
////                        user_view_controller.getUserName().setText(Global_Datas.getUser().getUserName());
////                    }
////            );
//            }
//        }
//            super.succeeded();
////        }
//        return "";
//    }
//
//    public void stopUser_Thread() {
//        this.flag = false;
//    }
//
////    @Override
////    protected Void call() throws Exception {
////        return null;
////    }
//}
