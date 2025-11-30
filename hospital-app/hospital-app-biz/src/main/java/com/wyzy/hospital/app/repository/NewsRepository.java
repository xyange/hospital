package com.wyzy.hospital.app.repository;

import com.wyzy.hospital.app.api.entity.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



/**
 * @Author aqie
 * Date on 2021/5/18  16:51
 * @Function:
 */
public interface NewsRepository extends ElasticsearchRepository<News,Long> {
}
