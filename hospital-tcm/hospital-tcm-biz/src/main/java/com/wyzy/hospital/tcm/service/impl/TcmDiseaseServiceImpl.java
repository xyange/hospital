package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmDiseaseDTO;
import com.wyzy.hospital.tcm.entity.TcmDisease;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmDiseaseMapper;
import com.wyzy.hospital.tcm.service.TcmDiseaseService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
@Service
@Slf4j
public class TcmDiseaseServiceImpl extends ServiceImpl<TcmDiseaseMapper, TcmDisease> implements TcmDiseaseService {

	/**
	 * 新增疾病表
	 * @param tcmDisease 疾病表
	 * @return R
	 */
	@Override
	public boolean saveTcmDisease(TcmDisease tcmDisease) {
			TcmDisease disease = baseMapper.selectTcmDiseaseByName(tcmDisease.getDiseaseName());
			if (disease != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmDisease);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}

	/**
	 * 根据ID查看疾病表详情
	 * @param diseaseId
	 * @return
	 */
	@Override
	public TcmDiseaseDTO getById(Long diseaseId) {
		TcmDisease tcmDisease = baseMapper.selectById(diseaseId);
		if (tcmDisease == null){
			return null;
		}
		TcmDiseaseDTO tcmDiseaseDTO = new TcmDiseaseDTO();
		BeanUtils.copyProperties(tcmDisease,tcmDiseaseDTO);
		return tcmDiseaseDTO;
	}

	/**
	 * APP分页查询
	 * @return
	 */
	@Override
	public IPage<TcmDiseaseDTO> pageTcmDiseaseAPP(IPage<TcmDiseaseDTO> page) {
		List<TcmDiseaseDTO> tcmDiseaseDTOList = baseMapper.pageTcmDiseaseAPP(page);
		IPage<TcmDiseaseDTO> tcmDiseaseDTOIPage = page.setRecords(tcmDiseaseDTOList);
		return tcmDiseaseDTOIPage;
	}

	/**
	 * 分页查询
	 * @return
	 */
	@Override
	public IPage<TcmDiseaseDTO> pageDisease(IPage<TcmDiseaseDTO> page) {
		List<TcmDiseaseDTO> tcmDiseaseDTOList = baseMapper.pageDisease(page);
		IPage<TcmDiseaseDTO> tcmDiseaseDTOIPage = page.setRecords(tcmDiseaseDTOList);
		return tcmDiseaseDTOIPage;
	}

	/**
	 * 上/下线疾病详情
	 * @param
	 * @return R
	 */
	@Override
	public boolean goOnlineById(Long diseaseId,Integer isOnline) {
		int i = 0;
		if (isOnline == 0){
			/*下线状态改为上线*/
			isOnline = 1;
			i = baseMapper.updateTcmDiseaseById(diseaseId,isOnline);
		}else if (isOnline == 1){
			/*上线状态改为下线*/
			isOnline = 0;
			i = baseMapper.updateTcmDiseaseById(diseaseId,isOnline);
		}
		if (i>0){
			return true;
		}
		return false;
	}

	/**
	 * 修改疾病表
	 * @param tcmDisease 疾病表
	 * @return R
	 */
	@Override
	public boolean updatePojoById(TcmDisease tcmDisease) {
		tcmDisease.setDelFlag(0);
		tcmDisease.setIsOnline(0);
		tcmDisease.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmDisease);
	}

	/**
	 * name查询DTO
	 * @param name id
	 * @return
	 */
	@Override
	public TcmDiseaseDTO selectTcmDiseaseDTOByName(String name) {
		TcmDiseaseDTO diseaseDTO = baseMapper.selectTcmDiseaseDTOByName(name);
		return diseaseDTO;
	}

	/**
	 * 通过pojo查询疾病表
	 * @param tcmDisease
	 * @return R
	 */
	@Override
	public IPage<TcmDiseaseDTO> getByPojo(IPage<TcmDiseaseDTO> page, TcmDisease tcmDisease) {
		List<TcmDiseaseDTO> tcmDiseaseDTOList = baseMapper.selectByPojo(page,tcmDisease);
		IPage<TcmDiseaseDTO> tcmDiseaseDTOIPage = page.setRecords(tcmDiseaseDTOList);
		return tcmDiseaseDTOIPage;
	}
}
