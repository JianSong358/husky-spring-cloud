package com.husky.cloud.service.impl;

import com.husky.cloud.config.ConsumerParam;
import com.husky.cloud.config.consumer.Consumer;
import com.husky.cloud.config.consumer.MsgMonitor;
import com.husky.cloud.config.consumer.MsgReadService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Service
public class InitConfigImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitConfigImpl.class) ;

    @Resource
    private ConsumerParam consumerParam ;

    @Resource
    private ApplicationContext applicationContext ;

    @PostConstruct
    public void initConfig (){
        Map<String,Object> consumers = applicationContext.getBeansWithAnnotation(Consumer.class);
        Set<String> keys = consumers.keySet() ;
        for (String key:keys){
            Object object = consumers.get(key) ;
            MsgReadService msgReadService = (MsgReadService)object ;
            Consumer consumer = object.getClass().getAnnotation(Consumer.class) ;
            LOGGER.info("group：{},topic：{},tag：{}",consumer.group(),consumer.topic(),consumer.tag());
            initConsumer(consumer,msgReadService);
        }
    }

    private void initConsumer (Consumer consumer,MsgReadService msgReadService){
        try {
            DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer(consumer.group());
            pushConsumer.setNamesrvAddr(consumerParam.getServerPort());
            pushConsumer.subscribe(consumer.topic(), consumer.tag());
            pushConsumer.setConsumeThreadMin(consumerParam.getConsumeThreadMin());
            pushConsumer.setConsumeThreadMax(consumerParam.getConsumeThreadMax());
            pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            pushConsumer.registerMessageListener(new MsgMonitor(msgReadService));
            pushConsumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
