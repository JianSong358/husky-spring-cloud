package com.husky.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MOPSZ-SOFT-REDIS")
public interface RedisFeign {
    /**
     * 设置缓存
     */
    @PostMapping("/redis/set")
    boolean set (@RequestParam("key") String key, @RequestParam("value") String value) ;
    /**
     * 设置缓存，和有效期
     */
    @PostMapping("/redis/setTimeOut")
    boolean setTimeOut (@RequestParam("key") String key,
                        @RequestParam("value") String value,
                        @RequestParam("expire") long expire) ;
    /**
     * 根据 Key 获取缓存
     */
    @GetMapping("/redis/get")
    String get (@RequestParam("key") String key) ;
}
