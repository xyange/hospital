
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.entity.EnArticles;
import com.wyzy.hospital.cyclopedia.mapper.EnArticlesMapper;
import com.wyzy.hospital.cyclopedia.service.EnArticlesService;
import org.springframework.stereotype.Service;

/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-22 08:48:06
 */
@Service
public class EnArticlesServiceImpl extends ServiceImpl<EnArticlesMapper, EnArticles> implements EnArticlesService {
/*	@Override
	public List<EnArticles> queryLikeName(String articleName) {
		return baseMapper.selectLikeName(articleName);
	}*/
}
