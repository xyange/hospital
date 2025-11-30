
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.EnMedicine;
import com.wyzy.hospital.admin.mapper.EnMedicineMapper;
import com.wyzy.hospital.admin.service.EnMedicineService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:35
 */
@Service
public class EnMedicineServiceImpl extends ServiceImpl<EnMedicineMapper, EnMedicine> implements EnMedicineService {

    @Override
    public List<EnMedicine> lookEnMedicineByDiseaseName(String diseaseName) {
        return baseMapper.selectEnMedicineByDiseaseName(diseaseName);
    }
}
