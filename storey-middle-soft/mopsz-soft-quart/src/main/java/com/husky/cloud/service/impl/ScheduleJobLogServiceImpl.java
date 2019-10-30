package com.husky.cloud.service.impl;

import com.husky.cloud.entity.ScheduleJobLog;
import com.husky.cloud.mapper.ScheduleJobLogMapper;
import com.husky.cloud.service.ScheduleJobLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

    @Resource
    private ScheduleJobLogMapper scheduleJobLogMapper ;

    @Override
    public int insert(ScheduleJobLog record) {
        return scheduleJobLogMapper.insert(record) ;
    }
}
