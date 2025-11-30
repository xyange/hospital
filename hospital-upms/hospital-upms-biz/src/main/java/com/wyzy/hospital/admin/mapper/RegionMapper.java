

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.admin.api.entity.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * 行政区划表
 *
 * @author aqie
 * @date 2021-04-10 14:05:23
 */
@Mapper
public interface RegionMapper extends HospitalBaseMapper<Region> {

}
