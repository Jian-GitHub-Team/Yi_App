package com.service;

import com.entity.Login;
import com.entity.User;
import com.globalDatas.Global_Datas;
import com.utils.Base64Util;
import com.utils.HmacSHA512_Util;
import com.utils.HttpClientUtil;
import com.utils.JsonUtils;
import com.view.User_View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author qi
 * 登录服务
 */
public class Login_Service {
    public static boolean login(String userName , String passWord){
        if ("".equals(userName) | "".equals(passWord)){
            return false;
        }
        String url = "http://localhost:8081/Yi/Login/getPassword";
        boolean result = false;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("userName", Base64Util.encode(userName));
//            hashMap.put("userName", Base64Util.encode("Jian"));
//            hashMap.put("password", Base64Util.encode("Ikarosu"));
            String s_passWord = HttpClientUtil.doPost(url,hashMap);
            if ("".equals(s_passWord)){
                return false;
            }
            User user = JsonUtils.jsonToList("[" + Base64Util.decode(s_passWord) + "]", User.class).get(0);
            if (user == null){
                return false;
            }
            user.setCreateDate(Base64Util.decode(user.getCreateDate()));
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = timeFormat.parse(user.getCreateDate());
            System.out.println(user.getCreateDate());

            String createTime = String.valueOf(date.getTime()/1000); // 时间戳转换日期
            result = Base64Util.decode(user.getPassword()).equals(HmacSHA512_Util.HmacSHA512(passWord,createTime));
//            System.out.println(Base64Util.decode(user.getPassword()));
//            System.out.println(HmacSHA512_Util.HmacSHA512(passWord,createTime));
//            System.out.println(result);
//            result = Boolean.parseBoolean(HttpClientUtil.doPost(url,hashMap));
//            if (result){
//                System.out.println(result);
//            }else {
//                System.out.println(result);
//            }
//            System.out.println(user);
            if (result) {
                Global_Datas.setUser(user);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
