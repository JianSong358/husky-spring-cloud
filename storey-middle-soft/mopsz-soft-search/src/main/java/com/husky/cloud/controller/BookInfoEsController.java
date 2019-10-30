package com.husky.cloud.controller;

import com.husky.cloud.entity.EsBookInfo;
import com.husky.cloud.service.BookInfoEsFeign;
import com.husky.cloud.service.BookInfoEsService;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookInfoEsController implements BookInfoEsFeign {

    @Resource
    private BookInfoEsService bookInfoEsService ;

    @Override
    public void batchSave(List<EsBookInfo> bookInfoList) {
        bookInfoEsService.batchSave(bookInfoList);
    }

    @Override
    public List<EsBookInfo> queryList() {
        return bookInfoEsService.queryList();
    }

    @Override
    public List<EsBookInfo> getByKeyWord(String keyWord) {
        return bookInfoEsService.getByKeyWord(keyWord);
    }
}
