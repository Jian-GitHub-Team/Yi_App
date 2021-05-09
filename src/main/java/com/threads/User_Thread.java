package com.threads;

import com.entity.User;
import com.globalDatas.Global_Datas;
import com.service.User_Service;
import lombok.SneakyThrows;

/**
 * @author Qi
 * @Date 2021/5/3 11:08 下午
 */
public class User_Thread extends Thread {
    private boolean flag = true;
    @SneakyThrows
    @Override
    public void run() {
        while (flag) {
//            System.out.println("User_Thread : 运行中");

            User user = User_Service.selectByUserID(Global_Datas.getUser().getId());

            String name = user.getUserName();
            if (!Global_Datas.getUser().equals(name)){
                Global_Datas.getUser().setUserName(name);
            }

            boolean isAvatar = user.isAvatar();
            if (isAvatar != Global_Datas.getUser().isAvatar()){
                Global_Datas.getUser().setAvatar(isAvatar);
            }

            boolean isOnline = user.isOnLine();
            if (user.isOnLine() != Global_Datas.getUser().isOnLine()){
                Global_Datas.getUser().setOnLine(isOnline);
            }
//            Global_Datas.setUser(User_Service.selectByUserID(Global_Datas.getUser().getId()));
            Thread.sleep(50);
        }
    }

    public void stopUpdateUser(){
        this.flag = false;
    }
}
