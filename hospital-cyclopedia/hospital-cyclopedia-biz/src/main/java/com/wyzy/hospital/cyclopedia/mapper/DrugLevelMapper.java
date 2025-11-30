

package com.wyzy.hospital.cyclopedia.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.DrugLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 药品等级表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:25
 */
@Mapper
public interface DrugLevelMapper extends HospitalBaseMapper<DrugLevel> {
	//根据某一一级药品查二级药品数量

    List<DrugLevelDTO>selectOneTheDrugNumber();

   //根据一级查药品

	List<DrugLevelDTO>selectTwoDrug();

    //查数量二级下药品

	int selectDrugNumber(Long id);

	//查一级下二级分类

	int selectOneTheDrugTwoNum(Long aid);

	//查看后台药品审核

	List<DrugLevelDTO>selectDrugBackTable(IPage<DrugLevelDTO> page);

	//查看后台药品审核（查询）

	List<DrugLevelDTO> byConditionDrug(IPage<DrugLevelDTO> page,@Param("minTime") LocalDateTime minTime,
												 @Param("maxTime") LocalDateTime maxTime,
												 @Param("cyReagentName") String cyReagentName,
												 @Param("uploadAdmin") String uploadAdmin);


    //通过cyReagentId后台查看药品

	List<DrugLevelDTO>lookBackDrug(Long cyReagentId);

	//查看百科药品列表

	List<DrugLevelDTO>selectCyBackDrugTable(IPage<DrugLevelDTO> page);

	//百科药品列表(条件查询)

	List<DrugLevelDTO> byConditionDrugTable(IPage<DrugLevelDTO> page,@Param("minTime") LocalDateTime minTime,
										@Param("maxTime") LocalDateTime maxTime,
										@Param("cyReagentName") String cyReagentName,
										@Param("auditAdmin") String auditAdmin);


	//药品百科审核列表

	List<DrugLevelDTO>DrugEncyclopediaAuditList(IPage<DrugLevelDTO> page);

	//药品百科审核列表(条件查询)

	List<DrugLevelDTO> drugEncycAuditTable(IPage<DrugLevelDTO> page,@Param("minTime") LocalDateTime minTime,
											 @Param("maxTime") LocalDateTime maxTime,
											 @Param("cyReagentName") String cyReagentName,
											 @Param("auditAdmin") String auditAdmin);

	String selectName(String drugLevelName);
}
