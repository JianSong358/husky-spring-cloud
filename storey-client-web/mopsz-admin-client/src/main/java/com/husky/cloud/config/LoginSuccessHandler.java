package com.husky.cloud.config;

import com.husky.cloud.entity.AdminUser;
import com.husky.cloud.entity.AdminUserExample;
import com.husky.cloud.service.AdminUserService;
import com.husky.cloud.service.RedisFeign;
import com.husky.cloud.util.common.JsonUtil;
import com.husky.cloud.util.common.RedisUtil;
import com.husky.cloud.util.constant.Constant;
import com.husky.cloud.util.model.RespObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSuccessHandler.class) ;

    @Resource
    private JwtConfig jwtConfig ;
    @Resource
    private AdminUserService adminUserService ;
    @Resource
    private RedisFeign redisFeign ;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername() ;
        AdminUserExample example = new AdminUserExample() ;
        example.createCriteria().andUserNameEqualTo(userName) ;
        // 查询用户
        AdminUser adminUser = adminUserService.selectByExample(example) ;
        Integer userId = adminUser.getId() ;
        String token = jwtConfig.generateToken(String.valueOf(userId)) ;
        String userTokenKey = RedisUtil.formatAdminTokenKey(userId) ;
        redisFeign.setTimeOut(userTokenKey,token,jwtConfig.getExpire()) ;
        // 返回对象
        RespObject respObject = new RespObject() ;
        Map<String,Object> dataMap = new HashMap<>() ;
        dataMap.put("token",token) ;
        dataMap.put("adminUser",adminUser) ;
        respObject.put(Constant.MAP_KEY,dataMap) ;
        String jsonValue = JsonUtil.objToJson(respObject) ;
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonValue);
    }
}
