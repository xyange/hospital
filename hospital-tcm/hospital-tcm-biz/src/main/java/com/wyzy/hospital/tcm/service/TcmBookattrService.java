

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmBookattrDTO;
import com.wyzy.hospital.tcm.entity.TcmBookattr;

import java.util.List;

/**
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
public interface TcmBookattrService extends IService<TcmBookattr> {

	/**
	 * 新增医书属性表
	 * @param tcmBookattr 医书属性表
	 * @return R
	 */
	boolean saveBookattr(TcmBookattr tcmBookattr);

	/**
	 * 分页查询
	 */
	IPage<TcmBookattrDTO> Bookattrpage(Integer type, IPage<TcmBookattrDTO> page);

	/**
	 * 根据type查询
	 * @param type
	 * @return
	 */
	List<TcmBookattrDTO> getTcmBookattrByType(Integer type);

	/**
	 * 查询医书树状列表
	 * @return
	 */
	List getTcmBookattrList();

	/**
	 * 修改医书属性表
	 * @param tcmBookattr 医书属性表
	 * @return R
	 */
	boolean updateTcmBookattrById(TcmBookattr tcmBookattr);

	/**
	 * 通过name查询医书属性表
	 * @param name name
	 * @return R
	 */
	TcmBookattrDTO selectPojoDTOByName(String name);
}
