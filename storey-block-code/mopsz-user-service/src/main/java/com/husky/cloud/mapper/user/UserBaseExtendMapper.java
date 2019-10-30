package com.husky.cloud.mapper.user;

import com.husky.cloud.entity.UserBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBaseExtendMapper {
    void batchSave (@Param("userBaseList") List<UserBase> userBaseList) ;
}