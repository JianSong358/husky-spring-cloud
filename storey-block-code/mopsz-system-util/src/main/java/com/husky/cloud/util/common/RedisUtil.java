package com.husky.cloud.util.common;

/**
 * Redis工具类
 */
public class RedisUtil {

    public static final long KEY_EXPIRE_01 = 60*60*12 ;

    public static String formatAdminTokenKey (Integer userId){
        return String.format("admin:token:key:%s",userId) ;
    }
    public static String formatUserTokenKey (Integer userId){
        return String.format("user:token:key:%s",userId) ;
    }
    public static boolean valueNull (String value){
        return !"null".equals(value) ;
    }
}
