package com.husky.cloud.model;

import com.husky.cloud.entity.EsBookInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 关键词检索 Model
 */
public class KeySearchModel implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private Integer userId ;
    /**
     * 搜索关键词
     */
    private String keyWord ;
    /**
     * 搜索结果
     */
    private List<EsBookInfo> searchResult ;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<EsBookInfo> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<EsBookInfo> searchResult) {
        this.searchResult = searchResult;
    }
}
