

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.CyReagentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyReagent;

import java.util.List;

/**
 * 公司药品表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:37:00
 */
public interface CyReagentService extends IService<CyReagent> {

	List<CyReagentDTO> queryCompanyReagenDetails(Long rid);


	//公司药品上线下线

	void movenDrugExitsDtatus(Long cyReagentId,String existStruts);

//公司药品审核状态

	void movenDrugAuditDtatus(Long cyReagentId,String auditStruts);

	//公司药品审核状态

	void movenReSubmitDrugAudit(Long cyReagentId,String auditStruts);

    //根据公司药品名查信息

	String selectByName(String cyReagentName);
}
