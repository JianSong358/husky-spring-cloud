package com.husky.cloud.service.impl;

import com.google.common.collect.Lists;
import com.husky.cloud.entity.EsBookInfo;
import com.husky.cloud.repository.BookInfoRepository;
import com.husky.cloud.service.BookInfoEsService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoEsServiceImpl implements BookInfoEsService {

    @Resource
    private BookInfoRepository bookInfoRepository ;

    @Override
    public void batchSave(List<EsBookInfo> bookInfoList) {
        bookInfoRepository.saveAll(bookInfoList) ;
    }

    @Override
    public List<EsBookInfo> queryList() {
        Iterable<EsBookInfo> bookInfoIterable = bookInfoRepository.findAll() ;
        List<EsBookInfo> esBookInfoList = Lists.newArrayList(bookInfoIterable) ;
        if (esBookInfoList == null){
            esBookInfoList = new ArrayList<>() ;
        }
        return esBookInfoList;
    }

    @Override
    public List<EsBookInfo> getByKeyWord(String keyWord) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(keyWord);
        Iterable<EsBookInfo> bookInfoIterable = bookInfoRepository.search(builder) ;
        List<EsBookInfo> esBookInfoList = Lists.newArrayList(bookInfoIterable) ;
        if (esBookInfoList == null){
            esBookInfoList = new ArrayList<>() ;
        }
        return esBookInfoList ;
    }
}
