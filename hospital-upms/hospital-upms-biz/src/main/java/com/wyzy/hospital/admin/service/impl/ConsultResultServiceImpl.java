
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.entity.ConsultResult;
import com.wyzy.hospital.admin.mapper.ConsultResultMapper;
import com.wyzy.hospital.admin.service.ConsultResultService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会诊结果表
 * @author songM
 * @date 2021-06-17 18:04:03
 */
@Service
public class ConsultResultServiceImpl extends ServiceImpl<ConsultResultMapper, ConsultResult> implements ConsultResultService {
    /**
    * @Description: 查询会诊结果通过就诊卡id
    * @Param: [consultOrder]
    * @return: com.wyzy.hospital.admin.api.entity.ConsultResult
    * @Author: songM
    * @Date: 2021/6/18
    */
    @Override
    public List<ConsultResult> selectConsultResultsByCardId(ConsultOrderDTO consultOrder) {
        return baseMapper.selectConsultResultsByCardId(consultOrder);
    }
}
