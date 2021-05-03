package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 好友关系
 * @author qi
 */

@Data
public class FriendShip {
    private int id;//本表id
    private int userId;//用户id
    private int friendId;//好友id
    private Date time;//时间
}
