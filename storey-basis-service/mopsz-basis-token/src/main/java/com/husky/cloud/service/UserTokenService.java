package com.husky.cloud.service;

public interface UserTokenService {
    /**
     * 获取 TOKEN
     */
    String getToken (String userName, String passWord)  throws Exception ;
    /**
     * 验证 TOKEN
     */
    Integer verifyToken (String token) throws Exception ;
    /**
     * 刷新 TOKEN
     */
    boolean refreshToken (String token) throws Exception ;
}
