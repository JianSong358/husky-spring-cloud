package com.husky.cloud.controller;

import com.husky.cloud.service.BookEsAnalyFeign;
import com.husky.cloud.service.BookEsDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookEsDataController implements BookEsAnalyFeign {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookEsDataController.class) ;
    @Resource
    private BookEsDataService bookEsDataService ;
    @Override
    public void sendBookEsMsg(String msgBody) {
        LOGGER.info("MsgBody:{}",msgBody);
        bookEsDataService.saveBookEsData(msgBody);
    }
}
