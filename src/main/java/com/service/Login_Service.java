package com.service;

import com.utils.Base64Util;
import com.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qi
 * 登录服务
 */
public class Login_Service {
    public static void login(){
        String url = "http://localhost:8081/Yi/Login";
        boolean result;
        try {
            Map hashMap = new HashMap<String,String>();
            hashMap.put("userName", Base64Util.encode("Jian"));
            hashMap.put("password", Base64Util.encode("Ikarosu"));
            result = Boolean.parseBoolean(HttpClientUtil.doPost(url,hashMap));
            if (result){
                System.out.println(result);
            }else {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
