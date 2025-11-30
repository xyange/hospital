

package com.wyzy.hospital.spider.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.spider.entity.Config;
import org.apache.ibatis.annotations.Mapper;

/**
 * 爬虫配置
 *
 * @author aqie
 * @date 2021-06-02 17:34:51
 */
@Mapper
public interface ConfigMapper extends HospitalBaseMapper<Config> {

}
