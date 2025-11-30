package com.wyzy.hospital.app.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author aqie
 * Date on 2021/5/18  11:09
 * @Function:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "news")
public class News {
	@Id
	private Long id;
	private String title;
	private String tag;
	private String publishTime;
}
