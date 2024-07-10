package com.example.shoppingmallsystem.bean;

import java.io.Serializable;


/**
 *  商家信息bean
 */
public class StoreBean implements Serializable {

    private String ID;
    private String iv_store_pic;
    private String storeName;
    private String storeScore;
    private String storeSell;
    private String storeSign;
    private String storeIntro;

    public StoreBean(String ID, String iv_store_pic, String storeName, String storeScore, String storeSell, String storeSign, String storeIntro) {
        this.ID = ID;
        this.iv_store_pic = iv_store_pic;
        this.storeName = storeName;
        this.storeScore = storeScore;
        this.storeSell = storeSell;
        this.storeSign = storeSign;
        this.storeIntro = storeIntro;
    }

    public StoreBean() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIv_store_pic() {
        return iv_store_pic;
    }

    public void setIv_store_pic(String iv_store_pic) {
        this.iv_store_pic = iv_store_pic;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreScore() {
        return storeScore;
    }

    public void setStoreScore(String storeScore) {
        this.storeScore = storeScore;
    }

    public String getStoreSell() {
        return storeSell;
    }

    public void setStoreSell(String storeSell) {
        this.storeSell = storeSell;
    }

    public String getStoreSign() {
        return storeSign;
    }

    public void setStoreSign(String storeSign) {
        this.storeSign = storeSign;
    }

    public String getStoreIntro() {
        return storeIntro;
    }

    public void setStoreIntro(String storeIntro) {
        this.storeIntro = storeIntro;
    }

    @Override
    public String toString() {
        return "StoreBean{" +
                "ID='" + ID + '\'' +
                ", iv_store_pic='" + iv_store_pic + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeScore='" + storeScore + '\'' +
                ", storeSell='" + storeSell + '\'' +
                ", storeSign='" + storeSign + '\'' +
                ", storeIntro='" + storeIntro + '\'' +
                '}';
    }
}
