package com.husky.cloud.controller;

import com.husky.cloud.service.UserTokenFeign;
import com.husky.cloud.service.UserTokenService;
import com.husky.cloud.util.constant.Constant;
import com.husky.cloud.util.model.RespObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/token")
public class UserTokenController implements UserTokenFeign {

    @Resource
    private UserTokenService tokenService ;

    /**
     * 获取Token
     */
    @Override
    @RequestMapping("/getToken")
    public RespObject getToken (@RequestParam("userName") String userName,
                                @RequestParam("passWord") String passWord){
        try {
            String token = tokenService.getToken(userName,passWord) ;
            return RespObject.ok().put(Constant.MAP_KEY,token) ;
        } catch (Exception e){
            e.printStackTrace();
            return RespObject.error() ;
        }
    }

    @Override
    @RequestMapping("/verifyToken")
    public RespObject verifyToken(String token) {
        try {
            Integer userId = tokenService.verifyToken(token) ;
            return RespObject.ok().put(Constant.MAP_KEY,userId) ;
        } catch (Exception e){
            e.printStackTrace();
            return RespObject.error() ;
        }
    }

    @Override
    @RequestMapping("/refreshToken")
    public boolean refreshToken(String token) {
        try {
            return tokenService.refreshToken(token) ;
        } catch (Exception e){
            e.printStackTrace();
            return false ;
        }
    }

}
