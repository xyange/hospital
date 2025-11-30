

package com.wyzy.hospital.psychology.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.dto.DoctorAdeptDTO;
import com.wyzy.hospital.psychology.api.entity.DoctorAdept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 心理医生擅长表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:14
 */
@Mapper
public interface DoctorAdeptMapper extends HospitalBaseMapper<DoctorAdept> {

    /**
     * 通过id删除心理分类表
     * @param categoryId id
     */
    Integer selectAdeptIdByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 分页查询
     * @return
     */
    List<DoctorAdeptDTO> pageDoctorAdept(IPage<DoctorAdeptDTO> page);

    DoctorAdept selectDoctorAdeptByDoctorAdept(@Param("doctorAdept") DoctorAdept doctorAdept);
}
