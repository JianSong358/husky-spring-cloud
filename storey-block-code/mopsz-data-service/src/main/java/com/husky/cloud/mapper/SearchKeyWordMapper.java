package com.husky.cloud.mapper;

import com.husky.cloud.entity.SearchKeyWord;
import com.husky.cloud.entity.SearchKeyWordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchKeyWordMapper {
    int countByExample(SearchKeyWordExample example);

    int deleteByExample(SearchKeyWordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchKeyWord record);

    int insertSelective(SearchKeyWord record);

    List<SearchKeyWord> selectByExample(SearchKeyWordExample example);

    SearchKeyWord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchKeyWord record, @Param("example") SearchKeyWordExample example);

    int updateByExample(@Param("record") SearchKeyWord record, @Param("example") SearchKeyWordExample example);

    int updateByPrimaryKeySelective(SearchKeyWord record);

    int updateByPrimaryKey(SearchKeyWord record);
}