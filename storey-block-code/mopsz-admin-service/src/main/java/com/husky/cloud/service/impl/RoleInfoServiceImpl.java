package com.husky.cloud.service.impl;

import com.husky.cloud.entity.RoleInfo;
import com.husky.cloud.entity.RoleInfoExample;
import com.husky.cloud.entity.UserRole;
import com.husky.cloud.mapper.admin.RoleInfoMapper;
import com.husky.cloud.mapper.admin.UserRoleExtendMapper;
import com.husky.cloud.service.RoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Resource
    private RoleInfoMapper roleInfoMapper ;
    @Resource
    private UserRoleExtendMapper userRoleExtendMapper ;

    @Override
    public RoleInfo getRoleByUserId(Integer userId) {
        UserRole userRole = userRoleExtendMapper.getByUserId(userId) ;
        if (userRole != null){
            return roleInfoMapper.selectByPrimaryKey(userRole.getId()) ;
        }
        return null ;
    }

    @Override
    public RoleInfo selectByExample(RoleInfoExample example) {
        List<RoleInfo> roleInfoList = roleInfoMapper.selectByExample(example) ;
        if (roleInfoList != null && roleInfoList.size() > 0){
            return roleInfoList.get(0) ;
        }
        return null ;
    }

}
