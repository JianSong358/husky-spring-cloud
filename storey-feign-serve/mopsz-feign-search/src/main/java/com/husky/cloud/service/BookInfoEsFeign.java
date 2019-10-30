package com.husky.cloud.service;

import com.husky.cloud.entity.EsBookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient("MOPSZ-SOFT-SEARCH")
public interface BookInfoEsFeign {
    // 批量写入
    @PostMapping("/book/info/batchSave")
    void batchSave (@RequestBody List<EsBookInfo> bookInfoList) ;
    // 查询全部
    @GetMapping("/book/info/queryList")
    List<EsBookInfo> queryList () ;
    // 关键词检索
    @GetMapping("/book/info/getByKeyWord")
    List<EsBookInfo> getByKeyWord (@RequestParam("keyWord") String keyWord) ;
}
