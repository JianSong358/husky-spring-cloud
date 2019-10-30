package com.husky.cloud.controller;

import com.husky.cloud.service.SendMsgService;
import com.husky.cloud.service.UserSearchFeign;
import com.husky.cloud.util.rocket.MsgRoute;
import com.husky.cloud.util.rocket.MsgWrap;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class UserSearchController implements UserSearchFeign {

    @Resource
    private SendMsgService sendMsgService ;

    @Override
    public void sendBookSearch(String msgContent) {
        MsgWrap msgWrap = new MsgWrap() ;
        msgWrap.setContent(msgContent);
        msgWrap.setGroup(MsgRoute.husky_group_1);
        msgWrap.setTopic(MsgRoute.husky_topic_1);
        msgWrap.setTag(MsgRoute.husky_tag_1);
        sendMsgService.sendMsg(msgWrap);
    }
}
