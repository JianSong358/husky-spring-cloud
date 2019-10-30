package com.husky.cloud.service.impl;

import com.husky.cloud.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate ;

    @Override
    public boolean set(Object key, Object value) {
        boolean redisFlag = true ;
        try {
            redisTemplate.opsForValue().set(key,value);
        } catch (Exception e){
            redisFlag = false ;
            e.printStackTrace();
        }
        return redisFlag ;
    }

    @Override
    public boolean set(Object key,Object value, long expire) {
        boolean redisFlag = true ;
        try {
            redisTemplate.opsForValue().set(key,value,expire,TimeUnit.SECONDS);
        } catch (Exception e){
            redisFlag = false ;
            e.printStackTrace();
        }
        return redisFlag ;
    }

    @Override
    public String get(Object key) {
        String value = null ;
        try {
            value = String.valueOf(redisTemplate.opsForValue().get(key)) ;
        } catch (Exception e){
            e.printStackTrace();
        }
        return value ;
    }
}
