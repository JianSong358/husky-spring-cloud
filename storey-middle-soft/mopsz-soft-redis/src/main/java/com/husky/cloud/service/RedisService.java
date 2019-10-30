package com.husky.cloud.service;

public interface RedisService {
    /**
     * 设置缓存
     */
    boolean set (Object key, Object value) ;
    /**
     * 设置缓存，和有效期
     */
    boolean set (Object key, Object value,long expire) ;
    /**
     * 根据 Key 获取缓存
     */
    String get (Object key) ;
}
