package com.husky.cloud.service;

import com.husky.cloud.entity.UserBase;

import java.util.List;

public interface UserBaseService {
    // 批量写入
    void batchSave (List<UserBase> userBaseList) ;
}
