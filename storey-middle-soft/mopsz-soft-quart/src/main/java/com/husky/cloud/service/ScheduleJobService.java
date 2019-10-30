package com.husky.cloud.service;

import com.husky.cloud.entity.ScheduleJob;
import com.husky.cloud.entity.ScheduleJobExample;

import java.util.List;

public interface ScheduleJobService {
    // 主键查询
    ScheduleJob selectByPrimaryKey(Long jobId);
    // 列表查询
    List<ScheduleJob> selectByExample(ScheduleJobExample example);
    // 保存
    void insert(ScheduleJob record);
    // 更新
    int updateByPrimaryKeySelective(ScheduleJob record);
    // 创建
    void createJob (ScheduleJob record) ;
    // 停止
    void pauseJob(Long jobId) ;
    // 恢复
    void resumeJob(Long jobId) ;
    // 执行
    void run(Long jobId) ;
    // 删除
    void delete(Long jobId) ;
}
