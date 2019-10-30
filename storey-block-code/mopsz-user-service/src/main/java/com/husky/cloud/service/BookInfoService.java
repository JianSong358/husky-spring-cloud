package com.husky.cloud.service;

import com.husky.cloud.entity.BookInfo;

import java.util.List;

public interface BookInfoService {
    // 批量入库
    void batchSave (List<BookInfo> bookInfoList) ;
}
