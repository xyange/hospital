
package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.SysDicItem;
import com.wyzy.hospital.common.core.util.R;

/**
 * 字典项
 *
 * @author wyzy
 * @date 2019/03/19
 */
public interface SysDicItemService extends IService<SysDicItem> {

	/**
	 * 删除字典项
	 * @param id 字典项ID
	 * @return
	 */
	R removeDicItem(Integer id);

	/**
	 * 更新字典项
	 * @param item 字典项
	 * @return
	 */
	R updateDicItem(SysDicItem item);

	/**
	 * 查询医生类型
	 * @return
	 */
    R getAllDoctorType();

	/**
	 * 查询所有诊疗模式-远程会诊
	 * @return
	 */
	R getAllConsultationType();
}
