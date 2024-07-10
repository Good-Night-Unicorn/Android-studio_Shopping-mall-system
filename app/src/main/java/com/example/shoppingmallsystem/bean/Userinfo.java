package com.example.shoppingmallsystem.bean;

/**
 * 用户信息的bean
 */
public class Userinfo {
    private int id ;
    private String userName;
    private String password;
    private String nickName;
    private String phoneNumb;
    private String schoolName;
    private String apartmentNumb;
    private double money;


    public Userinfo(){

    }

    public Userinfo(int id, String userName, String password, String nickName, String phoneNumb, String schoolName, String apartmentNumb, double money) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.phoneNumb = phoneNumb;
        this.schoolName = schoolName;
        this.apartmentNumb = apartmentNumb;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getApartmentNumb() {
        return apartmentNumb;
    }

    public void setApartmentNumb(String apartmentNumb) {
        this.apartmentNumb = apartmentNumb;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", apartmentNumb='" + apartmentNumb + '\'' +
                ", money=" + money +
                '}';
    }
}
