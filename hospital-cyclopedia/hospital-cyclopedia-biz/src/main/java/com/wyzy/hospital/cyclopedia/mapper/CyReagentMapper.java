

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.CyReagentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyReagent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公司药品表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:37:00
 */
@Mapper
public interface CyReagentMapper extends HospitalBaseMapper<CyReagent> {

List<CyReagentDTO>selectCompanyReagenDetails(Long rid);


	//公司药品上线下线

	void uploadDrugExitsDtatus(@Param("cyReagentId")Long cyReagentId, @Param("existStruts")String existStruts);

	//公司药品审核状态

	void updateDrugAuditDtatus(@Param("cyReagentDTO") CyReagentDTO cyReagentDTO);

//公司药品审核状态(重新提交)

	void reSubmitDrugAudit(@Param("cyReagentDTO") CyReagentDTO cyReagentDTO);

	String getByName(String cyReagentName);

}
