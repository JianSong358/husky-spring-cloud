package com.husky.cloud.service.Impl;

import com.husky.cloud.entity.*;
import com.husky.cloud.mapper.SearchBookMapper;
import com.husky.cloud.mapper.SearchKeyWordMapper;
import com.husky.cloud.mapper.SearchMatchDegreeMapper;
import com.husky.cloud.model.KeySearchModel;
import com.husky.cloud.service.BookEsDataService;
import com.husky.cloud.util.common.JsonUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BookEsDataServiceImpl implements BookEsDataService {

    @Resource
    private SearchBookMapper searchBookMapper ;
    @Resource
    private SearchMatchDegreeMapper searchMatchDegreeMapper ;
    @Resource
    private SearchKeyWordMapper searchKeyWordMapper ;

    @Override
    public void saveBookEsData(String esData) {
        KeySearchModel keySearchModel = JsonUtil.jsonToObj(esData, KeySearchModel.class) ;
        if (keySearchModel != null){
            Integer userId = keySearchModel.getUserId() ;
            String keyWord = keySearchModel.getKeyWord() ;
            List<EsBookInfo> esBookInfoList = keySearchModel.getSearchResult() ;

            SearchMatchDegree searchMatchDegree = new SearchMatchDegree() ;
            searchMatchDegree.setUserId(userId);
            searchMatchDegree.setKeyWord(keyWord);
            searchMatchDegree.setBookId(esBookInfoList.get(0).getId());
            searchMatchDegree.setCreateTime(new Date());
            searchMatchDegreeMapper.insert(searchMatchDegree) ;

            SearchKeyWordExample searchKeyWordExample = new SearchKeyWordExample() ;
            searchKeyWordExample.createCriteria().andUserIdEqualTo(userId).andKeyWordEqualTo(keyWord) ;
            List<SearchKeyWord> searchKeyWordList = searchKeyWordMapper.selectByExample(searchKeyWordExample) ;
            if (searchKeyWordList != null && searchKeyWordList.size()>0){
                SearchKeyWord searchKeyWord = searchKeyWordList.get(0) ;
                searchKeyWord.setSearchNum(searchKeyWord.getSearchNum()+1);
                searchKeyWordMapper.updateByPrimaryKeySelective(searchKeyWord) ;
            } else {
                SearchKeyWord searchKeyWord = new SearchKeyWord() ;
                searchKeyWord.setUserId(userId) ;
                searchKeyWord.setKeyWord(keyWord) ;
                searchKeyWord.setSearchNum(1) ;
                searchKeyWordMapper.insert(searchKeyWord) ;
            }

            for (EsBookInfo bookInfo : esBookInfoList){
                SearchBook searchBook = new SearchBook() ;
                searchBook.setUserId(userId);
                searchBook.setBookId(bookInfo.getId());
                searchBook.setBookName(bookInfo.getBookName());
                searchBook.setSearchTime(new Date());
                searchBookMapper.insert(searchBook) ;
            }

        }
    }
}
