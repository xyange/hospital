

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.PcDoctorDTO;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-12 16:50:44
 */
@Mapper
public interface DoctorMapper extends HospitalBaseMapper<Doctor> {

    /**
     * 后台管理医生筛选
     *
     * @param passDateBegin 审核通过日期
     * @param passDateEnd   审核通过日期
     * @param nameOrPhone   姓名或者电话
     * @param source        信息来源（医院，诊所，工作室,后台）
     * @param status        状态
     * @param doctorIds    根据收入查来的医生ids
     * @param salePhone     销售人电话
     * @param departmentIds 科室id
     * @param pageBegin     分页
     * @param pageSize      分页
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.PcDoctorDTO>
     * @author
     * @date 2021/04/17 11:54
     */
    List<PcDoctorDTO> pcListDoctorBy(@Param("passDateBegin") String passDateBegin, @Param("passDateEnd") String passDateEnd,
                                     @Param("nameOrPhone") String nameOrPhone, @Param("source") Integer source,
                                     @Param("status") Integer status, @Param("doctorIds") String doctorIds,

                                     @Param("salePhone") String salePhone, @Param("departmentIds") String departmentIds, @Param("pageBegin") Integer pageBegin, @Param("pageSize") Integer pageSize);

    /**
     * 后台管理医生筛选
     *
     * @param passDateBegin 审核通过日期
     * @param passDateEnd   审核通过日期
     * @param nameOrPhone   姓名或者电话
     * @param source        信息来源（医院，诊所，工作室,后台）
     * @param status        状态
     * @param doctorIds    根据收入查来的医生ids
     * @param salePhone     销售人电话
     * @param departmentIds 科室id
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.PcDoctorDTO>
     * @author
     * @date 2021/04/17 11:54
     */
    Integer pcCountDoctorBy(@Param("passDateBegin") String passDateBegin, @Param("passDateEnd") String passDateEnd,
                            @Param("nameOrPhone") String nameOrPhone, @Param("source") Integer source,
                            @Param("status") Integer status, @Param("doctorIds") String doctorIds,
                            @Param("salePhone") String salePhone, @Param("departmentIds") String departmentIds);

    /**
     * 根据归属类型查机构
     *
     * @param id   归属类型
     * @param name name
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author
     * @date 2021/04/25 09:37
     */
    List<Map<String, Object>> listInstitutions(@Param("id") Long id, @Param("name") String name);

    /**
     * 根据诊所id查询医生列表 -- Integer
     * @param clinicId
     * @return
     */
    List<Doctor> getDoctorByClinicId(Integer clinicId);
    /**
     * 根据诊所id查询医生列表 -- Long
     * @param clinicId
     * @return
     */
    List<Doctor> getDoctorByClinicId(Long clinicId);


    /**
     * 根据id查医生
     *
     * @param id
     * @return com.wyzy.hospital.admin.api.dto.PcDoctorDTO
     * @author wrk
     * @date 2021/04/29 15:29
     */
    PcDoctorDTO getDoctorById(@Param("id") Long id);

    /**
     * 伪删除医生
     *
     * @param doctorId 医生id
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/04/30 09:35
     */
    Integer deleteDoctorById(@Param("doctorId") Long doctorId);

    /**
     * 医生审核
     *
     * @param doctorId         医生id
     * @param examStatusId     审核状态
     * @param examDetailResult 审核结果详情
     * @param examPersonId     审核人id
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/04/30 10:27
     */
    Integer examDoctor(@Param("doctorId") Long doctorId, @Param("examStatusId") Long examStatusId,
                       @Param("examDetailResult") String examDetailResult, @Param("examPersonId") Long examPersonId);

    /**
     * 根据诊所id获取医生列表
     * @param clinicId
     * @return List<Doctor>
     */
    List<Doctor> getDoctorList(@Param("clinicId") Long clinicId);

    /**
     * 根据收入类型收入范围查医生ids
     * @author
     * @date 2021/05/22 14:29
     * @param inComeType 收入类型（服务类型）
     * @param inComeBegin 收入最小值
     * @param inComeEnd 收入最大值
     * @return java.lang.String
     */
    String getIdsByIncome(@Param("inComeType")Long inComeType, @Param("inComeBegin")Long inComeBegin, @Param("inComeEnd")Long inComeEnd);


}
