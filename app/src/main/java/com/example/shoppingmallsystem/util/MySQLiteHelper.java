package com.example.shoppingmallsystem.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shoppingmallsystem.bean.ChatMessageBean;
import com.example.shoppingmallsystem.bean.OrderBean;
import com.example.shoppingmallsystem.bean.StoreBean;
import com.example.shoppingmallsystem.bean.Userinfo;

import java.util.ArrayList;
import java.util.List;

/**
 *SQlite执行操作的封装工具类
 */
public class MySQLiteHelper {

    private static MySQLiteHelper mySQLiteHelper;
    private SQLiteDatabase db;

    private MySQLiteHelper(Context context) {
        MySQLhelper mySQLhelper = new MySQLhelper(context, MySQLhelper.DB_NAME, null, MySQLhelper.VERSION);
        db = mySQLhelper.getWritableDatabase();
    }

    public synchronized static MySQLiteHelper getInstance(Context context) {
        if (mySQLiteHelper == null) {
            mySQLiteHelper = new MySQLiteHelper(context);
        }
        return mySQLiteHelper;
    }


    //将注册的用户名密码插入到表中
    public void insertUserinfo(Userinfo userinfo) {
        db.execSQL("insert into userInfo(userName,password,nickName,phoneNumb,schoolName,apartmentNumb,money) values(?,?,?,?,?,?,?)", new Object[]{userinfo.getUserName(), userinfo.getPassword(),userinfo.getNickName(),userinfo.getPhoneNumb(),userinfo.getSchoolName(),userinfo.getApartmentNumb(),0});
        //Log.e("插入语句:", "插入已执行，插入成功");
    }


    //查询用户名密码是否正确
    public boolean queryUseristrue(String userName, String password) {
        Cursor cursor = db.rawQuery("select * from userInfo where username = ? and password = ?", new String[]{userName, password});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    //查询用户名是否存在 存在返回true 不存在false
    public boolean queryNameisExist(String username) {
        Cursor cursor = db.rawQuery("select * from userInfo where username = ? ", new String[]{username});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    //查询所有的用户名和密码信息并返回
    public List<Userinfo> queryAlluserInfo() {
        List<Userinfo> userinfos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from userInfo ", null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Userinfo userinfo = new Userinfo();
                userinfo.setId(cursor.getInt(0));
                userinfo.setUserName(cursor.getString(1));
                userinfo.setPassword(cursor.getString(2));
                userinfo.setNickName(cursor.getString(3));
                userinfo.setPhoneNumb(cursor.getString(4));
                userinfo.setSchoolName(cursor.getString(5));
                userinfo.setApartmentNumb(cursor.getString(6));
                userinfo.setMoney(cursor.getDouble(7));
                userinfos.add(userinfo);
            }
        }
        return userinfos;
    }

    //删除用户名密码表中的所有数据
    public void deleateAllUserInfo() {
        db.execSQL("DELETE  from  userInfo");
    }

