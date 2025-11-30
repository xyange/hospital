

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.tcm.entity.TcmUsermedicalbook;

import java.util.List;

/**
 * 医书收藏表
 *
 * @author hospital code generator
 * @date 2021-04-30 10:38:12
 */
public interface TcmUsermedicalbookService extends IService<TcmUsermedicalbook> {

	/**
	 * 用户收藏/取消收藏医院
	 * @param userId
	 * @param medicalbookId
	 * @return
	 */
	public int collectMedicalbook(Long userId, Long medicalbookId);

	/**
	 * 用户是否收藏医书
	 * @param medicalbookId
	 * @param userId
	 * @return
	 */
	Integer isCollect(Long medicalbookId, Integer userId);

	List<Long> getByUserId(Long id);
}
