package com.husky.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MOPSZ-BASIS-MSGBOX")
public interface SendEmailFeign {

    /**
     * 发送Email
     */
    @PostMapping("/msgBox/sendEmail")
    void sendEmail (@RequestParam("receive") String receive,
                      @RequestParam("title") String title,
                      @RequestParam("msg") String msg) ;

}
