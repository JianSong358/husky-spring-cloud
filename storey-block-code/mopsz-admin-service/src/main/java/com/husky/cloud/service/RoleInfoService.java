package com.husky.cloud.service;

import com.husky.cloud.entity.RoleInfo;
import com.husky.cloud.entity.RoleInfoExample;

public interface RoleInfoService {

    RoleInfo getRoleByUserId (Integer userId) ;

    RoleInfo selectByExample (RoleInfoExample example);
}
