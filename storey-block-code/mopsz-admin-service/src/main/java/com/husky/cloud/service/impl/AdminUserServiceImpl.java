package com.husky.cloud.service.impl;

import com.husky.cloud.entity.AdminUser;
import com.husky.cloud.entity.AdminUserExample;
import com.husky.cloud.mapper.admin.AdminUserMapper;
import com.husky.cloud.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper ;

    @Override
    public AdminUser selectByExample(AdminUserExample example) {
        List<AdminUser> adminUserList = adminUserMapper.selectByExample(example) ;
        if (adminUserList != null && adminUserList.size()>0){
            return adminUserList.get(0) ;
        }
        return null;
    }
}
