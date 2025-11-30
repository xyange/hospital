
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.ClinicDTO;
import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;
import com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails;
import com.wyzy.hospital.admin.mapper.ClinicTechnologyDetailsMapper;
import com.wyzy.hospital.admin.service.ClinicTechnologyDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 诊所诊疗技术详情表
 *
 * @author songM
 * @date 2021-05-15 11:33:37
 */
@Service
public class ClinicTechnologyDetailsServiceImpl extends ServiceImpl<ClinicTechnologyDetailsMapper, ClinicTechnologyDetails> implements ClinicTechnologyDetailsService {
    /**
    * @Description: 根据诊所Id查所有的诊疗方案
    * @Param: [clinicId] 诊所id
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisTechnologyDTO>
    * @Author: songM
    * @Date: 2021/5/17
    */
    @Override
    public List<ClinicDiagnosis> getDiagnosisByClinicId(ClinicDTO clinicDTO) {
         return baseMapper.getDiagnosisByClinicId(clinicDTO);
    }

    /**
    * @Description: 通过技术id查询诊疗技术
    * @Param: [technologyId] 诊疗技术id
    * @return: com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails
    * @Author: songM
    * @Date: 2021/5/17
    */
    @Override
    public ClinicTechnologyDetails getClinicTechnologyByTechnologyId(Integer technologyId) {
        return baseMapper.getClinicTechnologyByTechnologyId(technologyId);
    }

    /**
    * @Description: 获取诊疗技术通过诊所id
    * @Param: [clinicDTO]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails>
    * @Author: songM
    * @Date: 2021/5/29
    */
    @Override
    public List<ClinicTechnologyDetails> getClinicTechnologyByClinicId(ClinicDTO clinicDTO) {
        return baseMapper.getClinicTechnologyByClinicId(clinicDTO);
    }
    /**
    * @Description: 根据诊疗项目id查诊疗技术列表
    * @Param: [page, clinicDTO]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicDiagnosis>
    * @Author: songM
    * @Date: 2021/5/31
    */
    @Override
    public List<ClinicTechnologyDetails> getTechnologyListByDiagnosisId(IPage<ClinicTechnologyDetails> page, ClinicDTO clinicDTO) {
        return baseMapper.getTechnologyListByDiagnosisId(page,clinicDTO);
    }
}
