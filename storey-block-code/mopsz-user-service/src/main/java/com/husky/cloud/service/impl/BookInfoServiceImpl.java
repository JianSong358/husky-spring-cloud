package com.husky.cloud.service.impl;

import com.husky.cloud.entity.BookInfo;
import com.husky.cloud.mapper.user.BookInfoExtendMapper;
import com.husky.cloud.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Resource
    private BookInfoExtendMapper bookInfoExtendMapper ;

    @Override
    public void batchSave(List<BookInfo> bookInfoList) {
        bookInfoExtendMapper.batchSave(bookInfoList);
    }
}
