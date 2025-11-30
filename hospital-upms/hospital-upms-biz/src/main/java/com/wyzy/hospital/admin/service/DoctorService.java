

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.PcDoctorDTO;
import com.wyzy.hospital.admin.api.entity.Doctor;

import java.util.List;
import java.util.Map;

/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-16 10:29:02
 */
public interface DoctorService extends IService<Doctor> {
    /**
     * 后台管理医生筛选
     *
     * @param passDateBegin 审核通过日期
     * @param passDateEnd   审核通过日期
     * @param nameOrPhone   姓名或者电话
     * @param source        信息来源（医院，诊所，工作室,后台）
     * @param status        状态
     * @param inComeType    收入类型
     * @param inComeBegin   收入
     * @param inComeEnd     收入
     * @param salePhone     销售人电话
     * @param departmentIds  科室id
     * @param page 分页
     * @return Page<PcDoctorDTO>
     * @author
     * @date 2021/04/17 11:54
     */
    Page<PcDoctorDTO> pcListDoctorBy(String passDateBegin, String passDateEnd,
                                     String nameOrPhone, Integer source,
                                     Integer status, Long inComeType,
                                     Long inComeBegin, Long inComeEnd,
                                     String salePhone, String departmentIds, Page page);

    /**
     * 根据归属类型查机构
     * @author
     * @date 2021/04/25 09:37
     * @param id id
     * @param name  名字
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    List<Map<String,Object>> listInstitutions(Long id,String name);

    /**
     * 根据门诊id 查询医师列表
     * @param clinicId
     * @return
     */
    List<Doctor> getDoctorByClinicId(Integer clinicId);



    /**
     * 根据门诊id 查询医师列表
     * @param clinicId
     * @return
     */
    List<Doctor> getDoctorByClinicId(Long clinicId);

    /**
     * 通过id 查询医生信息
     * @param doctorId
     * @return
     */
    Doctor getDoctorById(Integer doctorId);

    /**
     * 根据id查医生
     * @author wrk
     * @date 2021/04/29 15:28
     * @param id 医生id
     * @return com.wyzy.hospital.admin.api.dto.PcDoctorDTO
     */
    PcDoctorDTO getDoctorById(Long id);

    /**
     * 伪删除医生
     * @author wrk
     * @date 2021/04/30 09:33
     * @param doctorId 医生id
     * @return java.lang.Boolean
     */
    Boolean deleteDoctorById(Long doctorId);

    /**
     * 医生审核
     * @author wrk
     * @date 2021/04/30 10:27
     * @param doctorId 医生id
     * @param examStatusId 审核状态
     * @param examDetailResult 审核结果详情
     * @param examPersonId 审核人id
     * @return java.lang.Boolean
     */
    Boolean examDoctor(Long doctorId, Long examStatusId, String examDetailResult, Long examPersonId);

    /**
     * 获取医生列表
     * @param clinicId
     * @return
     */
    List<Doctor> getDoctorList(Long clinicId);
}
