

package com.wyzy.hospital.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.app.api.entity.Chapter;

import java.util.List;

/**
 * 电子书章节
 *
 * @author aqie
 * @date 2021-05-25 16:08:50
 */
public interface ChapterService extends IService<Chapter> {
	/**
	 * 根据图书id 获取章节列表
	 */
	List<Chapter> getChapterListByBookId(String bookId);

	boolean removeChapterById(String bookId);
}
