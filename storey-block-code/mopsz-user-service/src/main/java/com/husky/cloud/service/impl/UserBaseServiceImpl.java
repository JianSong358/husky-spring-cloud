package com.husky.cloud.service.impl;

import com.husky.cloud.entity.UserBase;
import com.husky.cloud.mapper.user.UserBaseExtendMapper;
import com.husky.cloud.mapper.user.UserBaseMapper;
import com.husky.cloud.service.UserBaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBaseServiceImpl implements UserBaseService {

    @Resource
    private UserBaseExtendMapper userBaseExtendMapper ;
    @Resource
    private UserBaseMapper userBaseMapper ;

    @Override
    public void batchSave(List<UserBase> userBaseList) {
        userBaseExtendMapper.batchSave(userBaseList);
    }
}
