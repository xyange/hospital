
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.DrugLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugLevel;
import com.wyzy.hospital.cyclopedia.mapper.DrugLevelMapper;
import com.wyzy.hospital.cyclopedia.service.DrugLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 药品等级表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:25
 */
@Service
public class DrugLevelServiceImpl extends ServiceImpl<DrugLevelMapper, DrugLevel> implements DrugLevelService {
	@Resource
	DrugLevelMapper drugLevelMapper;

	@Override
	public List<DrugLevelDTO> queryOneTheDrugNumber() {
		List<DrugLevelDTO> drugLevelDTOList = baseMapper.selectOneTheDrugNumber();
		return drugLevelDTOList;
	}

	@Override
	public List<DrugLevelDTO> queryTwoDrug() {
		List<DrugLevelDTO> drugLevelDTOList = baseMapper.selectTwoDrug();
		return drugLevelDTOList;
	}

	@Override
	public String movenDrugLevel(Long id, int levels) {
		String message = null;
		try {
			if (levels==2) {
				Integer count = drugLevelMapper.selectDrugNumber(id);
				if (count == 0) {
					drugLevelMapper.deleteById(id);
					message = "删除成功----111";
				} else {
					message = "删除失败该一级表下存在二级分类----110";
				}
			}else {
				if(levels==1){
					int number=drugLevelMapper.selectOneTheDrugTwoNum(id);
				if(number==0){
					drugLevelMapper.deleteById(id);
					message = "一级分类删除成功----111";
				}else {
					message = "删除失败有数据";
				}
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<DrugLevelDTO> queryDrugBackTable(IPage<DrugLevelDTO> page) {
		List<DrugLevelDTO> drugLevelDTOList = baseMapper.selectDrugBackTable(page);
		return drugLevelDTOList;
	}

	@Override
	public List<DrugLevelDTO> lookConditionDrug(IPage<DrugLevelDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String uploadAdmin) {
		List<DrugLevelDTO> cyDiseasesDTOList = baseMapper.byConditionDrug(page,minTime, maxTime, cyReagentName, uploadAdmin);
		return cyDiseasesDTOList;
	}

	@Override
	public List<DrugLevelDTO> queryBackDrug(Long cyReagentId) {
		List<DrugLevelDTO> drugLevelDTOList = baseMapper.lookBackDrug(cyReagentId);
		return drugLevelDTOList;
	}

	@Override
	public List<DrugLevelDTO> queryCyDrugTable(IPage<DrugLevelDTO> page) {
		List<DrugLevelDTO> drugLevelDTOList = baseMapper.selectCyBackDrugTable(page);
		return drugLevelDTOList;
	}

	@Override
	public List<DrugLevelDTO> lookConditionDrugTable(IPage<DrugLevelDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String auditAdmin) {
		List<DrugLevelDTO> cyDiseasesDTOList = baseMapper.byConditionDrugTable(page,minTime, maxTime, cyReagentName, auditAdmin);
		return cyDiseasesDTOList;
	}

	@Override
	public List<DrugLevelDTO> queryDrugEncyclopediaAuditList(IPage<DrugLevelDTO> page) {
		List<DrugLevelDTO> drugLevelDTOList = baseMapper.DrugEncyclopediaAuditList(page);
		return drugLevelDTOList;
	}


	@Override
	public List<DrugLevelDTO> lookdrugEncycAuditTable(IPage<DrugLevelDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String auditAdmin) {
		List<DrugLevelDTO> cyDiseasesDTOList = baseMapper.drugEncycAuditTable(page,minTime, maxTime, cyReagentName, auditAdmin);
		return cyDiseasesDTOList;
	}


}
