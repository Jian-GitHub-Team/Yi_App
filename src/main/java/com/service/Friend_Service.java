package com.service;

import com.entity.Friend;
import com.entity.User;
import com.globalDatas.Global_Datas;
import com.utils.Base64Util;
import com.utils.HttpClientUtil;
import com.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Qi
 * @Date 2021/5/4 3:02 下午
 */
public class Friend_Service {
    public static List<Friend> getFriends(){
        String url = "http://localhost:8081/Yi/Friend/selectFriendsByID";//ID
        List<Friend> friends;
        try {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("ID", Global_Datas.getUser().getId());
            String s_friends = HttpClientUtil.doPost(url,hashMap);
            friends = JsonUtils.jsonToList(Base64Util.decode(s_friends), Friend.class);
            return friends;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
