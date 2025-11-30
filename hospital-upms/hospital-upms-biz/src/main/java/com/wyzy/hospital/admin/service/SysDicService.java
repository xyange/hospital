
package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.SysDicDTO;
import com.wyzy.hospital.admin.api.entity.SysDic;
import com.wyzy.hospital.common.core.util.R;

import java.util.List;

/**
 * 字典表
 *
 * @author wyzy
 * @date 2019/03/19
 */
public interface SysDicService extends IService<SysDic> {

	/**
	 * 根据ID 删除字典
	 * @param id
	 * @return
	 */
	R removeDic(Integer id);

	/**
	 * 更新字典
	 * @param sysDic 字典
	 * @return
	 */
	R updateDic(SysDic sysDic);

	List<SysDicDTO> getAllDoctorType();
	/**
	* @Description: 查询所有诊疗模式-远程会诊
	* @Param: []
	* @return: java.util.List<com.wyzy.hospital.admin.api.dto.SysDicDTO>
	* @Author: songM
	* @Date: 2021/6/15
	*/
	List<SysDicDTO> getAllConsultationType();
}
