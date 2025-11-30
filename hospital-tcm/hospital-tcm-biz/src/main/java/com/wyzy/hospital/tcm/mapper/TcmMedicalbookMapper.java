

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmMedicalbookDTO;
import com.wyzy.hospital.tcm.entity.TcmMedicalbook;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@Mapper
public interface TcmMedicalbookMapper extends HospitalBaseMapper<TcmMedicalbook> {

	/**
	 * 根据名称查询
	 * @param medicalbookName
	 */
	TcmMedicalbook  selectTcmMedicalbookByName(@Param("medicalbookName") String medicalbookName);

	/**
	 * 通过Bookkattr值查询医书表
	 * @param classicsId 经典分类
	 * @param sectId 流派
	 * @param subjectId 学科
	 * @param writerId 作者
	 */
	List<TcmMedicalbookDTO> selectByMultivalued(@Param("classicsId") Long classicsId,
												@Param("sectId") Long sectId,
												@Param("subjectId") Long subjectId,
												@Param("writerId") Long writerId);

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	TcmMedicalbookDTO getById(@Param("medicalbookId") Long medicalbookId);

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @return
	 */
	List<TcmMedicalbookDTO> getTcmMedicalbookPage(IPage<TcmMedicalbookDTO> page);

	/**
	 * 根据ID集合查询书记列表
	 * @param medicalbookList
	 * @return
	 */
	List<TcmMedicalbookDTO> getcollectMedicalbook(@Param("list") List<Long> medicalbookList);

	/**
	 * 根据ID删除
	 * @param medicalbookId
	 * @return
	 */
	@Delete("delete from tcm_medicalbook where medicalbook_id = #{medicalbookId}")
	int deleteTcmMedicalbookById(@Param("medicalbookId") Long medicalbookId);

	/**
	 * 增加ID
	 * @param tcmMedicalbook
	 * @return
	 */
	int insertTcmMedicalbook(@Param("tcmMedicalbook") TcmMedicalbook tcmMedicalbook);

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	int updateIsOnlineById(@Param("medicalbookId") Long medicalbookId,@Param("isOnline") Integer isOnline);

	/**
	 * 修改
	 * @param tcmMedicalbook
	 * @return
	 */
	int updateTcmMedicalbookById(@Param("tcmMedicalbook") TcmMedicalbook tcmMedicalbook);

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	TcmMedicalbookDTO getByIdAPP(@Param("id") Long id,@Param("medicalbookId") Long medicalbookId);

	/**
	 * 修改浏览量
	 */
	Integer updatePageViewById(@Param("medicalbookId") Long medicalbookId);
}
