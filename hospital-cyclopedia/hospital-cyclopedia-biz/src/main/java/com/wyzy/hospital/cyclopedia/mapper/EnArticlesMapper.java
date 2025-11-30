

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.entity.EnArticles;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-22 08:48:06
 */
@Mapper
public interface EnArticlesMapper extends HospitalBaseMapper<EnArticles> {
	/*// 通过articleName模糊查询并随机查询3条文章表信息

	List<EnArticles> selectLikeName(String articleName);*/
}
