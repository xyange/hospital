
package com.wyzy.hospital.admin.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.DoctorDisease;
import com.wyzy.hospital.admin.mapper.DoctorDiseaseMapper;
import com.wyzy.hospital.admin.service.DoctorDiseaseService;
import org.springframework.stereotype.Service;

/**
 * 医生疾病关系表
 *
 * @author songM
 * @date 2021-05-27 16:43:37
 */
@Service
public class DoctorDiseaseServiceImpl extends ServiceImpl<DoctorDiseaseMapper, DoctorDisease> implements DoctorDiseaseService {
}
