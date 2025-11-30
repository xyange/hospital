package com.wyzy.hospital.admin.kit.impl;

import com.wyzy.hospital.admin.api.dto.PcDoctorDTO;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.api.entity.DoctorAttribution;
import com.wyzy.hospital.admin.api.entity.DoctorServe;
import com.wyzy.hospital.admin.kit.DoctorKitService;
import com.wyzy.hospital.admin.service.DoctorAttributionService;
import com.wyzy.hospital.admin.service.DoctorServeService;
import com.wyzy.hospital.admin.service.DoctorService;
import com.wyzy.hospital.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wrk
 */
@Slf4j
@Service
public class DoctorKitServiceImpl implements DoctorKitService {

    private static final Long WAIT_EXAM=138L;
    @Resource
    private DoctorService doctorService;
    @Resource
    private DoctorAttributionService doctorAttributionService;
    @Resource
    private DoctorServeService doctorServeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Boolean> addDoctor(PcDoctorDTO doctor) {
        Doctor doctorPo = doctor.transformDoctor();
        doctorPo.setExamStatusId(WAIT_EXAM);
        Boolean doctorAddFlag =false;
        try{
            doctorAddFlag=doctorService.save(doctorPo);
        }catch (Exception e){
            log.error(e.getMessage());
           return  R.failed(false,"医生姓名重复，请重新添加");
        }

        List<DoctorAttribution> list = new ArrayList<>();
        if (doctor.getAttributionOne() != null && doctor.getInstitutionOne() != null) {
            list.add(new DoctorAttribution(doctorPo.getDoctorId(), doctor.getInstitutionOne(), doctor.getAttributionOne()));
        }
        if (doctor.getAttributionTwo() != null && doctor.getInstitutionTwo() != null) {
            list.add(new DoctorAttribution(doctorPo.getDoctorId(), doctor.getInstitutionTwo(), doctor.getAttributionTwo()));
        }
        if (list.size() == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  R.failed(false,"添加失败");
        }
        if (!doctorAddFlag) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  R.failed(false,"添加失败");
        }
        Boolean attrAddFlag = doctorAttributionService.batchAddDoctorAttribution(list);
        if (!attrAddFlag) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  R.failed(false,"添加失败");
        }
        //添加医生服务
        String serve=doctor.getServe();
        String [] service=serve.split(",");
        for(String id:service){
            Integer intId=Integer.parseInt(id);
            DoctorServe doctorServe=new DoctorServe();
            doctorServe.setDocId(doctorPo.getDoctorId());
            doctorServe.setServiceId(intId);
            doctorServe.setPrice(BigDecimal.ZERO);
           Boolean serveFlag= doctorServeService.save(doctorServe);
           if(!serveFlag){
               TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
               return  R.failed(false,"添加失败");
           }
        }
        return  R.ok(true,"添加成功");
    }
    @Override
    public Boolean editDoctorById(PcDoctorDTO doctor) {
        Doctor doctorPo = doctor.transformDoctor();
        Boolean doctorEditFlag = doctorService.updateById(doctorPo);
        List<DoctorAttribution> list = new ArrayList<>();
        if (doctor.getAttributionOne() != null && doctor.getInstitutionOne() != null) {
            list.add(new DoctorAttribution(doctorPo.getDoctorId(), doctor.getInstitutionOne(), doctor.getAttributionOne()));
        }
        if (doctor.getAttributionTwo() != null && doctor.getInstitutionTwo() != null) {
            list.add(new DoctorAttribution(doctorPo.getDoctorId(), doctor.getInstitutionTwo(), doctor.getAttributionTwo()));
        }
        if (list.size() == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        if (!doctorEditFlag) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        Boolean attrDeleteFlag = doctorAttributionService.batchDeleteDoctorAttribution(doctorPo.getDoctorId());
        if (!attrDeleteFlag) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        Boolean attrAddFlag = doctorAttributionService.batchAddDoctorAttribution(list);
        if (!attrAddFlag) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }
}
