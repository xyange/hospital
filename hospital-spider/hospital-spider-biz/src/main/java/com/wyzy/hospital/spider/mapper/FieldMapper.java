

package com.wyzy.hospital.spider.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.spider.entity.Field;
import org.apache.ibatis.annotations.Mapper;

/**
 * 爬虫字段
 *
 * @author aqie
 * @date 2021-06-02 17:36:13
 */
@Mapper
public interface FieldMapper extends HospitalBaseMapper<Field> {

}
