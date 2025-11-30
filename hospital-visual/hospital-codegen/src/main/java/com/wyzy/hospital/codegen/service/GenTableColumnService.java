

package com.wyzy.hospital.codegen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.codegen.entity.ColumnEntity;
import com.wyzy.hospital.codegen.entity.GenConfig;

/**
 * 表字段管理
 *
 * @author wyzy
 * @date 2020-05-18
 */
public interface GenTableColumnService {

	/**
	 * 查询表的字段信息
	 * @param page
	 * @param genConfig 查询条件
	 * @return
	 */
	IPage<ColumnEntity> listTable(Page page, GenConfig genConfig);

}
