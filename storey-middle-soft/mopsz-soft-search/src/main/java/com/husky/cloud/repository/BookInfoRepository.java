package com.husky.cloud.repository;

import com.husky.cloud.entity.EsBookInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookInfoRepository extends ElasticsearchRepository<EsBookInfo,Integer> {

}
