

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.CyPhotoDTO;
import com.wyzy.hospital.cyclopedia.entity.CyPhoto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 轮播图表
 *
 * @author hospital code generator
 * @date 2021-06-07 11:09:07
 */
@Mapper
public interface CyPhotoMapper extends HospitalBaseMapper<CyPhoto> {

	//百科轮播图

	List<CyPhotoDTO>selectCyclopediaImage(Long imageCode);

}
