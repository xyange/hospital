

package com.wyzy.hospital.admin.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.PhysicalFitnessDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalFitness;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 身体管理体能
 *
 * @author hospital code generator
 * @date 2021-06-16 15:13:44
 */
@Mapper
public interface PhysicalFitnessMapper extends HospitalBaseMapper<PhysicalFitness> {

    /**
     * 通过memberId查询身体管理体能
     * @param memberId id
     */
    List<PhysicalFitnessDTO> getByMemberId(IPage<PhysicalFitnessDTO> page, @Param("memberId") Long memberId);


}
