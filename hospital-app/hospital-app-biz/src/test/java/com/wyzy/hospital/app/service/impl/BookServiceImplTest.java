package com.wyzy.hospital.app.service.impl;

import com.wyzy.hospital.app.BaseTest;
import com.wyzy.hospital.app.api.entity.Book;
import com.wyzy.hospital.app.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author aqie
 * Date on 2021/5/26  15:35
 * @Function:
 */
@Slf4j
class BookServiceImplTest extends BaseTest {
	@Autowired
	private BookService bookService;

	@Test
	void getBookIdById() {
		Book book = bookService.getBookIdById(1397127977953492993L);
		log.info("book {}", book);
		Assertions.assertNotNull(book);
		Assertions.assertEquals("aqie_1621936241690", book.getBookId());
	}
}