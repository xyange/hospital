package com.wyzy.hospital.cyclopedia.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.cyclopedia.dto.AddCyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDiseases;
import com.wyzy.hospital.cyclopedia.exception.GlobalException;
import com.wyzy.hospital.cyclopedia.kit.AddDiseasesKitService;
import com.wyzy.hospital.cyclopedia.mapper.CyDiseasesMapper;
import com.wyzy.hospital.cyclopedia.service.CyDiseasesService;
import com.wyzy.hospital.cyclopedia.service.DepartDiseasesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/24  16:28
 */

@Service
@AllArgsConstructor
public class AddCyDiseasesKitServiceImpl extends  ServiceImpl<CyDiseasesMapper, CyDiseases> implements AddDiseasesKitService {

	private final CyDiseasesService cyDiseasesService;

	private final DepartDiseasesService departDiseasesService;

	@Transactional
	@Override
	public boolean addDiseasesKitService(AddCyDiseasesDTO addCyDiseasesDTO) {

			//查疾病名称
			String disName = cyDiseasesService.selectBydisName(addCyDiseasesDTO.getCyDiseases().getDisName());
			//判断疾病是否存在
			if (disName == null) {
				cyDiseasesService.save(addCyDiseasesDTO.getCyDiseases());
			} else {
				throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
			}
		try {
			addCyDiseasesDTO.getDepartDiseases().setDepartDisDiseasesId(addCyDiseasesDTO.getCyDiseases().getDisId());
			departDiseasesService.save(addCyDiseasesDTO.getDepartDiseases());
		} catch (Exception e) {
			e.printStackTrace();
			throw new GlobalException(CodeMsg.COMPANY_CYREAGENT_INNERST_ERROR);
		}
		return true;
	}
}