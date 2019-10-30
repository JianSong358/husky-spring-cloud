package com.husky.cloud.service.impl;

import com.husky.cloud.entity.UserBase;
import com.husky.cloud.entity.UserBaseExample;
import com.husky.cloud.mapper.user.UserBaseMapper;
import com.husky.cloud.service.RedisFeign;
import com.husky.cloud.service.UserTokenService;
import com.husky.cloud.util.common.RedisUtil;
import com.husky.cloud.util.constant.Constant;
import com.husky.cloud.util.security.RsaCryptUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Resource
    private UserBaseMapper userBaseMapper ;
    @Resource
    private RedisFeign redisFeign ;

    @Override
    public String getToken(String userName, String passWord) throws Exception {
        UserBaseExample example = new UserBaseExample() ;
        example.createCriteria().andUserNameEqualTo(userName) ;
        UserBase userBase = selectByExample(example) ;
        if (userBase != null){
            String secrete = userBase.getPassWord() ;
            if (secrete.equals(passWord)) {
                // 返回 Token
                String value = userBase.getId().toString() ;
                String publicKeyStr = RsaCryptUtil.getKey(RsaCryptUtil.PUB_KEY) ;
                String token = RsaCryptUtil.encrypt(RsaCryptUtil.createPublicKey(publicKeyStr),value.getBytes()) ;
                String key = RedisUtil.formatUserTokenKey(userBase.getId()) ;
                redisFeign.setTimeOut(key,token, Constant.USER_TOKEN_EXPIRE) ;
                return token ;
            }
        }
        return null;
    }

    @Override
    public Integer verifyToken(String token) throws Exception {
        String privateKeyStr = RsaCryptUtil.getKey(RsaCryptUtil.PRI_KEY) ;
        String userId = RsaCryptUtil.decrypt(RsaCryptUtil.createPrivateKey(privateKeyStr),
                             RsaCryptUtil.parseBase64Binary(token));
        return Integer.parseInt(userId) ;
    }

    @Override
    public boolean refreshToken(String token) throws Exception {
        Integer userId = verifyToken(token) ;
        if (userId > 0 ){
            String key = RedisUtil.formatUserTokenKey(userId) ;
            // 判断Token 是否过期
            String cacheToken = redisFeign.get(key) ;
            if (StringUtils.isEmpty(cacheToken)){
                return false ;
            }
            redisFeign.setTimeOut(key,token, Constant.USER_TOKEN_EXPIRE) ;
            return true ;
        }
        return false ;
    }

    public UserBase selectByExample (UserBaseExample example){
        List<UserBase> userBaseList = userBaseMapper.selectByExample(example) ;
        if (userBaseList != null && userBaseList.size()>0){
            return userBaseList.get(0) ;
        }
        return null ;
    }
}
