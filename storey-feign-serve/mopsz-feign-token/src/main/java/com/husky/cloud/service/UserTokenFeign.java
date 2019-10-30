package com.husky.cloud.service;

import com.husky.cloud.util.model.RespObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MOPSZ-BASIS-TOKEN")
public interface UserTokenFeign {
    /**
     * 获取 TOKEN
     */
    @PostMapping("/token/getToken")
    RespObject getToken (@RequestParam("userName") String userName,
                         @RequestParam("passWord") String passWord) ;
    /**
     * 验证 TOKEN
     */
    @PostMapping("/token/verifyToken")
    RespObject verifyToken (@RequestParam("token") String token) ;
    /**
     * 刷新 TOKEN
     */
    @PostMapping("/token/refreshToken")
    boolean refreshToken (@RequestParam("token") String token) ;
}
