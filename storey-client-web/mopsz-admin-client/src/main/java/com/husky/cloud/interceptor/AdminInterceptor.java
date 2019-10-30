package com.husky.cloud.interceptor;

import com.husky.cloud.config.JwtConfig;
import com.husky.cloud.util.constant.Constant;
import com.husky.cloud.util.model.ServiceException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtConfig jwtConfig ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI() ;
        if (uri.contains(Constant.LOGIN_URI)){
            return true ;
        }
        //获取用户凭证
        String token = request.getHeader(jwtConfig.getHeader());
        if(StringUtils.isBlank(token)){
            token = request.getParameter(jwtConfig.getHeader());
        }
        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new ServiceException(jwtConfig.getHeader() + "为空", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }
        Claims claims = jwtConfig.getClaimByToken(token);
        if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
            throw new ServiceException(jwtConfig.getHeader() + "过期，请重新登录", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }
        // 传递 UserId
        request.setAttribute(Constant.USER_ID_KEY, claims.getSubject());
        return true ;
    }

}