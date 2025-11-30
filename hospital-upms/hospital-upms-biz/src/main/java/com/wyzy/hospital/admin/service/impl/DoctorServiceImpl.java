
package com.wyzy.hospital.admin.service.impl;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.PcDoctorDTO;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.mapper.DoctorMapper;
import com.wyzy.hospital.admin.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-16 10:29:02
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public Page<PcDoctorDTO> pcListDoctorBy(String passDateBegin, String passDateEnd, String nameOrPhone, Integer source, Integer status, Long inComeType, Long inComeBegin, Long inComeEnd, String salePhone, String departmentIds, Page page) {
        Integer pageBegin = PageUtil.getStart((int) (page.getCurrent() - 1), (int) page.getSize());
        Integer pageSize = ((Long) page.getSize()).intValue();
        String doctorIds=doctorMapper.getIdsByIncome(inComeType,inComeBegin,inComeEnd);
        Integer count = doctorMapper.pcCountDoctorBy(passDateBegin, passDateEnd, nameOrPhone, source, status, doctorIds, salePhone, departmentIds);
        Page<PcDoctorDTO> pageData = new Page<>();
        if (count > 0) {
            List<PcDoctorDTO> list = doctorMapper.pcListDoctorBy(passDateBegin, passDateEnd, nameOrPhone, source, status, doctorIds, salePhone, departmentIds, pageBegin, pageSize);
            pageData.setRecords(list);
            pageData.setTotal(count);
            pageData.setCurrent(page.getCurrent());
            pageData.setSize(page.getSize());
            return pageData;
        }
        return new Page<PcDoctorDTO>(page.getCurrent(),page.getSize(),0L);

    }

    @Override
    public List<Map<String, Object>> listInstitutions(Long id,String name) {
        return doctorMapper.listInstitutions(id,name);
    }


    @Override
    public List<Doctor> getDoctorByClinicId(Integer clinicId) {
        List<Doctor> doctorList  =doctorMapper.getDoctorByClinicId(clinicId);
        return doctorList;
    }

    @Override
    public List<Doctor> getDoctorByClinicId(Long clinicId) {
        List<Doctor> doctorList  =doctorMapper.getDoctorByClinicId(clinicId);
        return doctorList;
    }

    /**
     *
     * @param doctorId
     * @return
     */
    @Override
    public Doctor getDoctorById(Integer doctorId) {
        return baseMapper.selectById(doctorId);
    }

    @Override
    public PcDoctorDTO getDoctorById(Long id) {
        return doctorMapper.getDoctorById(id);
    }

    @Override
    public Boolean deleteDoctorById(Long doctorId) {
        return doctorMapper.deleteDoctorById(doctorId)>0?true:false;
    }

    @Override
    public Boolean examDoctor(Long doctorId, Long examStatusId, String examDetailResult, Long examPersonId) {
        return doctorMapper.examDoctor(doctorId,examStatusId,examDetailResult,examPersonId)>0?true:false;
    }

    @Override
    public List<Doctor> getDoctorList(Long clinicId) {
        return doctorMapper.getDoctorList(clinicId);
    }
}
