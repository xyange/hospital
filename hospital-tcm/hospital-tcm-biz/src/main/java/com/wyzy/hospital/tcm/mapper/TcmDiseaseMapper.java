

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmDiseaseDTO;
import com.wyzy.hospital.tcm.entity.TcmDisease;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
@Mapper
public interface TcmDiseaseMapper extends HospitalBaseMapper<TcmDisease> {

	/**
	 * 通过疾病名称diseaseName查询疾病
	 * @param diseaseName
	 * @return
	 */
	TcmDisease selectTcmDiseaseByName(@Param("diseaseName") String diseaseName);

	/**
	 * 通过疾病名称diseaseName查询疾病DTO
	 * @param name
	 * @return
	 */
	TcmDiseaseDTO selectTcmDiseaseDTOByName(@Param("diseaseName") String name);

	/**
	 * 根据ID删除
	 * @param diseaseId
	 * @return
	 */
	int deleteTcmDiseaseById(@Param("diseaseId") Long diseaseId);

	/**
	 * 插入包含ID
	 * @param tcmDisease
	 * @return
	 */
	int insertTcmDisease(@Param("tcmDisease") TcmDisease tcmDisease);

	/**
	 * 根据ID查看疾病表详情
	 * @param diseaseId
	 * @return
	 */
	TcmDisease selectById(@Param("diseaseId") Long diseaseId);

	/**
	 * APP分页查询
	 * @return
	 */
	List<TcmDiseaseDTO> pageTcmDiseaseAPP(IPage<TcmDiseaseDTO> page);

	/**
	 * 分页查询
	 * @return
	 */
	List<TcmDiseaseDTO> pageDisease(IPage<TcmDiseaseDTO> page);

	/**
	 * 上下线单个
	 * @param diseaseId ID
	 * @param isOnline 上下线状态
	 * @return
	 */
	int updateTcmDiseaseById(@Param("diseaseId") Long diseaseId,@Param("isOnline") Integer isOnline);

	/**
	 * 修改疾病表
	 * @param tcmDisease 疾病表
	 * @return R
	 */
	boolean updatePojoById(@Param("tcmDisease") TcmDisease tcmDisease);

	/**
	 * 通过pojo查询疾病表
	 * @param tcmDisease
	 * @return R
	 */
	List<TcmDiseaseDTO> selectByPojo(IPage<TcmDiseaseDTO> page,@Param("pojo") TcmDisease tcmDisease);
}
