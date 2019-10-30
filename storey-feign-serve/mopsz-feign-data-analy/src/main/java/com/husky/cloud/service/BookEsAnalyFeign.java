package com.husky.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MOPSZ-DATA-ANALY")
public interface BookEsAnalyFeign {
    /**
     * 书籍搜索消息
     */
    @GetMapping("/book/es/analy/sendBookEsMsg")
    void sendBookEsMsg (@RequestParam("msgBody") String msgBody) ;
}
