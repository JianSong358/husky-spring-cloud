package com.husky.cloud.service;

import com.husky.cloud.entity.ScheduleJobLog;

public interface ScheduleJobLogService {
    // 保存
    int insert(ScheduleJobLog record);
}
