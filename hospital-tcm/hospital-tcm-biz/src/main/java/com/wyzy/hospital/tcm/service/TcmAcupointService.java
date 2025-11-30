

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmAcupointDTO;
import com.wyzy.hospital.tcm.entity.TcmAcupoint;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;

import java.util.List;

/**
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
public interface TcmAcupointService extends IService<TcmAcupoint> {

	/**
	 * 查询经络腧穴:两级分类及数据表，三层
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return R
	 */
	List<TcmSortListVO> getAcupointTcmSortListAPP();

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	IPage<TcmAcupointDTO> pageTcmAcupointDTO(IPage<TcmAcupointDTO> page);

	/**
	 * 根据经络ID查询经脉数据表是否存在值
	 * @param sortId
	 * @return
	 */
	List<TcmAcupointDTO> getByContextId(Long sortId);

	/**
	 * 通过id查询穴位表
	 * @param acupointId id
	 * @return R
	 */
	TcmAcupointDTO getById(Long acupointId);

	/**
	 * 通过name查询穴位DTO
	 * @param name id
	 * @return R
	 */
	TcmAcupointDTO getTcmAcupointDTOByName(String name);

	/**
	 * 新增穴位表
	 * @param tcmAcupoint 穴位表
	 * @return R
	 */
	boolean saveTcmAcupoint(TcmAcupoint tcmAcupoint);

	/**
	 * 下线/上线疾病详情
	 * @param
	 */
	boolean goOnlineById(Long acupointId, Integer isOnline);

	/**
	 * 修改穴位表
	 * @param tcmAcupoint 穴位表
	 */
	boolean updateTcmAcupointById(TcmAcupoint tcmAcupoint);

}
