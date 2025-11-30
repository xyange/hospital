package com.wyzy.hospital.admin.kit;

import com.wyzy.hospital.admin.api.dto.member.PatientCardDTO;
import com.wyzy.hospital.common.core.util.R;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/27  9:34
 * @Function:
 */
public interface PatientCardKitService {
    /**
     * app 获取会员就诊人列表
     * @param memberId
     * @return
     */
    List<PatientCardDTO> getPatientCard(Long memberId);

    /**
     * 新增就诊人
     * @param patientCardDTO
     * @return
     */
    boolean addPatientCard(PatientCardDTO patientCardDTO);

    /**
     * 通过id查询就诊卡
     * @param cardId id
     * @return R
     */
    PatientCardDTO getById(Long cardId);

    /**
     * 修改就诊卡
     * @param patientCardDTO 就诊卡
     * @return R
     */
    boolean updateById(PatientCardDTO patientCardDTO);
}
