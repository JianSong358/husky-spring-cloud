package com.husky.cloud.config;

import com.husky.cloud.service.UserTokenFeign;
import com.husky.cloud.util.common.JsonUtil;
import com.husky.cloud.util.model.RespObject;
import com.husky.cloud.util.model.ServiceException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FilterConfig extends ZuulFilter {

    public static final Logger LOGGER = LoggerFactory.getLogger(FilterConfig.class) ;

    private static final String GET_TOKEN = "/token/getToken";
    private static final String VERIFY_TOKEN = "/token/verifyToken";
    private static final String REFRESH_TOKEN = "/token/refreshToken";

    @Resource
    private UserTokenFeign userTokenFeign ;

    /**
     * 前置过滤器
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 数值越大,优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器，此处为true，说明需要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true ;
    }

    /**
     * 拦截处理
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext() ;
        try {
            doTokenProcess (requestContext);
        } catch (Exception e){
            LOGGER.info("异常：{}",e.getMessage());
            throw new ZuulException(e.getMessage(), 403, e.getMessage());
        }
        return null ;
    }

    public void doTokenProcess (RequestContext requestContext) throws Exception {
        HttpServletRequest request = requestContext.getRequest() ;
        String reqUri = request.getRequestURI() ;
        if (!reqUri.contains(GET_TOKEN)) {
            String token = request.getHeader("token") ;
            boolean flag = userTokenFeign.refreshToken(token) ;
            if (!flag){
                throw new ServiceException("Token 校验失败") ;
            }
            LOGGER.info("Token 校验通过");
        }
    }
}
