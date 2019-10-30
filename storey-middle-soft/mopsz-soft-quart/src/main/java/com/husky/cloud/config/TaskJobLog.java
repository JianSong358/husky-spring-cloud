package com.husky.cloud.config;

import com.husky.cloud.entity.ScheduleJob;
import com.husky.cloud.entity.ScheduleJobLog;
import com.husky.cloud.service.ScheduleJobLogService;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 定时器执行日志记录
 */
public class TaskJobLog extends QuartzJobBean {

    private static final Logger LOG = LoggerFactory.getLogger(TaskJobLog.class) ;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        ScheduleJob jobBean = (ScheduleJob)context.getMergedJobDataMap().get(ScheduleJob.JOB_PARAM_KEY) ;
        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService)SpringContextUtil.getBean("scheduleJobLogService") ;
        // 定时器日志记录
        ScheduleJobLog logBean = new ScheduleJobLog () ;
        logBean.setJobId(jobBean.getId());
        logBean.setBeanName(jobBean.getBeanName());
        logBean.setParams(jobBean.getParams());
        logBean.setCreateTime(new Date());
        long beginTime = System.currentTimeMillis() ;
        try {
            // 加载并执行定时器的 run 方法
            Object target = SpringContextUtil.getBean(jobBean.getBeanName());
            Method method = target.getClass().getDeclaredMethod("run", String.class);
            method.invoke(target, jobBean.getParams());
            long executeTime = System.currentTimeMillis() - beginTime;
            logBean.setTimes((int)executeTime);
            logBean.setStatus((byte)0);
            LOG.info("定时器 === >> "+jobBean.getId()+"执行成功,耗时 === >> " + executeTime);
        } catch (Exception e){
            // 异常信息
            long executeTime = System.currentTimeMillis() - beginTime;
            logBean.setTimes((int)executeTime);
            logBean.setStatus((byte)1);
            logBean.setError(e.getMessage());
        } finally {
            scheduleJobLogService.insert(logBean) ;
        }
    }
}