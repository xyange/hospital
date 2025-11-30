package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmMeridiansDTO;
import com.wyzy.hospital.tcm.entity.TcmMeridians;

import java.util.List;

/**
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
public interface TcmMeridiansService extends IService<TcmMeridians> {

	/**
	 * 通过经络contextId查询经脉表信息
	 * @param --contextId id
	 * @return R
	 */
	TcmMeridiansDTO getBycontextId(Long contextId,String meridiansName);

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param --tcmMeridians 经脉表
	 * @return
	 */
	IPage<TcmMeridians> getTcmMeridiansPage(IPage<TcmMeridians> page);

	/**
	 * 新增经脉表
	 * @param tcmMeridians 经脉表
	 * @return R
	 */
	boolean saveTcmMeridians(TcmMeridians tcmMeridians);

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	boolean goOnlineById(Long meridiansId, Integer isOnline);

	/**
	 * 根据ID查询经脉表信息
	 * @param meridiansId
	 * @return
	 */
	TcmMeridiansDTO getById(Long meridiansId);

	/**
	 * 修改经脉表
	 * @param tcmMeridians 经脉表
	 * @return R
	 */
	boolean updatePojoById(TcmMeridians tcmMeridians);

	/**
	 * 通过name查询经脉表DTO
	 * @param name name
	 * @return R
	 */
	TcmMeridiansDTO selectTcmMeridiansDTOByName(String name);
}
