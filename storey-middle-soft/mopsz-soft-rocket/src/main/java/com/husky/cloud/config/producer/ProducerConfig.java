package com.husky.cloud.config.producer;

import com.husky.cloud.config.ProducerParam;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class ProducerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerConfig.class);

    @Resource
    private ProducerParam producerParam ;

    private final Lock lock = new ReentrantLock();
    private ConcurrentHashMap<String, DefaultMQProducer> producerMap = new ConcurrentHashMap<>();

    @PreDestroy
    public void destroy() {
        if (this.producerMap.size() != 0) {
            Enumeration<String> keys = producerMap.keys() ;
            while (keys.hasMoreElements()){
                this.producerMap.get(keys.nextElement()).shutdown();
            }
        }
    }

    private DefaultMQProducer getProducerMap(String groupName) {
        if (this.producerMap.containsKey(groupName)) {
            return this.producerMap.get(groupName);
        } else {
            this.lock.lock();
            DefaultMQProducer producer = new DefaultMQProducer();
            try {
                producer.setNamesrvAddr(producerParam.getServerPort());
                producer.setProducerGroup(groupName);
                producer.setRetryTimesWhenSendFailed(3);
                producer.setSendMsgTimeout(10000);
                producer.setVipChannelEnabled(false);
                producer.start();
                this.producerMap.put(groupName, producer);
            } catch (Exception e) {
                e.printStackTrace() ;
            } finally {
                this.lock.unlock();
            }
            return producer ;
        }
    }

    public void sendMsg(String group, String topic, String tag, Object content) {
        try {
            if (content != null) {
                DefaultMQProducer producer = this.getProducerMap(group);
                Message message = new Message(topic, tag, UUID.randomUUID().toString(), String.valueOf(content).getBytes());
                SendResult sendResult = producer.send(message);
                if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
                    LOGGER.debug("message:" + message.getKeys() + " send success.");
                } else {
                    LOGGER.warn("message:" + message.getKeys()+"status:"+sendResult.getSendStatus());
                }
            }
        } catch (Exception e) {
            LOGGER.warn("message send fail :" + e.getMessage());
            e.printStackTrace();
        }
    }
}
