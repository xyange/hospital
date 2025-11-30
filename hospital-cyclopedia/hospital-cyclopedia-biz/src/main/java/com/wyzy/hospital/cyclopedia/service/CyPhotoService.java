

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.CyPhotoDTO;
import com.wyzy.hospital.cyclopedia.entity.CyPhoto;

import java.util.List;

/**
 * 轮播图表
 *
 * @author hospital code generator
 * @date 2021-06-07 11:09:07
 */
public interface CyPhotoService extends IService<CyPhoto> {
//百科轮播图

	List<CyPhotoDTO> queryCyclopediaImage(Long imageCode);
}
