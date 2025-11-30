

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.HospitalDepartment;

import java.util.List;

/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-17 09:26:01
 */
public interface HospitalDepartmentService extends IService<HospitalDepartment> {

    /**
     * 根据医院科室表中科室ID查询医院科室表信息
     * @param --id id
     * @return R
     */
    List<HospitalDepartment> getHosdepDetailBydepartmentsId(Long departmentsId);

    /**
     * 通过科室departments_id删除医院科室详情
     * @param --departments_id 科室id
     * @return R
     */
    boolean removeBydepartmentsId(Long departmentsId);

    /**
     * 通过id删除医院科室详情
     * @param id id
     * @return R
     */
    boolean removeById(Long id);
}
