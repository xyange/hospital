

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.EnDiseases;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:41
 */
public interface EnDiseasesService extends IService<EnDiseases> {

    EnDiseases queryDiseasesAndArticlesByName(String diseaseName);



}
