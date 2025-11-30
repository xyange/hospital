
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.Disease;
import com.wyzy.hospital.admin.api.vo.AppDiseaseVO;
import com.wyzy.hospital.admin.mapper.DiseaseMapper;
import com.wyzy.hospital.admin.service.DiseaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 13:45:04
 */
@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {

    @Override
    public List<Disease> appListCommonDiseaseOnDoctor() {
        return baseMapper.appListCommonDiseaseOnDoctor();
    }

    @Override
    public List<AppDiseaseVO> appListCommonDiseaseOnNeighborhood() {
        return baseMapper.appListCommonDiseaseOnNeighborhood();
    }
}
