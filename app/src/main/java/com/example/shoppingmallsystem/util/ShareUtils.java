package com.example.shoppingmallsystem.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {
    static SharedPreferences preferences = AppContext.getInstance().getSharedPreferences("data", Context.MODE_PRIVATE);
    static SharedPreferences.Editor editor = preferences.edit();

    /**
     * 从SharedPreferences保存的文件中获取是否自动登录
     */
    public static String getAuto_Login() {
        return preferences.getString("AUTO_LOGIN", "");
    }

    /**
     * 从SharedPreferences保存的文件中获取是否自动登录
     */
    public static void putAuto_Login( String tag) {
        editor.putString("AUTO_LOGIN", tag);
        editor.commit();
    }

    /**
     * 从SharedPreferences保存的文件中获取是否记住密码
     */
    public static String getRember() {
        return preferences.getString("Rember", "");
    }

    /**
     * 从SharedPreferences保存的文件中获取否记住密码
     */
    public static void putRember( String isRember) {
        editor.putString("Rember", isRember);
        editor.commit();
    }

    /**
     * 向SharedPreferences存储用户名
     */
    public static void putUserName(String username) {
        editor.putString("UserName", username);
        editor.commit();
    }
    /**
     * 从SharedPreferences取出用户名
     */
    public static String getUserName() {
        return preferences.getString("UserName", "");
    }


    /**
     * 向SharedPreferences存储密码
     */
    public static void putPassword(String password) {
        editor.putString("Password", password);
        editor.commit();
    }
    /**
     * 从SharedPreferences取出密码
     */
    public static String getPassword() {
        return preferences.getString("Password", "");
    }

}
