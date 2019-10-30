package com.husky.cloud.mapper.admin;

import com.husky.cloud.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserRoleExtendMapper {

    List<String> getRoleAuthByUserId (@Param("userId") Integer userId) ;

    UserRole getByUserId (@Param("userId") Integer userId) ;

}