package com.husky.cloud.service;

import com.husky.cloud.entity.EsBookInfo;
import java.util.List;

public interface BookInfoEsService {
    // 批量写入
    void batchSave (List<EsBookInfo> bookInfoList) ;
    // 查询全部
    List<EsBookInfo> queryList () ;
    // 关键词检索
    List<EsBookInfo> getByKeyWord (String keyWord) ;
}
