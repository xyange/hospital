package com.wyzy.hospital.psychology.service.impl;

import com.wyzy.hospital.psychology.api.entity.PsychologyImg;
import com.wyzy.hospital.psychology.mapper.PsychologyImgMapper;
import com.wyzy.hospital.psychology.service.PsychologyImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查图片实现类
 *
 * @author wrk
 * @date 2021/05/08 09:39
 **/
@Service
public class PsychologyImgServiceImpl implements PsychologyImgService {
	@Resource
	private PsychologyImgMapper psychologyImgMapper;
	@Override
	public List<PsychologyImg> listImg(Integer imgType) {
		return psychologyImgMapper.listImg(imgType);
	}
}
