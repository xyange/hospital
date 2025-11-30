package com.wyzy.hospital.admin.kit.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.department.DepartmentTreeDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalDetailDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO;
import com.wyzy.hospital.admin.api.entity.Departments;
import com.wyzy.hospital.admin.api.entity.HospitalDepartment;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import com.wyzy.hospital.admin.kit.DepartmentKitService;
import com.wyzy.hospital.admin.kit.HospitalKitService;
import com.wyzy.hospital.admin.service.*;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.Func;
import com.wyzy.hospital.common.core.util.StringUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/4/17  11:35
 * @Function:
 */
@Service
@AllArgsConstructor
public class HospitalKitServiceImpl implements HospitalKitService {

    private final HospitalsService hospitalsService;
    private final DepartmentsService departmentsService;
    private final DepartmentKitService departmentKitService;
    private final UserHospitalService userHospitalService;
    private final AppDoctorService appDoctorService;
    private final HospitalDepartmentService hospitalDepartmentService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int  save(HospitalsDTO hospitalsDTO) {
        List<HospitalDepartment> hospitalDepartments = new ArrayList<>();
        String departmentIds = hospitalsDTO.getDepartmentIds();
        Long hospitalId = hospitalsDTO.getId();
        // 前端传入科室id字符串转 HospitalDepartment
        List<Long> longs = StringUtil.stringToLongList(departmentIds);
        // 判断传入科室是否为空
        if(Func.isNotEmpty(longs)){
            for (Long s: longs) {
                HospitalDepartment hospitalDepartment = new HospitalDepartment();
                hospitalDepartment.setHospitalId(hospitalId);
                hospitalDepartment.setDepartmentsId(s);
                hospitalDepartments.add(hospitalDepartment);
            }
            hospitalDepartmentService.saveBatch(hospitalDepartments);
        }
        return hospitalsService.save(hospitalsDTO);
    }

    @Override
    public IPage<HospitalsDTO> getHospitalsPage(IPage<HospitalsDTO> page, HospitalsDTO hospitals) {
        LambdaQueryWrapper<Hospitals> likeQuery = new LambdaQueryWrapper<Hospitals>()
                .eq(StringUtils.isNotBlank(hospitals.getDelFlag()),Hospitals::getDelFlag, CommonConstants.STATUS_NORMAL)
                .eq(StringUtils.isNotBlank(hospitals.getApprove()),Hospitals::getApprove, hospitals.getApprove())
                .eq(StringUtils.isNotBlank(hospitals.getStatus()),Hospitals::getStatus, hospitals.getStatus())
                .eq(StringUtils.isNotBlank(hospitals.getSalesmanPhone()),Hospitals::getSalesmanPhone, hospitals.getSalesmanPhone())
                .between(hospitals.getDoctorNumberStart()!=null,Hospitals::getOnlineDoctorNumber,hospitals.getDoctorNumberStart(),
                        hospitals.getDoctorNumberEnd())
                .like(StringUtils.isNotBlank(hospitals.getHospitalName()),
                        Hospitals::getHospitalName, hospitals.getHospitalName());
        return hospitalsService.selectList(page, likeQuery);

    }

    @Override
    public IPage<AppHospitalVO> getHospitalList(IPage<AppHospitalVO> page, AppHospitalDTO hospitalsDTO) {
        /**
         * 如果传入科室名称 转换为科室id
         */
        String departmentName = hospitalsDTO.getDepartmentName();
        if(Func.isNoneBlank(departmentName)){
           Long departmentId = departmentsService.getOne(new LambdaQueryWrapper<Departments>()
                    .select(Departments::getId)
                    .eq(Departments::getDepartmentName, departmentName)).getId();
           hospitalsDTO.setDepartmentId(departmentId);
        }

        List<AppHospitalDTO> hospitals = hospitalsService.getHospitalList(page, hospitalsDTO);
        List<AppHospitalVO> hospitalVOS = hospitals.stream().map(AppHospitalVO::new).collect(Collectors.toList());
        return page.setRecords(hospitalVOS);
    }

    @Override
    public HospitalDetailDTO detail(Long userId, Long hospitalId) {
        // 医院详情
        HospitalDetailDTO detail = hospitalsService.detail(hospitalId);
        String specialDepartments = detail.getSpecialDepartments();
        if(Func.isNoneBlank(specialDepartments)){
            List<Long> ids = StringUtil.stringToLongList(specialDepartments);
            // 特色科室
            detail.setSpecialDepartments(departmentsService.getSpecialDepartment(ids));
        }

        // 用户是否收藏
        Integer collect = userHospitalService.isCollect(hospitalId, userId);
        detail.setCollect(collect);
        // 医院医生
        List<AppDoctorDTO> doctors = appDoctorService.listDoctorByHospital(0L,10,hospitalId);
        detail.setDoctors(doctors);
        // 医院科室
        List<DepartmentTreeDTO> departments = departmentKitService.getTreeListByHospitalId(hospitalId);
        detail.setDepartments(departments);
        return detail;
    }
}
