package com.globalDatas;

import com.entity.User;

/**
 * 全局数据
 * @author Qi
 * @Date 2021/5/3 1:45 上午
 */

public class Global_Datas {

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
     * 负责更新用户界面右上角 本用户名称 与 本用户头像 的线程
     */
    private static Thread user_thread;

    /**
     * 获得负责更新用户界面右上角 本用户名称 与 本用户头像 的线程
     * @return
     */
    public static Thread getUser_thread() {
        return user_thread;
    }

    /**
     * 设置负责更新用户界面右上角 本用户名称 与 本用户头像 的线程
     * @param user_thread
     */
    public static void setUser_thread(Thread user_thread) {
        Global_Datas.user_thread = user_thread;
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
}
