package com.husky.cloud.service.impl;

import com.husky.cloud.config.ScheduleUtil;
import com.husky.cloud.entity.ScheduleJob;
import com.husky.cloud.entity.ScheduleJobExample;
import com.husky.cloud.mapper.ScheduleJobMapper;
import com.husky.cloud.service.ScheduleJobService;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Resource
    private Scheduler scheduler ;
    @Resource
    private ScheduleJobMapper scheduleJobMapper ;

    /**
     * 定时器初始化
     */
    @PostConstruct
    public void init (){
        ScheduleJobExample example = new ScheduleJobExample() ;
        List<ScheduleJob> scheduleJobBeanList = scheduleJobMapper.selectByExample(example) ;
        for (ScheduleJob scheduleJobBean : scheduleJobBeanList) {
            CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler,scheduleJobBean.getId()) ;
            if (cronTrigger == null){
                ScheduleUtil.createJob(scheduler,scheduleJobBean);
            } else {
                ScheduleUtil.updateJob(scheduler,scheduleJobBean);
            }
        }
    }

    @Override
    public ScheduleJob selectByPrimaryKey(Long jobId) {
        return scheduleJobMapper.selectByPrimaryKey(jobId);
    }

    @Override
    public List<ScheduleJob> selectByExample(ScheduleJobExample example) {
        return scheduleJobMapper.selectByExample(example);
    }

    public ScheduleJob selectScheduleJob(ScheduleJobExample example) {
        List<ScheduleJob> scheduleJobList = scheduleJobMapper.selectByExample(example);
        if (scheduleJobList != null && scheduleJobList.size()>0){
            return scheduleJobList.get(0) ;
        }
        return null ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ScheduleJob record) {
        scheduleJobMapper.insert(record) ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(ScheduleJob record) {
        ScheduleUtil.updateJob(scheduler,record);
        return scheduleJobMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void createJob(ScheduleJob record) {
        ScheduleJobExample example = new ScheduleJobExample() ;
        example.createCriteria().andBeanNameEqualTo(record.getBeanName()) ;
        ScheduleJob newRecord = selectScheduleJob(example);
        if (newRecord != null){
            ScheduleUtil.createJob(scheduler,record);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pauseJob(Long jobId) {
        ScheduleJob scheduleJobBean = scheduleJobMapper.selectByPrimaryKey(jobId) ;
        ScheduleUtil.pauseJob(scheduler,jobId);
        scheduleJobBean.setStatus((byte)1);
        scheduleJobMapper.updateByPrimaryKeySelective(scheduleJobBean) ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resumeJob(Long jobId) {
        ScheduleJob scheduleJobBean = scheduleJobMapper.selectByPrimaryKey(jobId) ;
        ScheduleUtil.resumeJob(scheduler,jobId);
        scheduleJobBean.setStatus((byte)0);
        scheduleJobMapper.updateByPrimaryKeySelective(scheduleJobBean) ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long jobId) {
        ScheduleJob scheduleJobBean = scheduleJobMapper.selectByPrimaryKey(jobId) ;
        ScheduleUtil.run(scheduler,scheduleJobBean);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long jobId) {
        ScheduleUtil.deleteJob(scheduler, jobId);
        scheduleJobMapper.deleteByPrimaryKey(jobId) ;
    }
}
