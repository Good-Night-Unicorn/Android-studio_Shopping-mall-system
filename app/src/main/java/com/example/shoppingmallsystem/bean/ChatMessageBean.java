package com.example.shoppingmallsystem.bean;

import java.io.Serializable;


/**
 *  评论信息bean
 */
public class ChatMessageBean implements Serializable {

    private int id ;
    private String img_id;
    private String message;
    private String userName;
    private String time;


    public ChatMessageBean(int id, String img_id, String message, String userName, String time) {
        this.id = id;
        this.img_id = img_id;
        this.message = message;
        this.userName = userName;
        this.time = time;
    }

    public ChatMessageBean() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatMessageBean{" +
                "id=" + id +
                ", img_id='" + img_id + '\'' +
                ", message='" + message + '\'' +
                ", userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
