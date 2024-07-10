package com.example.shoppingmallsystem.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtill {

    //获取当前系统时间
    public static String getCurrentTime(){
        String time = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        time = simpleDateFormat.format(date);
        //Log.e("Tag","当前的时间：" + time);
        return time;
    }

    public static Date stringToDate(String dateString){
        ParsePosition position = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateString,position);
        return date;
    }


    //拿到七天后的时间
    public static String getAfterSevenDayTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)+ 604800);
        String afterSevenDay = simpleDateFormat.format(calendar.getTime());
        //Log.e("Tag","七天后的时间：" + afterSevenDay);
        return afterSevenDay;
    }

}
