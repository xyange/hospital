

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.member.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.PatientCard;
import com.wyzy.hospital.common.core.util.R;

/**
 * 就诊卡
 *
 * @author aqie
 * @date 2021-04-26 15:23:39
 */
public interface PatientCardService extends IService<PatientCard> {


    /**
     * 根据身份证号查询就诊人信息
     * @param patientIdCard
     * @return
     */
    PatientCard getPojoByPatientIdCard(String patientIdCard,Long memberId);
}
