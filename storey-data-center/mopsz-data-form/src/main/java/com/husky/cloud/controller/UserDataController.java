package com.husky.cloud.controller;

import com.husky.cloud.entity.UserBase;
import com.husky.cloud.service.UserBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户基础信息入库接口
 */
@RestController
@RequestMapping("/user/data")
public class UserDataController {

    @Resource
    private UserBaseService userBaseService ;

    @RequestMapping("/batchSave")
    public String batchSave (){

        List<UserBase> userBaseList = new ArrayList<>() ;

        for (int i = 1 ; i <= 10 ; i++){
            UserBase userBase = new UserBase() ;
            userBase.setUserName("cicada"+i);
            userBase.setPassWord("password"+i);
            userBase.setPhone("1822345678"+i);
            userBase.setEmail(userBase.getUserName()+"@qq.com");
            userBase.setCreateTime(new Date());
            userBase.setUpdateTime(userBase.getCreateTime());
            userBaseList.add(userBase) ;
        }

        userBaseService.batchSave(userBaseList);
        return "success" ;
    }

}
