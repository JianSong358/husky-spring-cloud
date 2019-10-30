package com.husky.cloud.controller;

import com.husky.cloud.entity.EsBookInfo;
import com.husky.cloud.model.KeySearchModel;
import com.husky.cloud.service.BookInfoEsFeign;
import com.husky.cloud.service.UserSearchFeign;
import com.husky.cloud.util.common.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * 书籍搜索接口
 */
@RestController
@RequestMapping("/search/book/")
public class BookSearchController {

    @Resource
    private BookInfoEsFeign bookInfoEsFeign ;
    @Resource
    private UserSearchFeign userSearchFeign ;
    /**
     * 关键字全文搜索
     */
    @RequestMapping("/getByKeyWord")
    public List<EsBookInfo> getByKeyWord (@RequestParam("keyWord") String keyWord,@RequestParam("userId") Integer userId){
        // 搜索引擎执行
        List<EsBookInfo> esBookInfoList = bookInfoEsFeign.getByKeyWord(keyWord) ;
        // 执行异步分析
        if (StringUtils.isNotEmpty(keyWord) && esBookInfoList != null){
            KeySearchModel keySearchModel = new KeySearchModel() ;
            keySearchModel.setUserId(userId);
            keySearchModel.setKeyWord(keyWord);
            keySearchModel.setSearchResult(esBookInfoList);
            userSearchFeign.sendBookSearch(JsonUtil.objToJson(keySearchModel));
        }
        return esBookInfoList ;
    }

}
