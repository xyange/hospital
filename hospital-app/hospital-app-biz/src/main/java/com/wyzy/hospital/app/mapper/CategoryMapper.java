

package com.wyzy.hospital.app.mapper;

import com.wyzy.hospital.app.api.entity.Category;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 电子书分类
 *
 * @author aqie
 * @date 2021-05-27 08:33:57
 */
@Mapper
public interface CategoryMapper extends HospitalBaseMapper<Category> {

}
