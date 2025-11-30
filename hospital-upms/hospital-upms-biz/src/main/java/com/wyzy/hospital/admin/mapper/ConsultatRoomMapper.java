

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.ConsultatRoom;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 诊室表
 *
 * @author hospital code generator
 * @date 2021-04-17 08:47:10
 */
@Mapper
public interface ConsultatRoomMapper extends HospitalBaseMapper<ConsultatRoom> {

    /**
     * 通过医院科室ID查询诊室表
     * @param
     * @return R
     */
    List<ConsultatRoom> selectConsultatRoomByhosdepdetailId(Long hosdepdetailId);

    /**
     * 根据HosdepdetailId删除
     * @param
     * @return R
     */
    Integer deleteByHosdepdetailId(Long id);
}
