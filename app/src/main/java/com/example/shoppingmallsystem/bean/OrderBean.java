package com.example.shoppingmallsystem.bean;

import java.io.Serializable;


/**
 *  订单信息bean
 */
public class OrderBean implements Serializable {

    private String userName ;
    private String time ;
    private String goodsJson ;

    public OrderBean(String userName, String time, String goodsJson) {
        this.userName = userName;
        this.time = time;
        this.goodsJson = goodsJson;
    }

    public OrderBean() {

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

    public String getGoodsJson() {
        return goodsJson;
    }

    public void setGoodsJson(String goodsJson) {
        this.goodsJson = goodsJson;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", goodsJson='" + goodsJson + '\'' +
                '}';
    }
}
