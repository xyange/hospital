

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmCmDTO;
import com.wyzy.hospital.tcm.entity.TcmCm;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;

import java.util.List;

/**
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
public interface TcmCmService extends IService<TcmCm> {

	/**
	 *
	 * 通过二级中药分类secondlevelId查询中药表
	 * @param sortId id
	 * @return R
	 */
	List<TcmCmDTO> getAllBySecondlevelId(Long sortId);

	/**
	 * 通过Id查询中药表,
	 * @param --onelevelId id
	 * @return R
	 */
	TcmCmDTO getById(Long id);

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --tcmCm 中药表
	 * @return
	 */
	IPage<TcmCmDTO> getTcmCmPage(IPage<TcmCmDTO> page);

	boolean saveTcmCm(TcmCm tcmCm);

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	boolean goOnlineById(Long id, Integer isOnline);

	/**
	 * 修改中药表
	 * @param tcmCm 中药表
	 * @return R
	 */
	boolean updateTcmCmById(TcmCm tcmCm);

	/**
	 * 通过name查询中药DTO
	 * @param name id
	 * @return R
	 */
	TcmCmDTO selectTcmCmDTOByName(String name);

	/**
	 * 查询加一二级ID
	 * @param
	 * @return
	 */
	List<TcmCmDTO> selectCmOneTwoId();
}
