package com.example.shoppingmallsystem.util;

import android.app.Application;

public class AppContext extends Application {
    //建立一个静态私有变量用于存储上下文实例
    private static AppContext instance;

    //建立一个静态方法，用于返回所需要的上下文实例
    public static AppContext getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //将应用程序本身的上下文实例赋值给instance变量
        this.instance = AppContext.this;
    }

}
