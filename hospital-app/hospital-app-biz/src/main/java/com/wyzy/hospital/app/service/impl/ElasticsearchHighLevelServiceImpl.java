package com.wyzy.hospital.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.wyzy.hospital.app.api.entity.ElasticEntity;
import com.wyzy.hospital.app.service.ElasticsearchHighLevelService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/18  10:19
 * @Function:
 */
@Service
@Slf4j
public class ElasticsearchHighLevelServiceImpl implements ElasticsearchHighLevelService {
	@Autowired
	RestHighLevelClient restHighLevelClient;

	/**
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:30
	 * @param idxName   索引名称
	 * @param idxSQL    索引描述
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public boolean createIndex(String idxName, String idxSQL){
		try {
			if (this.indexExist(idxName)) {
				log.error(" idxName={} 已经存在,idxSql={}",idxName,idxSQL);
				return false;
			}
			CreateIndexRequest request = new CreateIndexRequest(idxName);
			buildSetting(request);
			request.mapping(idxSQL, XContentType.JSON);
			// request.settings(); // 手工指定Setting
			CreateIndexResponse res = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
			if (!res.isAcknowledged()) {
				throw new RuntimeException("初始化失败");
			}
			return true;
		} catch (Exception e) {
			log.error("ERROR", e);
			return false;
		}
	}

	/** 断某个index是否存在
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:27
	 * @param idxName index名
	 * @return boolean
	 * @throws
	 * @since
	 */
	@Override
	public boolean indexExist(String idxName) throws Exception {
		GetIndexRequest request = new GetIndexRequest(idxName);
		request.local(false);
		request.humanReadable(true);
		request.includeDefaults(false);
		// request.indicesOptions(IndicesOptions.lenientExpandOpen());
		return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
	}



	/** 设置分片
	 * @author aqie
	 * @See
	 * @date 2019/10/17 19:27
	 * @param request
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public void buildSetting(CreateIndexRequest request){
		request.settings(Settings.builder().put("index.number_of_shards",3)
				.put("index.number_of_replicas",2));
	}
	/**
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:27
	 * @param idxName index
	 * @param entity    对象
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public void insertOrUpdateOne(String idxName, ElasticEntity entity) {
		IndexRequest request = new IndexRequest(idxName);
		log.error("Data : id={},entity={}",entity.getId(), JSON.toJSONString(entity.getData()));
		request.id(entity.getId());
		request.source(entity.getData(), XContentType.JSON);
//        request.source(JSON.toJSONString(entity.getData()), XContentType.JSON);
		try {
			restHighLevelClient.index(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteOne(String idxName, ElasticEntity entity) {
		DeleteRequest request = new DeleteRequest(idxName);
		request.id(entity.getId());
		try {
			restHighLevelClient.delete(request,RequestOptions.DEFAULT);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}

	/** 批量插入数据
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:26
	 * @param idxName index
	 * @param list 带插入列表
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public void insertBatch(String idxName, List<ElasticEntity> list) {
		BulkRequest request = new BulkRequest();
		list.forEach(item -> request.add(new IndexRequest(idxName).id(item.getId())
				.source(item.getData(), XContentType.JSON)));
		try {
			restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}


	/** 批量删除
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:14
	 * @param idxName index
	 * @param idList    待删除列表
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public <T> void deleteBatch(String idxName, Collection<T> idList) {
		BulkRequest request = new BulkRequest();
		idList.forEach(item -> request.add(new DeleteRequest(idxName, "_doc", item.toString())));
		try {
			restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:14
	 * @param idxName index
	 * @param builder   查询参数
	 * @param c 结果类对象
	 * @return java.util.List<T>
	 * @throws
	 * @since
	 */
	@Override
	public <T> List<T> search(String idxName, SearchSourceBuilder builder, Class<T> c) {
		SearchRequest request = new SearchRequest(idxName);
		request.source(builder);
		try {
			SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
			SearchHit[] hits = response.getHits().getHits();
			List<T> res = new ArrayList<>(hits.length);
			for (SearchHit hit : hits) {
				res.add(JSON.parseObject(hit.getSourceAsString(), c));
			}
			return res;
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}

	/** 删除index
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:13
	 * @param idxName
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public void deleteIndex(String idxName) {
		try {
			if (!this.indexExist(idxName)) {
				log.error(" idxName={} 已经存在",idxName);
				return;
			}
			restHighLevelClient.indices().delete(new DeleteIndexRequest(idxName), RequestOptions.DEFAULT);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}


	/**
	 * @author aqie
	 * @See
	 * @date 2019/10/17 17:13
	 * @param idxName
	 * @param builder
	 * @return void
	 * @throws
	 * @since
	 */
	@Override
	public void deleteByQuery(String idxName, QueryBuilder builder) {

		DeleteByQueryRequest request = new DeleteByQueryRequest(idxName);
		request.setQuery(builder);
		//设置批量操作数量,最大为10000
		request.setBatchSize(10000);
		request.setConflicts("proceed");
		try {
			restHighLevelClient.deleteByQuery(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}
}
