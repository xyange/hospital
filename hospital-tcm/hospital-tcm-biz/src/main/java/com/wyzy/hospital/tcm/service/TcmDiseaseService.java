

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmDiseaseDTO;
import com.wyzy.hospital.tcm.entity.TcmDisease;

import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
public interface TcmDiseaseService extends IService<TcmDisease> {

	/**
	 * 新增疾病表
	 * @param tcmDisease 疾病表
	 * @return R
	 */
	boolean saveTcmDisease(TcmDisease tcmDisease);

	/**
	 * 根据ID查看疾病表详情
	 * @param diseaseId
	 * @return
	 */
	TcmDiseaseDTO getById(Long diseaseId);

	/**
	 * APP分页查询
	 * @return
	 */
	IPage<TcmDiseaseDTO> pageTcmDiseaseAPP(IPage<TcmDiseaseDTO> page);

	/**
	 * 分页查询
	 * @return
	 */
	IPage<TcmDiseaseDTO> pageDisease(IPage<TcmDiseaseDTO> page);

	/**
	 * 上线/下线疾病详情
	 * @param
	 * @return R
	 */
	boolean goOnlineById(Long diseaseId,Integer isOnline);

	/**
	 * 修改疾病表
	 * @param tcmDisease 疾病表
	 * @return R
	 */
	boolean updatePojoById(TcmDisease tcmDisease);

	/**
	 * 通过name查询疾病表DTO
	 * @param name id
	 * @return R
	 */
	TcmDiseaseDTO selectTcmDiseaseDTOByName(String name);

	/**
	 * 通过pojo查询疾病表
	 * @param tcmDisease
	 * @return R
	 */
	IPage<TcmDiseaseDTO> getByPojo(IPage<TcmDiseaseDTO> page, TcmDisease tcmDisease);
}
