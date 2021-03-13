package com.service;

import com.utils.Base64Util;
import com.utils.HttpClientUtil;

import java.util.HashMap;

/**
 * @author qi
 * 注册 服务
 */
public class Registration_Service {

    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @return 是否成功（是/否） boolean
     */
    public static boolean registration(String userName,String password){
        String url = "http://localhost:8081/Yi/Registration/registration";
        boolean result;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("userName", Base64Util.encode(userName));
            hashMap.put("password", Base64Util.encode(password));
            hashMap.put("time", Base64Util.encode(String.valueOf(System.currentTimeMillis()/1000)));
            result = Boolean.parseBoolean(HttpClientUtil.doPost(url,hashMap));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @param userName 要查询是否可用的用户名
     * @return 返回是否可用（是/否） boolean
     */
    public static boolean canUseUserName(String userName){
        String url = "http://localhost:8081/Yi/Registration/canUseUserName";
        boolean result;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("userName", Base64Util.encode(userName));
            result = Boolean.parseBoolean(HttpClientUtil.doPost(url,hashMap));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
