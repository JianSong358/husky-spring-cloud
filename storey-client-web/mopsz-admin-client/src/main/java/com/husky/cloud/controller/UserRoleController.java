package com.husky.cloud.controller;

import com.husky.cloud.entity.RoleInfo;
import com.husky.cloud.service.RoleInfoService;
import com.husky.cloud.util.constant.Constant;
import com.husky.cloud.util.model.RespObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/role")
public class UserRoleController {

    @Resource
    private RoleInfoService roleInfoService ;

    @RequestMapping("/getRoleByUserId")
    public RespObject getRoleByUserId (@RequestParam("userId") Integer userId){
        RoleInfo roleInfo = roleInfoService.getRoleByUserId(userId) ;
        return RespObject.ok().put(Constant.MAP_KEY,roleInfo) ;
    }
}
