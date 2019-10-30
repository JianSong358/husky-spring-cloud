package com.husky.cloud.service.impl;

import com.husky.cloud.entity.AdminUser;
import com.husky.cloud.entity.AdminUserExample;
import com.husky.cloud.service.AdminUserService;
import com.husky.cloud.service.UserRoleService;
import com.husky.cloud.util.constant.RespCode;
import com.husky.cloud.util.model.ServiceException;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private AdminUserService adminUserService ;
    @Resource
    private UserRoleService userRoleService ;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AdminUserExample example = new AdminUserExample() ;
        example.createCriteria().andUserNameEqualTo(userName) ;
        // 查询用户
        AdminUser adminUser = adminUserService.selectByExample(example) ;
        if (adminUser == null){
            throw new ServiceException(RespCode.LOGIN_ERROR.getCode(),RespCode.LOGIN_ERROR.getMsg());
        }
        // 权限录入
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>() ;
        List<String> roleList = userRoleService.getRoleAuthByUserId(adminUser.getId()) ;
        if (roleList != null && roleList.size()>0){
            for (String role:roleList) {
                if (StringUtils.isNotEmpty(role)) {
                    grantedAuthorityList.add(new SimpleGrantedAuthority(role)) ;
                }
            }
        }
        return new User(userName,adminUser.getPassWord(),grantedAuthorityList);
    }
}
