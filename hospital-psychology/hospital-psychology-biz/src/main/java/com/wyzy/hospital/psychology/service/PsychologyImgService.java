package com.wyzy.hospital.psychology.service;

import com.wyzy.hospital.psychology.api.entity.PsychologyImg;

import java.util.List;

/**
 * @author wrk
 */
public interface PsychologyImgService {
	/**
	 * 查图片
	 * @param imgType
	 * @return java.util.List<com.wyzy.hospital.psychology.entity.PsychologyImg>
	 * @author wrk
	 * @date 2021/05/08 09:36
	 */
	List<PsychologyImg> listImg(Integer imgType);

}
