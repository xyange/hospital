
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.EnArticles;
import com.wyzy.hospital.admin.mapper.EnArticlesMapper;
import com.wyzy.hospital.admin.service.EnArticlesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-20 17:06:46
 */
@Service
public class EnArticlesServiceImpl extends ServiceImpl<EnArticlesMapper, EnArticles> implements EnArticlesService {

    @Override
    public List<EnArticles> queryLikeName(String articleName) {
        return baseMapper.selectLikeName(articleName);
    }
}
