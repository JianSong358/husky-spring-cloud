package com.husky.cloud.controller;

import com.husky.cloud.entity.BookInfo;
import com.husky.cloud.entity.EsBookInfo;
import com.husky.cloud.service.BookInfoEsFeign;
import com.husky.cloud.service.BookInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 搜索数据入库
 */
@RestController
@RequestMapping("/search/data")
public class SearchDataController {

    @Resource
    private BookInfoEsFeign bookInfoEsFeign ;
    @Resource
    private BookInfoService bookInfoService ;

    @RequestMapping("/batchSave")
    public String batchSave (){
        // 搜索引擎数据
        List<EsBookInfo> esBookInfoList = new ArrayList<>() ;
        // 数据库参考数据
        List<BookInfo> bookInfoList = new ArrayList<>() ;

        EsBookInfo esBookInfo1 = new EsBookInfo() ;
        esBookInfo1.setId(1);
        esBookInfo1.setBookName("Java编程思想");
        esBookInfo1.setBookAuthor("Bruce Eckel");
        esBookInfo1.setBookDesc("恕我直言，这是一本学习Java的理想书籍");
        esBookInfo1.setBookPress("机械工业出版社");
        esBookInfo1.setCreateTime(new Date());
        esBookInfo1.setUpdateTime(esBookInfo1.getCreateTime());

        EsBookInfo esBookInfo2 = new EsBookInfo() ;
        esBookInfo2.setId(2);
        esBookInfo2.setBookName("高性能MySQL");
        esBookInfo2.setBookAuthor("Baron 王小东");
        esBookInfo2.setBookDesc("每一章的内容自成体系，适合各领域技术人员作选择性的阅读。\n");
        esBookInfo2.setBookPress("电子工业出版社");
        esBookInfo2.setCreateTime(new Date());
        esBookInfo2.setUpdateTime(esBookInfo2.getCreateTime());

        esBookInfoList.add(esBookInfo1) ;
        esBookInfoList.add(esBookInfo2) ;

        BookInfo bookInfo1 = new BookInfo() ;
        BeanUtils.copyProperties(esBookInfo1,bookInfo1);
        BookInfo bookInfo2 = new BookInfo() ;
        BeanUtils.copyProperties(esBookInfo2,bookInfo2);

        bookInfoList.add(bookInfo1) ;
        bookInfoList.add(bookInfo2) ;

        bookInfoEsFeign.batchSave(esBookInfoList);
        bookInfoService.batchSave(bookInfoList);
        return "success" ;
    }

    /**
     * 查询搜索引擎中数据
     */
    @RequestMapping("/queryList")
    public List<EsBookInfo> queryList () {
        return bookInfoEsFeign.queryList() ;
    }
}
