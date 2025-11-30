

package com.wyzy.hospital.integration.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.integration.dto.BpBpactivityDTO;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpBpactivity;

/**
 * 积分活动表
 *
 * @author hospital code generator
 * @date 2021-05-08 16:09:33
 */
public interface BpBpactivityService extends IService<BpBpactivity> {

	/**
	 * 通过id删除积分活动表
	 * @param id id
	 * @return R
	 */
	boolean removeById(Long id);

	/**
	 * 上线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	boolean OnlineById(Long id);

	/**
	 * 下线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	boolean OfflineById(Long id);

	/**
	 * 分页查询
	 * @return
	 */
	IPage<BpBpactivityDTO> getBpBpactivityPage(IPage<BpBpactivityDTO> page);
}
