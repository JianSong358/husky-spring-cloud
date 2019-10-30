package com.husky.cloud.service;

import com.husky.cloud.entity.AdminUser;
import com.husky.cloud.entity.AdminUserExample;

public interface AdminUserService {

    AdminUser selectByExample(AdminUserExample example) ;
}
