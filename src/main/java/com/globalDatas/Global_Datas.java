package com.globalDatas;

import com.entity.Friend;
import com.entity.User;
import com.threads.Friend_Thread;
import com.threads.User_ScheduledService;
import com.threads.User_Thread;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * 全局数据
 * @author Qi
 * @Date 2021/5/3 1:45 上午
 */

public class Global_Datas {

//    public static void sethBox(HBox hBox) {
//        Global_Datas.hBox = hBox;
//    }

    public static ScrollPane chatScrollPane;
//    public static HBox hBox;
    public static VBox vBox;

    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * 登录本系统的用户
     */
    private static User user;

    /**
     * 获取登录系统的用户
     * @return
     */
    public static User getUser() {
        return user;
    }

    /**
     * 设置登录系统的用户
     * @param user
     */
    public static void setUser(User user) {
        Global_Datas.user = user;
    }
    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * 负责更新登录系统用户的线程
     */
    private static User_Thread userUpdateThread;

    /**
     * 获得负责更新登录系统用户的线程
     * @return
     */
    public static User_Thread getUserUpdateThread() {
        return userUpdateThread;
    }

    /**
     * 设置负责更新登录系统用户的线程
     * @param userUpdateThread
     */
    public static void setUserUpdateThread(User_Thread userUpdateThread) {
        Global_Datas.userUpdateThread = userUpdateThread;
        Global_Datas.userUpdateThread.setDaemon(true);
    }


    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * 负责更新用户界面右上角 本用户名称 与 本用户头像 的线程
     */
    private static User_ScheduledService user_thread;

    /**
     * 获得负责更新用户界面右上角 本用户名称 与 本用户头像 的线程
     * @return
     */
    public static User_ScheduledService getUser_thread() {
        return user_thread;
    }

    /**
     * 设置负责更新用户界面右上角 本用户名称 与 本用户头像 的线程
     * @param user_thread
     */
    public static void setUser_thread(User_ScheduledService user_thread) {
//        Global_Datas.user_thread = user_thread;
    }



    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * 本用户的所有好友
     */
    private static List<Friend> friends;
    /**
     * 获取本用户的所有好友
     * @return
     */
    public static List<Friend> getFriends() {
        return friends;
    }
    /**
     * 设置本用户的所有好友
     * @param friends
     */
    public static void setFriends(List<Friend> friends) {
        Global_Datas.friends = friends;
    }
    /**
     * ——————————————————————————————————————————————————————————
     */
    private static Friend_Thread friend_thread;//负责刷新本用户的所有好友

    public static Friend_Thread getFriend_thread() {
        return friend_thread;
    }

    public static void setFriend_thread(Friend_Thread friend_thread) {
        Global_Datas.friend_thread = friend_thread;
    }

    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * 当前在聊好友
     */
    private static Friend friend;

    public static Friend getFriend() {
        return friend;
    }

    public static void setFriend(Friend friend) {
        Global_Datas.friend = friend;
    }

    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * ——————————————————————————————————————————————————————————
     */
    /**
     * ——————————————————————————————————————————————————————————
     */
}
