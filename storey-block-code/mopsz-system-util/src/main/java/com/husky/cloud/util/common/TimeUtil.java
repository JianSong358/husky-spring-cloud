package com.husky.cloud.util.common;

import org.joda.time.DateTime;
import java.util.Date;

/**
 * 时间工具类：Joda-Time 组件二次封装
 */
public class TimeUtil {
    private TimeUtil (){}

    public static final String FORMAT_01 = "yyyy-MM-dd HH:mm:ss" ;

    public static final String FORMAT_02 = "yyyy-MM-dd" ;

    public static Date getNow (){
        return new Date() ;
    }

    public static String formatDate (Date date,String dateFormat){
        DateTime dateTime = new DateTime(date) ;
        return dateTime.toString(dateFormat) ;
    }

}
