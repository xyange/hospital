

package com.wyzy.hospital.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.app.api.dto.AppEbookDTO;
import com.wyzy.hospital.app.api.dto.EbookDTO;
import com.wyzy.hospital.app.api.entity.Book;

/**
 * 电子书
 *
 * @author aqie
 * @date 2021-05-25 16:09:00
 */
public interface BookService extends IService<Book> {
	/**
	 * 保存电子书
	 * @param ebookDTO
	 * @return
	 */
	boolean save(EbookDTO ebookDTO);

	/**
	 * 获取电子书详情
	 * @param id
	 * @return
	 */
	EbookDTO detail(Long id);

	/**
	 * 根据 图书id 删除图书
	 * @param id
	 * @return
	 */
	boolean deleteEbookById(Long id);

	/**
	 * 通过id 查询bookId
	 * @param id
	 * @return
	 */
	Book getBookIdById(Long id);

	IPage<AppEbookDTO> bookPage(IPage<AppEbookDTO> page, AppEbookDTO book);

	boolean increaseView(Long bookId);
}
