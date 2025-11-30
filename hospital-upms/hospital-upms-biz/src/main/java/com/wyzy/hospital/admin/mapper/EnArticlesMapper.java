

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.EnArticles;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-20 17:06:46
 */
@Mapper
public interface EnArticlesMapper extends HospitalBaseMapper<EnArticles> {
    //通过articleName模糊查询并随机查询3条文章表信息

List<EnArticles> selectLikeName(String articleName);
}
