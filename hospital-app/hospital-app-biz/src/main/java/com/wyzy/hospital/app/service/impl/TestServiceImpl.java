package com.wyzy.hospital.app.service.impl;

import com.wyzy.hospital.app.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author aqie
 * Date on 2021/5/18  11:03
 * @Function:
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private RestHighLevelClient rhlClient;
	private String index = "posts";
	private String docId = "1";
	@Autowired
	private RestHighLevelClient client;

	@Override
	public void createIndex() throws IOException {
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("user", "kimchy");
		jsonMap.put("postDate", new Date());
		jsonMap.put("message", "trying out Elasticsearch");
		IndexRequest indexRequest = new IndexRequest(index)
				.id(docId).source(jsonMap);
		try {
			IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
			log.info("indexResponse {}", indexResponse);
		} catch(ElasticsearchException e) {
			log.error("ES ERROR", e);
		}

	}

	@Override
	public void deleteIndex() {

	}

	@Override
	public void getDoc() throws IOException {
		GetRequest getRequest = new GetRequest(
				index,
				docId);
		try {
			GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
			log.info("getResponse {}", getResponse);
		} catch (ElasticsearchException e) {
			if (e.status() == RestStatus.NOT_FOUND) {
				log.info("doc NOT FOUND");
			}
		}
	}

	@Override
	public void delDoc() throws IOException {
		DeleteRequest request = new DeleteRequest(
				index,
				docId);
		DeleteResponse deleteResponse = client.delete(
				request, RequestOptions.DEFAULT);
		log.info("deleteResponse {}", deleteResponse);
		if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {
			log.info("doc NOT FOUND");
		}
	}

	@Override
	public void updateDoc() {
		Map<String, Object> jsonMap = new HashMap<>(2);
		jsonMap.put("updated", new Date());
		jsonMap.put("reason", "daily update");
		UpdateRequest updateRequest = new UpdateRequest("posts",  "1")
				.doc(jsonMap);
		log.info("updateRequest {}", updateRequest);
	}

	@Override
	public void bulkRequest() throws IOException {
		BulkRequest request = new BulkRequest();
		request.add(new DeleteRequest("posts",  "3"));
		request.add(new UpdateRequest("posts",  "2")
				.doc(XContentType.JSON,"other", "test"));
		request.add(new IndexRequest("posts")
				.source(XContentType.JSON,"field", "baz"));
		BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
		log.info("bulkResponse {}", bulkResponse);
	}

	@Override
	public void multiGet() throws IOException {
		MultiGetRequest request = new MultiGetRequest();
		request.add(new MultiGetRequest.Item(
				"index",
				"type",
				"example_id"));
		request.add(new MultiGetRequest.Item("index",  "another_id"));
		request.add(new MultiGetRequest.Item("index",  "with_routing")
				.routing("some_routing"));
		request.add(new MultiGetRequest.Item("index",  "with_parent"));
		request.add(new MultiGetRequest.Item("index",  "with_version")
				.versionType(VersionType.EXTERNAL)
				.version(10123L));
		MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
	}

	@Override
	public void updateByQuery() throws IOException {
		UpdateByQueryRequest request =
				new UpdateByQueryRequest("source1", "source2");
		request.setConflicts("proceed");
		request.setQuery(new TermQueryBuilder("user", "kimchy"));
		request.setSize(10);
		request.setBatchSize(100);
		request.setPipeline("my_pipeline");
		request.setScript(
				new Script(
						ScriptType.INLINE, "painless",
						"if (ctx._source.user == 'kimchy') {ctx._source.likes++;}",
						Collections.emptyMap()));
		// keeps the "search context" alive.
		request.setScroll(TimeValue.timeValueMinutes(10));
		BulkByScrollResponse bulkResponse =
				client.updateByQuery(request, RequestOptions.DEFAULT);
		log.info("bulkResponse {}", bulkResponse);
	}

	@Override
	public void searchRequest() {
		SearchRequest searchRequest = new SearchRequest(index);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
		searchSourceBuilder.from(0);
		searchSourceBuilder.size(5);
		searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
		searchRequest.source(searchSourceBuilder);
	}
}
