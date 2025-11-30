
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.member.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.PatientCard;
import com.wyzy.hospital.admin.exception.GlobalException;
import com.wyzy.hospital.admin.mapper.PatientCardMapper;
import com.wyzy.hospital.admin.service.PatientCardService;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * 就诊卡
 *
 * @author aqie
 * @date 2021-04-26 15:23:39
 */
@Service
public class PatientCardServiceImpl extends ServiceImpl<PatientCardMapper, PatientCard> implements PatientCardService {

    /**
     * 新增就诊卡
     * @param patientIdCard 就诊卡
     * @return R
     */
    @Override
    public PatientCard getPojoByPatientIdCard(String patientIdCard,Long memberId) {
        return baseMapper.selectPojoByPatientIdCard(patientIdCard,memberId);
    }
}
