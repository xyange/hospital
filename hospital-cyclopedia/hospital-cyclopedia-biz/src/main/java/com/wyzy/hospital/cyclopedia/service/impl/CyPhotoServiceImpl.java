
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.CyPhotoDTO;
import com.wyzy.hospital.cyclopedia.entity.CyPhoto;
import com.wyzy.hospital.cyclopedia.mapper.CyPhotoMapper;
import com.wyzy.hospital.cyclopedia.service.CyPhotoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图表
 *
 * @author hospital code generator
 * @date 2021-06-07 11:09:07
 */
@Service
public class CyPhotoServiceImpl extends ServiceImpl<CyPhotoMapper, CyPhoto> implements CyPhotoService {

	@Override
	public List<CyPhotoDTO> queryCyclopediaImage(Long imageCode) {
		List<CyPhotoDTO> cyPhotoDTOList = baseMapper.selectCyclopediaImage(imageCode);
		return cyPhotoDTOList;
	}
}
