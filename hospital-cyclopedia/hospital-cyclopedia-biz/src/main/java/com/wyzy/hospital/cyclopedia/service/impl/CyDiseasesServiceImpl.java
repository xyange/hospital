
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.CyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDiseases;
import com.wyzy.hospital.cyclopedia.mapper.CyDiseasesMapper;
import com.wyzy.hospital.cyclopedia.service.CyDiseasesService;
import com.wyzy.hospital.cyclopedia.util.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-05-08 14:37:31
 */
@Service
public class CyDiseasesServiceImpl extends ServiceImpl<CyDiseasesMapper, CyDiseases> implements CyDiseasesService {
/*
	@Override
	public CyDiseases queryDiseasesAndArticlesByName(String diseaseName) {
		return baseMapper.selectDiseasesAndArticlesByName(diseaseName);
	}
*/
@Resource
CyDiseasesMapper cyDiseasesMapper;

	@Override
	public List<CyDiseasesDTO> queryRandDiseases() {
		List<CyDiseasesDTO> enDiseases = baseMapper.selectRandDiseases();
		return enDiseases ;
	}

	@Override
	public Integer queryNumberEnDiseases() {
		return baseMapper.selectNumberEnDiseases();
	}

	@Override
	public List<CyDiseasesDTO> queryCheckDiseases(IPage<CyDiseasesDTO> page) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.selectCheckDiseases(page);
		return cyDiseasesDTOList;
	}

	@Override
	public List<CyDiseasesDTO> lookConditionDiseases(IPage<CyDiseasesDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String disName, String uploadAdmin) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.byConditionDiseasesBackstage(page,minTime,maxTime,disName,uploadAdmin);
		return cyDiseasesDTOList;
	}

	@Override
	public List<CyDiseasesDTO> queryCyDiseasesTable(IPage<CyDiseasesDTO> page) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.selectCyDiseasesTable(page);
		return cyDiseasesDTOList;
	}

	//疾病百科列表（查询）

	@Override
	public List<CyDiseasesDTO> lookConditionDiseasesTable(IPage<CyDiseasesDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String disName, String disCheckAdmin) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.byConditionDiseasesTable(page,minTime,maxTime,disName,disCheckAdmin);
		return cyDiseasesDTOList;
	}

	@Override
	public List<CyDiseasesDTO> looktheCondDisBackTable(IPage<CyDiseasesDTO> page, LocalDateTime minTime, LocalDateTime maxTime, String disName, String uploadAdmin) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.theCondDisBackTable(page,minTime,maxTime,disName,uploadAdmin);
		return cyDiseasesDTOList;
	}

	@Override
	public List<CyDiseasesDTO> queryCyDiseasesCheckTable(IPage<CyDiseasesDTO> page) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.selectCyDiseasesCheckTable(page);
		return cyDiseasesDTOList;
	}

	@Override
	public List<CyDiseasesDTO> queryCyDiseasesById(Long disId) {
		List<CyDiseasesDTO> cyDiseasesDTOList = baseMapper.queryCyDiseasesById(disId);
		return cyDiseasesDTOList;
	}

	@Override
	public void alterDiseasesCheckStruts(Long disId, String disCheckStruts) {
		LocalDateTime localDateTime = TimeUtil.utilTime();
		CyDiseasesDTO cyDiseasesDTO=new CyDiseasesDTO();
		cyDiseasesDTO.setDisId(disId);

		try {

			if("0".equals(disCheckStruts)){
				cyDiseasesDTO.setDisCheckStruts("1");
				cyDiseasesDTO.setDisCheckPassTime(localDateTime);
				cyDiseasesMapper.updateDiseasesCheckStruts(cyDiseasesDTO);
			}else if ("1".equals(disCheckStruts)){
				cyDiseasesDTO.setDisCheckStruts("2");
				cyDiseasesMapper.updateDiseasesCheckStruts(cyDiseasesDTO);
			} else if("2".equals(disCheckStruts)){
				cyDiseasesDTO.setDisCheckStruts("1");
				cyDiseasesMapper.updateDiseasesCheckStruts(cyDiseasesDTO);
			}else {
				cyDiseasesDTO.setDisCheckStruts("1");
				cyDiseasesMapper.updateDiseasesCheckStruts(cyDiseasesDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void alterSubmitDiseasesCheckStruts(Long disId, String disCheckStruts) {
		CyDiseasesDTO cyDiseasesDTO=new CyDiseasesDTO();
		cyDiseasesDTO.setDisId(disId);
		if("2".equals(disCheckStruts)){
			cyDiseasesDTO.setDisCheckStruts("0");
			cyDiseasesMapper.updateDiseasesCheckStruts(cyDiseasesDTO);
		}
	}


	@Override
	public void alterDisExistStruts(Long disId, String disExistStruts) {
			if ("1".equals(disExistStruts)) {
				cyDiseasesMapper.updateDisExistStruts(disId, "2");
			}else if("2".equals(disExistStruts)){
				cyDiseasesMapper.updateDisExistStruts(disId, "1");
			}

		}


	@Override
	public CyDiseases selectNameById(String disName) {
		return baseMapper.getNameById(disName);
	}

	@Override
	public String selectBydisName(String disName) {

		return baseMapper.getBydisName(disName);
	}

}
