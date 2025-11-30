package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmMedicalbookDTO;
import com.wyzy.hospital.tcm.entity.TcmMedicalbook;

import java.util.List;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
public interface TcmMedicalbookService extends IService<TcmMedicalbook> {

	/**
	 * 新增医书表
	 * @param tcmMedicalbook
	 * @return
	 */
	boolean saveTcmMedicalbook(TcmMedicalbook tcmMedicalbook);

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	TcmMedicalbookDTO getById(Long medicalbookId);

	/**
	 * APP通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	TcmMedicalbookDTO getByIdAPP(Long id,Long medicalbookId);

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @return
	 */
	IPage<TcmMedicalbookDTO> getTcmMedicalbookPage(IPage<TcmMedicalbookDTO> page);

	/**
	 * 我的医书经典收藏
	 * @return R
	 */
	List<TcmMedicalbookDTO> getcollectMedicalbook(Long id);

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	boolean goOnlineById(Long medicalbookId, Integer isOnline);

	/**
	 * 通过Bookkattr值查询医书表
	 * @param classicsId 经典分类
	 * @param sectId 流派
	 * @param subjectId 学科
	 * @param writerId 作者
	 */
	List<TcmMedicalbookDTO> getByMultivalued(Long classicsId, Long sectId, Long subjectId, Long writerId);

	/**
	 * 修改医书表
	 * @param tcmMedicalbook 医书表
	 * @return R
	 */
	boolean updateTcmMedicalbookById(TcmMedicalbook tcmMedicalbook);

	/**
	 * 通过name查询医书表
	 * @param name name
	 * @return R
	 */
	TcmMedicalbook selectTcmMedicalbookByName(String name);
}
