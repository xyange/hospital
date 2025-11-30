
package com.wyzy.hospital.doctor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.doctor.entity.Doctor;
import com.wyzy.hospital.doctor.mapper.DoctorMapper;
import com.wyzy.hospital.doctor.service.DoctorService;
import org.springframework.stereotype.Service;

/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-12 16:50:44
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

}
