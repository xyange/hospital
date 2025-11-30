package com.wyzy.hospital.cyclopedia.kit.impl;

import com.wyzy.hospital.cyclopedia.dto.AddDrugCompanyDTO;
import com.wyzy.hospital.cyclopedia.kit.AddDrugKitService;
import com.wyzy.hospital.cyclopedia.service.CyCompayService;
import com.wyzy.hospital.cyclopedia.service.CyReagentDetailsService;
import com.wyzy.hospital.cyclopedia.service.CyReagentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/24  16:28
 */

@Service
@AllArgsConstructor
public class AddDrugKitServiceImpl implements AddDrugKitService {

	private final CyCompayService cyCompayService;
	private final CyReagentService cyReagentService;
	private final CyReagentDetailsService cyReagentDetailsService;


	@Transactional
	@Override
	public String addDrugKitService(AddDrugCompanyDTO addDrugCompanyDTO) {

		String cyReagentName =cyReagentService.selectByName(addDrugCompanyDTO.getCyReagent().getCyReagentName());

//公司表添加
		cyCompayService.save(addDrugCompanyDTO.getCyCompay());
//获取公司表id给公司药品表
		addDrugCompanyDTO.getCyReagent().setCyCompanyId(addDrugCompanyDTO.getCyCompay().getCompayId());
//添加公司药品表
			cyReagentService.save(addDrugCompanyDTO.getCyReagent());
//把公司药品表id给公司药品详情表
		addDrugCompanyDTO.getCyReagentDetails().setCyReagentId(addDrugCompanyDTO.getCyReagent().getCyReagentId());
//添加药品公司详情表
		cyReagentDetailsService.save(addDrugCompanyDTO.getCyReagentDetails());
       return "添加成功";
	}
}