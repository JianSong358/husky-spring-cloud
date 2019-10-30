package com.husky.cloud.config.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import java.util.Iterator;
import java.util.List;

public class MsgMonitor implements MessageListenerConcurrently {

    private MsgReadService msgReadService ;
    public MsgMonitor (MsgReadService msgReadService){
        this.msgReadService = msgReadService ;
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
        Iterator iterator = list.iterator();
        try {
            while (iterator.hasNext()) {
                MessageExt messageExt = (MessageExt)iterator.next();
                if (messageExt != null && messageExt.getBody() != null) {
                    this.msgReadService.readMsg(new String(messageExt.getBody(), "UTF-8"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace() ;
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
