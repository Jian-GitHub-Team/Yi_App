package com.threads;

import com.entity.Friend;
import com.entity.User;
import com.globalDatas.Global_Datas;
import com.service.Friend_Service;
import com.service.User_Service;
import lombok.SneakyThrows;

import java.util.List;

/**
 * @author Qi
 * @Date 2021/5/4 4:57 下午
 */
public class Friend_Thread extends Thread {
    private boolean flag = true;
    @SneakyThrows
    @Override
    public void run() {
        while (flag) {
//            System.out.println("Friend_Thread : 运行中");
            Global_Datas.setFriends(Friend_Service.getFriends());
            Thread.sleep(50);
        }
    }

    public void stopUpdateUser(){
        this.flag = false;
    }
}
