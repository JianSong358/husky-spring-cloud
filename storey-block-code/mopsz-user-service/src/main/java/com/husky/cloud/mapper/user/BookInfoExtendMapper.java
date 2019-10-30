package com.husky.cloud.mapper.user;

import com.husky.cloud.entity.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoExtendMapper {
    void batchSave (@Param("bookInfoList") List<BookInfo> bookInfoList) ;
}