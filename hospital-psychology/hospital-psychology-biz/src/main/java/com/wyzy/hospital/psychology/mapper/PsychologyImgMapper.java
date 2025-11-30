package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.psychology.api.entity.PsychologyImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wrk
 */
@Mapper
public interface PsychologyImgMapper {
	/**
	 * 查图片
	 * @param imgType
	 * @return java.util.List<com.wyzy.hospital.psychology.entity.PsychologyImg>
	 * @author wrk
	 * @date 2021/05/08 09:36
	 */
	List<PsychologyImg> listImg(@Param("imgType") Integer imgType);
}
