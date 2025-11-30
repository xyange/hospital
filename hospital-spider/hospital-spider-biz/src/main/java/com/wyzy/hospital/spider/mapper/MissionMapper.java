

package com.wyzy.hospital.spider.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.spider.entity.Mission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 爬虫任务
 *
 * @author aqie
 * @date 2021-06-02 17:35:48
 */
@Mapper
public interface MissionMapper extends HospitalBaseMapper<Mission> {

}
