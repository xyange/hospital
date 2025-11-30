package com.wyzy.hospital.admin.kit.impl;

import com.wyzy.hospital.admin.api.entity.RegisterRecord;
import com.wyzy.hospital.admin.kit.RegisterRecordKitService;
import com.wyzy.hospital.admin.service.NumberQuantityService;
import com.wyzy.hospital.admin.service.RegisterRecordService;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 挂号记录插入实现类
 *
 * @author wrk
 * @date 2021/05/13 14:50
 **/
@Service
public class RegisterRecordKitServiceImpl implements RegisterRecordKitService {
    @Resource
    private RegisterRecordService registerRecordService;
    @Resource
    private NumberQuantityService numberQuantityService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R addRegisterRecord(RegisterRecord registerRecord) {
        Long hospitalId = registerRecord.getHospitalId();
        Long departmentId = registerRecord.getDepartmentId();
        Long doctorId = registerRecord.getDoctorId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finalDate = sdf.format(new Date(Long.valueOf(registerRecord.getRegisterTime() + "000")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(finalDate,formatter);
        LocalDate date = LocalDate.parse(finalDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Integer timeSlot = 0;
        if (dateTime.getHour() >= 12) {
            timeSlot = 1;
        }
        Integer number= numberQuantityService.getDetailNumberQuantity(hospitalId,departmentId,doctorId,date,timeSlot);
        if(number==0){
            return R.failed("挂号失败，暂无号源");
        }
        Boolean minusFlag = numberQuantityService.minusDateNumberQuantity(hospitalId, departmentId, doctorId, date, timeSlot);
        if (minusFlag) {
            Boolean addRegisterRecordFlag = registerRecordService.save(registerRecord);
            if (!addRegisterRecordFlag) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return R.failed("挂号失败");
            }else{
                return R.ok(true,"挂号成功");
            }
        } else {
            return R.failed("挂号失败");
        }


    }
}
