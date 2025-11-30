

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.admin.api.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author aqie
 * @date 2021-04-10 10:57:08
 */
@Mapper
public interface AreaMapper extends HospitalBaseMapper<Area> {

    /**
     * 根据父id查子集区域
     * @param parentId
     * @param areaName
     * @return java.util.List<com.wyzy.hospital.admin.api.entity.Area>
     * @author wrk
     * @date 2021/06/02 14:38
     */
    List<Area> listAreaByParentId(@Param("parentId") Integer parentId, @Param("areaName") String areaName);


}
