package com.wyzy.hospital.app.service;

import java.io.IOException;

/**
 * @Author aqie
 * Date on 2021/5/18  11:03
 * @Function:
 */
public interface TestService {
	/**
	 * 1. 创建索引
	 */
	void createIndex() throws IOException;

	/**
	 * 2. 删除索引
	 */
	void deleteIndex();

	/**
	 * 3. 获取doc数据
	 */
	void getDoc() throws IOException;

	/**
	 * 4. 删除doc
	 */
	void delDoc() throws IOException;

	/**
	 * 5. 更新doc
	 */
	void updateDoc();

	/**
	 * 6. 批量操作
	 */
	void bulkRequest() throws IOException;

	/**
	 * 7. 批量获取
	 */
	void multiGet() throws IOException;

	/**
	 * 8.
	 */
	void updateByQuery() throws IOException;

	/**
	 * 9. searchRequest
	 */

	void searchRequest();
}