    //查询用户个人信息
    public Userinfo  getUserInfoFromUserName(String userName){
        Userinfo userinfo = new Userinfo();
        Cursor cursor = db.rawQuery("SELECT * FROM userInfo WHERE userName LIKE ? ",
                new String[] {userName});
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                userinfo.setUserName(cursor.getString(1));
                userinfo.setPassword(cursor.getString(2));
                userinfo.setNickName(cursor.getString(3));
                userinfo.setPhoneNumb(cursor.getString(4));
                userinfo.setSchoolName(cursor.getString(5));
                userinfo.setApartmentNumb(cursor.getString(6));
                userinfo.setMoney(cursor.getDouble(7));
            }
        }

        return userinfo;
    }



    //修改相关用户信息
    public void updateUserInfo(Userinfo userinfo){
        db.execSQL("update userInfo set nickName = ?,phoneNumb = ?,schoolName = ?,apartmentNumb = ? where userName like ?",new String[]{userinfo.getNickName(),
                userinfo.getPhoneNumb(),userinfo.getSchoolName(),userinfo.getApartmentNumb(),userinfo.getUserName()});

    }


    //拿到当前用户ID
    public int GetUserId(String userName){
        Userinfo userinfo = new Userinfo();
        Cursor cursor = db.rawQuery("SELECT * FROM userInfo WHERE userName LIKE ? ",
                new String[] {userName});
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                userinfo.setId(cursor.getInt(0));
            }
        }
        return userinfo.getId();
    }


    //根据输入的商店ID搜索数据库并返回一个该商店的商品集合
    public String queryGoodsFromStoreID(String goodsID){
        String resultJson = null;
        Cursor cursor = db.rawQuery("SELECT * FROM goodsInfo WHERE ID LIKE ? ",
                new String[] {goodsID});
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                resultJson = cursor.getString(2);
            }
        }
        return resultJson;
    }


    //根据输入的商店ID搜索数据库并返回一个该商店的信息集合
    public StoreBean queryStoreBeanFromStoreID(String goodsID){
        StoreBean storeBean = new StoreBean();
        Cursor cursor = db.rawQuery("SELECT * FROM storeInfo WHERE ID LIKE ? ",
                new String[] {goodsID});
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                storeBean.setID(cursor.getString(1));
                storeBean.setIv_store_pic(cursor.getString(2));
                storeBean.setStoreName(cursor.getString(3));
                storeBean.setStoreScore(cursor.getString(4));
                storeBean.setStoreSell(cursor.getString(5));
                storeBean.setStoreSign(cursor.getString(6));
                storeBean.setStoreIntro(cursor.getString(7));
            }
        }
        return storeBean;
    }


    //删除指定的用户信息
    public void deleteUserInfo(String username){
        db.execSQL("DELETE  from  userInfo WHERE userName LIKE ? ",
                new String[] { username});
    }



    //查询所有商家信息的方法
    public List<StoreBean> queryAllStores(){
        List<StoreBean> storeBeans = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from storeInfo ", null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                StoreBean storeBean = new StoreBean();
                storeBean.setID(cursor.getString(1));
                storeBean.setIv_store_pic(cursor.getString(2));
                storeBean.setStoreName(cursor.getString(3));
                storeBean.setStoreScore(cursor.getString(4));
                storeBean.setStoreSell(cursor.getString(5));
                storeBean.setStoreSign(cursor.getString(6));
                storeBeans.add(storeBean);
            }
        }
        return storeBeans;
    }


    //查询所有信息的方法
    public List<ChatMessageBean> queryAllMessages(){
        List<ChatMessageBean> chatMessageBeans = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from messagesInfo ", null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                ChatMessageBean chatMessageBean = new ChatMessageBean();
                chatMessageBean.setId(cursor.getInt(1));
                chatMessageBean.setImg_id(cursor.getString(2));
                chatMessageBean.setMessage(cursor.getString(3));
                chatMessageBean.setUserName(cursor.getString(4));
                chatMessageBean.setTime(cursor.getString(5));
                chatMessageBeans.add(chatMessageBean);
            }
        }
        return chatMessageBeans;
    }


    //插入聊天信息的方法
    public void insertMessages(ChatMessageBean chatMessageBean){
        ContentValues cv =new ContentValues();
        cv.put("ID",chatMessageBean.getId());
        cv.put("img_id",chatMessageBean.getImg_id());
        cv.put("message",chatMessageBean.getMessage());
        cv.put("userName",chatMessageBean.getUserName());
        cv.put("time",chatMessageBean.getTime());
        //插入数据，参数为表名，当列为空时的填充值，封装数据的ContentValue
        db.insert("messagesInfo",null,cv);
    }


    //获取当前用户的账户余额
    public double getUserMoneyFromUserName(String userName){
        double money = 0;
        Cursor cursor = db.rawQuery("SELECT * FROM userInfo WHERE userName LIKE ? ",
                new String[] {userName});
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                money = cursor.getDouble(7);
            }
        }
        return money;
    }

    //充值的方法
    public void RechargeMoney(String userName,double newMoney){
            db.execSQL("update userInfo set money = ? where userName like ?",new Object[]{newMoney,userName});
    }


    //查询全部商家的名称
    public List<String> getAllStoreName(){
        List<String> storeNames = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM storeInfo",null);
            if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                storeNames.add(cursor.getString(3));
            }
        }
        return storeNames;
    }



    //将订单信息插入到订单表中
    public void insertOrderInfo(OrderBean orderBean) {
        db.execSQL("insert into orderInfo(userName,time,goodsJson) values(?,?,?)", new Object[]{orderBean.getUserName(),orderBean.getTime(),orderBean.getGoodsJson()});
        //Log.e("插入语句:", "插入已执行，插入成功");
    }


    //根据输入用户名返回一个该用户的订单集合
    public List<OrderBean> queryOrderBeanFromUserName(String userName){
        OrderBean orderBean ;
        List<OrderBean> result = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM orderInfo WHERE userName LIKE ? ",
                new String[] {userName});
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                orderBean = new OrderBean();
                orderBean.setUserName(cursor.getString(1));
                orderBean.setTime(cursor.getString(2));
                orderBean.setGoodsJson(cursor.getString(3));
                result.add(orderBean);
            }
        }
        return result;
    }
}