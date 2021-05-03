package com.service;

import com.entity.User;
import com.globalDatas.Global_Datas;
import com.utils.Base64Util;
import com.utils.HmacSHA512_Util;
import com.utils.HttpClientUtil;
import com.utils.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Qi
 * @Date 2021/5/3 1:58 下午
 */
public class User_Service {
    public static User selectByUserID(int ID){
        if (ID <= 0){
            return null;
        }
        String url = "http://localhost:8081/Yi/User/selectByUserID";
        User user;
        try {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("ID", ID);
            String s_user = HttpClientUtil.doPost(url,hashMap);
//            System.out.println(s_user);
//            System.out.println(Base64Util.decode(s_user));
            user = JsonUtils.jsonToList("[" + Base64Util.decode(s_user) + "]", User.class).get(0);
//            user.setCreateDate(Base64Util.decode(user.getCreateDate()));
//            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = timeFormat.parse(user.getCreateDate());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
