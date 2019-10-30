package com.husky.cloud.controller;

import com.husky.cloud.service.RedisFeign;
import com.husky.cloud.service.RedisService;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController implements RedisFeign {

    @Resource
    private RedisService redisService ;

    @Override
    public boolean set (String key, String value) {
        return redisService.set(key,value) ;
    }
    @Override
    public boolean setTimeOut (String key, String value,long expire){
        return redisService.set(key,value,expire) ;
    }
    @Override
    public String get (String key) {
        return redisService.get(key) ;
    }
}
