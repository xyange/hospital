
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.CyReagentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyReagent;
import com.wyzy.hospital.cyclopedia.mapper.CyReagentMapper;
import com.wyzy.hospital.cyclopedia.service.CyReagentService;
import com.wyzy.hospital.cyclopedia.util.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 公司药品表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:37:00
 */
@Service
public class CyReagentServiceImpl extends ServiceImpl<CyReagentMapper, CyReagent> implements CyReagentService {

	@Resource
	CyReagentMapper cyReagentMapper;

	/**
	 *
	 * @param rid
	 * @return
	 */
	@Override
	public List<CyReagentDTO> queryCompanyReagenDetails(Long rid) {
		List<CyReagentDTO> cyReagentDTOList = baseMapper.selectCompanyReagenDetails(rid);
		return cyReagentDTOList;
	}


	/**
	 * 上线下线  1-上线 2-下线
	 * @param cyReagentId
	 * @param existStruts
	 */
	@Override
	public void movenDrugExitsDtatus(Long cyReagentId, String existStruts) {
		try {
			if ("1".equals(existStruts)) {
				cyReagentMapper.uploadDrugExitsDtatus(cyReagentId, "2");
			}else if("2".equals(existStruts)){
				cyReagentMapper.uploadDrugExitsDtatus(cyReagentId, "1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改公司药品当前审核状态
	 * @param cyReagentId
	 * @param auditStruts
	 */
	@Override
	public void movenDrugAuditDtatus(Long cyReagentId, String auditStruts) {
		LocalDateTime localDateTime = TimeUtil.utilTime();
		CyReagentDTO cyReagentDTO=new CyReagentDTO();
		cyReagentDTO.setCyReagentId(cyReagentId);

			cyReagentDTO.setReAuditTime(localDateTime);
			if("0".equals(auditStruts)){
				cyReagentDTO.setAuditStruts("1");
				cyReagentDTO.setReCheckPassTime(localDateTime);
				cyReagentMapper.updateDrugAuditDtatus(cyReagentDTO);
			}else if ("1".equals(auditStruts)){
				cyReagentDTO.setAuditStruts("2");
				cyReagentMapper.updateDrugAuditDtatus(cyReagentDTO);
			} else if("2".equals(auditStruts)){
				cyReagentDTO.setAuditStruts("1");
				cyReagentMapper.updateDrugAuditDtatus(cyReagentDTO);
			}else {
				cyReagentDTO.setAuditStruts("1");
				cyReagentMapper.updateDrugAuditDtatus(cyReagentDTO);
			}
	}



//重新提交

	@Override
	public void movenReSubmitDrugAudit(Long cyReagentId, String auditStruts) {
		CyReagentDTO cyReagentDTO=new CyReagentDTO();
		cyReagentDTO.setCyReagentId(cyReagentId);
		if("2".equals(auditStruts)){
			cyReagentDTO.setAuditStruts("0");
			cyReagentMapper.reSubmitDrugAudit(cyReagentDTO);
		}
	}

	@Override
	public String selectByName(String cyReagentName) {
		return baseMapper.getByName(cyReagentName);
	}


}
