

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.EnDiseases;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:41
 */
@Mapper
public interface EnDiseasesMapper extends HospitalBaseMapper<EnDiseases> {
    //根据疾病查其详细内容并查询相关的疾病文章

    EnDiseases selectDiseasesAndArticlesByName(String diseaseName);



}
