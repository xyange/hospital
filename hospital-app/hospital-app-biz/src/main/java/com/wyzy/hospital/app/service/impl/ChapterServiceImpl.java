
package com.wyzy.hospital.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.app.api.entity.Chapter;
import com.wyzy.hospital.app.mapper.ChapterMapper;
import com.wyzy.hospital.app.service.BookService;
import com.wyzy.hospital.app.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 电子书章节
 *
 * @author aqie
 * @date 2021-05-25 16:08:50
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

	@Autowired
	private BookService bookService;
	@Override
	public List<Chapter> getChapterListByBookId(String bookId) {
		return this.list(new LambdaQueryWrapper<Chapter>()
				.select(Chapter::getId, Chapter::getBookId, Chapter::getFileName, Chapter::getText, Chapter::getLabel, Chapter::getPid)
				.eq(Chapter::getBookId, bookId));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean removeChapterById(String bookId) {

		boolean remove = this.remove(new LambdaQueryWrapper<Chapter>().eq(Chapter::getBookId, bookId));
		return remove;
	}
}
