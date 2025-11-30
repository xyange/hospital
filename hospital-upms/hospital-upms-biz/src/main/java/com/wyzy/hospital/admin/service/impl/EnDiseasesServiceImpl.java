
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.EnDiseases;
import com.wyzy.hospital.admin.mapper.EnDiseasesMapper;
import com.wyzy.hospital.admin.service.EnDiseasesService;
import org.springframework.stereotype.Service;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:41
 */
@Service
public class EnDiseasesServiceImpl extends ServiceImpl<EnDiseasesMapper, EnDiseases> implements EnDiseasesService {


    @Override
    public EnDiseases queryDiseasesAndArticlesByName(String diseaseName) {
        return baseMapper.selectDiseasesAndArticlesByName(diseaseName);
    }



}

