package com.wyzy.hospital.app.kit;

import com.wyzy.hospital.app.api.dto.CategoryTreeDTO;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/27  8:42
 * @Function:
 */
public interface CategoryKitService {
	/**
	 * 流实现无限极分类
	 * @param pid
	 * @return
	 */
	List<CategoryTreeDTO> getInfiniteCategoryListLambda(Long pid, Integer type);
}
