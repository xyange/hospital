
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.SysDicDTO;
import com.wyzy.hospital.admin.api.entity.SysDic;
import com.wyzy.hospital.admin.api.entity.SysDicItem;
import com.wyzy.hospital.admin.mapper.SysDicItemMapper;
import com.wyzy.hospital.admin.service.SysDicItemService;
import com.wyzy.hospital.admin.service.SysDicService;
import com.wyzy.hospital.common.core.constant.CacheConstants;
import com.wyzy.hospital.common.core.constant.enums.DicTypeEnum;
import com.wyzy.hospital.common.core.util.R;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典项
 *
 * @author wyzy
 * @date 2019/03/19
 */
@Service
@AllArgsConstructor
public class SysDicItemServiceImpl extends ServiceImpl<SysDicItemMapper, SysDicItem> implements SysDicItemService {

	private final SysDicService dicService;

	/**
	 * 删除字典项
	 * @param id 字典项ID
	 * @return
	 */
	@Override
	@CacheEvict(value = CacheConstants.DIC_DETAILS, allEntries = true)
	public R removeDicItem(Integer id) {
		// 根据ID查询字典ID
		SysDicItem dicItem = this.getById(id);
		SysDic dic = dicService.getById(dicItem.getDicId());
		// 系统内置
		if (DicTypeEnum.SYSTEM.getType().equals(dic.getSystem())) {
			return R.failed("系统内置字典项目不能删除");
		}
		return R.ok(this.removeById(id));
	}

	/**
	 * 更新字典项
	 * @param item 字典项
	 * @return
	 */
	@Override
	@CacheEvict(value = CacheConstants.DIC_DETAILS, allEntries = true)
	public R updateDicItem(SysDicItem item) {
		// 查询字典
		SysDic dict = dicService.getById(item.getDicId());
		// 系统内置
		if (DicTypeEnum.SYSTEM.getType().equals(dict.getSystem())) {
			return R.failed("系统内置字典项目不能删除");
		}
		return R.ok(this.updateById(item));
	}

	/**
	 * 查询医生类型
	 * @return
	 */
	@Override
	public R getAllDoctorType() {
		List<SysDicDTO> sysDicDTOList = dicService.getAllDoctorType();
		return R.ok(sysDicDTOList,"查询成功");
	}

	/**
	* @Description: 查询诊疗模式
	* @Param: []
	* @return: com.wyzy.hospital.common.core.util.R
	* @Author: songM
	* @Date: 2021/6/15
	*/
	@Override
	public R getAllConsultationType() {
		List<SysDicDTO> sysDicDTOList = dicService.getAllConsultationType();
		return R.ok(sysDicDTOList,"查询成功");
	}
}
