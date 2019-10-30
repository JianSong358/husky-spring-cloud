package com.husky.cloud.service.impl;

import com.husky.cloud.mapper.admin.UserRoleExtendMapper;
import com.husky.cloud.service.UserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleExtendMapper userRoleExtendMapper ;

    @Override
    public List<String> getRoleAuthByUserId(Integer userId) {
        return userRoleExtendMapper.getRoleAuthByUserId(userId);
    }
}
