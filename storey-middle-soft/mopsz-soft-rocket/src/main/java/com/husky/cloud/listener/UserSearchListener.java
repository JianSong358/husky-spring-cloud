package com.husky.cloud.listener;

import com.husky.cloud.config.consumer.Consumer;
import com.husky.cloud.config.consumer.MsgReadService;
import com.husky.cloud.service.BookEsAnalyFeign;
import com.husky.cloud.util.rocket.MsgRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户搜索消息监听
 */
@Component
@Consumer(group = MsgRoute.husky_group_1,
          topic = MsgRoute.husky_topic_1 ,
          tag = MsgRoute.husky_tag_1)
public class UserSearchListener implements MsgReadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSearchListener.class) ;

    @Resource
    private BookEsAnalyFeign bookEsAnalyFeign ;

    @Override
    public void readMsg(String msg) throws Exception {
        LOGGER.info("【用户搜索消息监听 Msg】：{}",msg) ;
        // 转发请求数据分析服务
        bookEsAnalyFeign.sendBookEsMsg(msg);
    }
}
