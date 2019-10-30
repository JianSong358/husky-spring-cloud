package com.husky.cloud.config;

import com.husky.cloud.util.common.JsonUtil;
import com.husky.cloud.util.constant.RespCode;
import com.husky.cloud.util.model.RespObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginFailHandler.class) ;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException authenticationException) throws IOException {
        RespObject respObject = new RespObject(RespCode.LOGIN_ERROR.getCode(),
                                               RespCode.LOGIN_ERROR.getMsg());
        String returnStr = JsonUtil.objToJson(respObject) ;
        LOGGER.info("ReturnInfo：{}",returnStr);
        response.getWriter().print(returnStr);
    }
}
