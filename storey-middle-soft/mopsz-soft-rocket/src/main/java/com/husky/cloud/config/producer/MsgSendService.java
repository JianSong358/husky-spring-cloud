package com.husky.cloud.config.producer;

import com.husky.cloud.util.rocket.MsgWrap;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class MsgSendService {

    @Resource
    private ProducerConfig producerConfig ;

    public void sendMsg (MsgWrap msgWrap) {
        producerConfig.sendMsg(msgWrap.getGroup(),msgWrap.getTopic(),msgWrap.getTag(),msgWrap.getContent());
    }

}
