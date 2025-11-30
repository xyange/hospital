
package com.wyzy.hospital.doctor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.doctor.entity.DoctorService;
import com.wyzy.hospital.doctor.mapper.DoctorServiceMapper;
import com.wyzy.hospital.doctor.service.DoctorServiceService;
import org.springframework.stereotype.Service;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@Service
public class DoctorServiceServiceImpl extends ServiceImpl<DoctorServiceMapper, DoctorService> implements DoctorServiceService {

}
