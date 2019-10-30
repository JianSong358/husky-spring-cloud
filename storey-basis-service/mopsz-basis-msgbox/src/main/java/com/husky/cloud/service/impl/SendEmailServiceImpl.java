package com.husky.cloud.service.impl;

import com.husky.cloud.service.SendEmailService;
import com.husky.cloud.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailServiceImpl.class) ;

    // @Async("taskExecutor")
    @Override
    public void sendEmail(String receive, String title, String msg) {
        try {
            EmailUtil.sendEmail01(receive,title,msg);
        } catch (Exception e){
            e.printStackTrace() ;
            LOGGER.info("邮件发送失败：{}",e.getMessage());
        }
    }
}
