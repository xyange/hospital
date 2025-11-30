package com.wyzy.hospital.cyclopedia.dto;

import com.wyzy.hospital.cyclopedia.entity.CyCompay;
import com.wyzy.hospital.cyclopedia.entity.CyReagent;
import com.wyzy.hospital.cyclopedia.entity.CyReagentDetails;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/24  17:14
 */
@Data
public class AddDrugCompanyDTO {
	//公司药品表
	private CyReagent cyReagent;
	//公司表
	private CyCompay cyCompay;
	//公司药品详情表
	private CyReagentDetails cyReagentDetails;
}
