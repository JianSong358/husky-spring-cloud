package com.husky.cloud.mapper;

import com.husky.cloud.entity.SearchBook;
import com.husky.cloud.entity.SearchBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchBookMapper {
    int countByExample(SearchBookExample example);

    int deleteByExample(SearchBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchBook record);

    int insertSelective(SearchBook record);

    List<SearchBook> selectByExample(SearchBookExample example);

    SearchBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchBook record, @Param("example") SearchBookExample example);

    int updateByExample(@Param("record") SearchBook record, @Param("example") SearchBookExample example);

    int updateByPrimaryKeySelective(SearchBook record);

    int updateByPrimaryKey(SearchBook record);
}