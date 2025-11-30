package com.wyzy.hospital.app.service;

import com.wyzy.hospital.app.api.entity.ElasticEntity;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Collection;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/18  10:19
 * @Function:
 */
public interface ElasticsearchHighLevelService {
	/**
	 * 创建索引
	 * @param idxName 索引名称
	 * @param idxSQL  索引描述 properties
	 * @return
	 */
	boolean createIndex(String idxName,String idxSQL);


	boolean indexExist(String idxName) throws Exception;



	void buildSetting(CreateIndexRequest request);

	void insertOrUpdateOne(String idxName, ElasticEntity entity);

	void deleteOne(String idxName, ElasticEntity entity);

	void insertBatch(String idxName, List<ElasticEntity> list);


	<T> void deleteBatch(String idxName, Collection<T> idList);


	<T> List<T> search(String idxName, SearchSourceBuilder builder, Class<T> c);

	void deleteIndex(String idxName);


	void deleteByQuery(String idxName, QueryBuilder builder);
}
