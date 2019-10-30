package com.husky.cloud.schedule;

import com.husky.cloud.service.SendEmailFeign;
import com.husky.cloud.util.common.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;

@Component("SendMsgJob")
public class SendMsgJob implements TaskJobService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMsgJob.class) ;

    @Resource
    private SendEmailFeign sendEmailFeign ;

    @Override
    public void run(String param) {
        String nowDate = TimeUtil.formatDate(new Date(),TimeUtil.FORMAT_01) ;
        LOGGER.info("SendMsgJob Execute Time：{}",nowDate);
        sendEmailFeign.sendEmail("xxxxxx@qq.com","定时邮件通知","定时任务执行时间："+nowDate);
    }

}
