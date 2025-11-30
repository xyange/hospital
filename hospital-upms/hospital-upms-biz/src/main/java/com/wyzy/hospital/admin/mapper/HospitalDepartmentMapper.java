

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.HospitalDepartment;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-17 09:26:01
 */
@Mapper
public interface HospitalDepartmentMapper extends HospitalBaseMapper<HospitalDepartment> {

    /**
     * 通过科室departments_id删除医院科室详情
     * @param departmentsId 科室id
     * @return R
     */
    Integer removeBydepartmentsId(Long departmentsId);

    /**
     * 根据医院科室表中科室ID查询医院科室表信息
     * @param departmentsId 科室id
     * @return R
     */
    List<HospitalDepartment> getHosdepDetailBydepartmentsId(Long departmentsId);
}
