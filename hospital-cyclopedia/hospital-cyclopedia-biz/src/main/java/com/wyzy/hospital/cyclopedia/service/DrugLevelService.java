

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.DrugLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugLevel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 药品等级表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:25
 */
public interface DrugLevelService extends IService<DrugLevel> {
	//根据某一一级药品查二级药品数量

	List<DrugLevelDTO> queryOneTheDrugNumber();

	//根据一级查药品

	List<DrugLevelDTO>queryTwoDrug();

	//删除一级表(如果包含二级表则不能直接删除)或二级表

	String movenDrugLevel(Long id, int levels);

	//查看百科列表

	List<DrugLevelDTO>queryDrugBackTable(IPage<DrugLevelDTO> page);

	//药品百科审核(条件查询)

	List<DrugLevelDTO> lookConditionDrug(IPage<DrugLevelDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String uploadAdmin);

	//后台查看药品

	List<DrugLevelDTO>queryBackDrug(Long cyReagentId);

	//查看百科药品列表

	List<DrugLevelDTO>queryCyDrugTable(IPage<DrugLevelDTO> page);

	//百科药品列表(条件查询)

	List<DrugLevelDTO> lookConditionDrugTable(IPage<DrugLevelDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String auditAdmin);

	//药品百科审核列表

	List<DrugLevelDTO>queryDrugEncyclopediaAuditList(IPage<DrugLevelDTO> page);

	//药品百科审核列表(条件查询)

	List<DrugLevelDTO> lookdrugEncycAuditTable(IPage<DrugLevelDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String auditAdmin);
}
