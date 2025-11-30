

package com.wyzy.hospital.app.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.app.api.dto.AppEbookDTO;
import com.wyzy.hospital.app.api.entity.Book;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 电子书
 *
 * @author aqie
 * @date 2021-05-25 16:09:00
 */
@Mapper
public interface BookMapper extends HospitalBaseMapper<Book> {

	/**
	 * app 电子书列表
	 * @param page
	 * @param book
	 * @return
	 */
    IPage<AppEbookDTO> bookPage(IPage<AppEbookDTO> page, @Param("book") AppEbookDTO book);

	/**
	 * 增加电子书阅读量
	 * @param id
	 * @return
	 */
	@Update("update epub_book set views=views+1 where id=#{id}")
	boolean increaseView(Long id);
}
