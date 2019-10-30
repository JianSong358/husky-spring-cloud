package com.husky.cloud.controller;

import com.husky.cloud.entity.ScheduleJob;
import com.husky.cloud.service.ScheduleJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;

@RestController
public class TaskJobController {

    @Resource
    private ScheduleJobService scheduleJobService ;

    /**
     * 添加定时器
     */
    @RequestMapping("/insertJob")
    public String insertJob (ScheduleJob scheduleJob){
        scheduleJob.setCreateTime(new Date());
        scheduleJobService.insert(scheduleJob) ;
        scheduleJobService.createJob(scheduleJob) ;
        return "success" ;
    }

    /**
     * 执行一次定时器
     */
    @RequestMapping("/runJob")
    public String runJob (@RequestParam("jobId") Long jobId){
        scheduleJobService.run(jobId);
        return "success" ;
    }

    /**
     * 更新定时器
     */
    @RequestMapping("/updateJob")
    public String updateJob (ScheduleJob scheduleJob){
        scheduleJobService.updateByPrimaryKeySelective(scheduleJob) ;
        return "success" ;
    }

    /**
     * 停止定时器
     */
    @RequestMapping("/pauseJob")
    public String pauseJob (@RequestParam("jobId") Long jobId){
        scheduleJobService.pauseJob(jobId);
        return "success" ;
    }

    /**
     * 恢复定时器
     */
    @RequestMapping("/resumeJob")
    public String resumeJob (@RequestParam("jobId") Long jobId){
        scheduleJobService.resumeJob(jobId);
        return "success" ;
    }

    /**
     * 删除定时器
     */
    @RequestMapping("/deleteJob")
    public String deleteJob (@RequestParam("jobId") Long jobId){
        scheduleJobService.delete(jobId);
        return "success" ;
    }
}
