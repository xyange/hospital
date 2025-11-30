package com.wyzy.hospital.hospital.config;

import com.wyzy.hospital.common.core.constant.ServerConstants;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author aqie
 * Date on 2021/4/14  8:22
 * @Function:
 */
public class ElasticSearchConfig {
	public static final RequestOptions COMMON_OPTIONS;

	static {
		RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
//        builder.addHeader("Authorization","Bearer" + TOKEN);
//        builder.setHttpAsyncResponseConsumerFactory(
//                new HttpAsyncResponseConsumerFactory.
//                        HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024)
//        );
		COMMON_OPTIONS = builder.build();
	}

	@Bean
	public RestHighLevelClient esRestClient() {

		RestClientBuilder builder = null;

		builder = RestClient.builder(new HttpHost(ServerConstants.ELASTICSEARCH_URL, 9200, "http"));

		RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
		return restHighLevelClient;
	}

}
