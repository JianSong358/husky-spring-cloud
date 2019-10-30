package com.husky.cloud.service.impl;

import com.husky.cloud.config.producer.MsgSendService;
import com.husky.cloud.service.SendMsgService;
import com.husky.cloud.util.rocket.MsgWrap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SendMsgServiceImpl implements SendMsgService {

    @Resource
    private MsgSendService msgSendService ;

    @Override
    public void sendMsg(MsgWrap msgWrap) {
        msgSendService.sendMsg(msgWrap) ;
    }
}
