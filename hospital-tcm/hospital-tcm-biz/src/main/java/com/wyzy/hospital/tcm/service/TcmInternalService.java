

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmInternalDTO;
import com.wyzy.hospital.tcm.entity.TcmInternal;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;

import java.util.List;

/**
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
public interface TcmInternalService extends IService<TcmInternal> {

	/**
	 * 通过内科学二级分类IDinternalsuperId查询内科学表
	 * @param --internalsuperId id
	 * @return R
	 */
	List<TcmInternalDTO> getAllByInternalsuperId(Long internalsuperId);

	TcmInternalDTO getById(Long id);

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --tcmInternal 内科学表
	 * @return
	 */
	IPage<TcmInternalDTO> getTcmInternalPage(IPage<TcmInternalDTO> page);

	/**
	 * 新增内科学表
	 * @param tcmInternal 内科学表
	 * @return R
	 */
	boolean saveTcmInternal(TcmInternal tcmInternal);

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	boolean goOnlineById(Long id, Integer isOnline);

	/**
	 * 修改内科学表
	 * @param tcmInternal 内科学表
	 * @return R
	 */
	boolean updatePojoById(TcmInternal tcmInternal);

	/**
	 * 查询加一二级ID
	 * @return
	 */
	List<TcmInternalDTO> selectInternalOneTwoId();

	/**
	 * 通过name查询内科学表DTO
	 * @param name name
	 * @return R
	 */
	TcmInternalDTO selectTcmInternalDTOByName(String name);
}
