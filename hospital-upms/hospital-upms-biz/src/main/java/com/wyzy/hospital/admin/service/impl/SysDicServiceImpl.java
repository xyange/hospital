
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.SysDicDTO;
import com.wyzy.hospital.admin.api.entity.SysDic;
import com.wyzy.hospital.admin.api.entity.SysDicItem;
import com.wyzy.hospital.admin.mapper.SysDicItemMapper;
import com.wyzy.hospital.admin.mapper.SysDicMapper;
import com.wyzy.hospital.admin.service.SysDicService;
import com.wyzy.hospital.common.core.constant.CacheConstants;
import com.wyzy.hospital.common.core.constant.enums.DicTypeEnum;
import com.wyzy.hospital.common.core.util.R;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典表
 *
 * @author wyzy
 * @date 2019/03/19
 */
@Service
@AllArgsConstructor
public class SysDicServiceImpl extends ServiceImpl<SysDicMapper, SysDic> implements SysDicService {

	private final SysDicItemMapper dicItemMapper;

	/**
	 * 根据ID 删除字典
	 * @param id 字典ID
	 * @return
	 */
	@Override
	@CacheEvict(value = CacheConstants.DIC_DETAILS, allEntries = true)
	@Transactional(rollbackFor = Exception.class)
	public R removeDic(Integer id) {
		SysDic dic = this.getById(id);
		// 系统内置
		if (DicTypeEnum.SYSTEM.getType().equals(dic.getSystem())) {
			return R.failed("系统内置字典不能删除");
		}

		baseMapper.deleteById(id);
		dicItemMapper.delete(Wrappers.<SysDicItem>lambdaQuery().eq(SysDicItem::getDicId, id));
		return R.ok();
	}

	/**
	 * 更新字典
	 * @param dic 字典
	 * @return
	 */
	@Override
	public R updateDic(SysDic dic) {
		SysDic sysDic = this.getById(dic.getId());
		// 系统内置
		if (DicTypeEnum.SYSTEM.getType().equals(sysDic.getSystem())) {
			return R.failed("系统内置字典不能修改");
		}
		return R.ok(this.updateById(dic));
	}

	/**
	 * 获取所有
	 * @return
	 */
	@Override
	public List<SysDicDTO> getAllDoctorType() {
		return baseMapper.getAllDoctorType();
	}
	/**
	* @Description: 查询所有诊疗模式-远程会诊
	* @Param: []
	* @return: java.util.List<com.wyzy.hospital.admin.api.dto.SysDicDTO>
	* @Author: songM
	* @Date: 2021/6/15
	*/
	@Override
	public List<SysDicDTO> getAllConsultationType() {
		return baseMapper.getAllConsultationType();
	}
}
