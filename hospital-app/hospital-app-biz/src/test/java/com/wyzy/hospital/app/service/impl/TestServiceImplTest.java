package com.wyzy.hospital.app.service.impl;

import com.wyzy.hospital.app.BaseTest;
import com.wyzy.hospital.app.api.entity.News;
import com.wyzy.hospital.common.core.jackson.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/18  11:05
 * @Function:
 */
@Slf4j
class TestServiceImplTest extends BaseTest {
	private String index;


	private String id;

	@Autowired
	private RestHighLevelClient rhlClient;

	@BeforeEach
	public void prepare() {
		index = "news";
		id = "yCJYfnkB9AJVTbK_R1OD";
	}

	/**
	 * 1.批量添加数据
	 */
	@Test
	public void batchAddTest() {
		BulkRequest bulkRequest = new BulkRequest();
		List<IndexRequest> requests = generateRequests();
		for (IndexRequest indexRequest : requests) {
			bulkRequest.add(indexRequest);
		}
		try {
			rhlClient.bulk(bulkRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<IndexRequest> generateRequests(){
		List<IndexRequest> requests = new ArrayList<>();
		requests.add(generateNewsRequest(1L,"中印边防军于拉达克举行会晤 强调维护边境和平", "军事", "2018-01-27T08:34:00Z"));
		requests.add(generateNewsRequest(2L, "费德勒收郑泫退赛礼 进决赛战西里奇", "体育", "2018-01-26T14:34:00Z"));
		requests.add(generateNewsRequest(3L,"欧文否认拿动手术威胁骑士 兴奋全明星联手詹皇", "体育", "2018-01-26T08:34:00Z"));
		requests.add(generateNewsRequest(4L, "皇马官方通告拉莫斯伊斯科伤情 将缺阵西甲关键战", "体育", "2018-01-26T20:34:00Z"));
		return requests;
	}

	public IndexRequest generateNewsRequest(Long id, String title, String tag, String publishTime){
		IndexRequest indexRequest = new IndexRequest(index);
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setTag(tag);
		news.setPublishTime(publishTime);
		String source = JsonUtil.toJson(news);
		indexRequest.source(source, XContentType.JSON);
		return indexRequest;
	}

	/**
	 * 2. 删除文档
	 */
	@Test
	public void delete(){
		DeleteRequest deleteRequest = new DeleteRequest(index,id);
		DeleteResponse response = null;
		try {
			response = rhlClient.delete(deleteRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("delete {}", response);
	}

	/**
	 * 3. 查询文档
	 */
	@Test
	public void queryTest(){
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.from(0);
		sourceBuilder.size(10);
		//sourceBuilder.fetchSource(new String[]{"title"}, new String[]{});

		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "费德勒");
		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("tag", "网球");
		RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("publishTime");
		rangeQueryBuilder.gte("2018-01-26T08:00:00Z");
		rangeQueryBuilder.lte("2018-01-26T20:00:00Z");

		BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
		boolBuilder.must(matchQueryBuilder);
		boolBuilder.filter(termQueryBuilder);
		boolBuilder.filter(rangeQueryBuilder);
		sourceBuilder.query(boolBuilder);

		SearchRequest searchRequest = new SearchRequest(index);
		searchRequest.source(sourceBuilder);
		try {
			SearchResponse response = rhlClient.search(searchRequest, RequestOptions.DEFAULT);
			log.info("search {}", response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}