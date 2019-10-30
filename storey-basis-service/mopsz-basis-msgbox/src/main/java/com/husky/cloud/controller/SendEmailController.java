package com.husky.cloud.controller;

import com.husky.cloud.service.SendEmailFeign;
import com.husky.cloud.service.SendEmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class SendEmailController implements SendEmailFeign {

    @Resource
    private SendEmailService sendEmailService ;

    @Override
    public void sendEmail(String receive, String title, String msg) {
        sendEmailService.sendEmail(receive,title,msg);
    }

}
