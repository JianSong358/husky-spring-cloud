package com.husky.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MOPSZ-SOFT-ROCKET")
public interface UserSearchFeign {
    /**
     * 书籍搜索异步分析
     */
    @GetMapping("/mq/user/search/sendBookSearch")
    void sendBookSearch (@RequestParam("msgContent") String msgContent) ;
}
