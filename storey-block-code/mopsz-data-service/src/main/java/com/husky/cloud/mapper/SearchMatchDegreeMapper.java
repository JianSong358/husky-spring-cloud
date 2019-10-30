package com.husky.cloud.mapper;

import com.husky.cloud.entity.SearchMatchDegree;
import com.husky.cloud.entity.SearchMatchDegreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchMatchDegreeMapper {
    int countByExample(SearchMatchDegreeExample example);

    int deleteByExample(SearchMatchDegreeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchMatchDegree record);

    int insertSelective(SearchMatchDegree record);

    List<SearchMatchDegree> selectByExample(SearchMatchDegreeExample example);

    SearchMatchDegree selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchMatchDegree record, @Param("example") SearchMatchDegreeExample example);

    int updateByExample(@Param("record") SearchMatchDegree record, @Param("example") SearchMatchDegreeExample example);

    int updateByPrimaryKeySelective(SearchMatchDegree record);

    int updateByPrimaryKey(SearchMatchDegree record);
}