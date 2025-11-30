

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.CaseHistoryDTO;
import com.wyzy.hospital.admin.api.dto.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.CaseHistory;

import java.util.List;

/**
 * 病历表
 *
 * @author aqie
 * @date 2021-04-26 15:27:03
 */
public interface CaseHistoryService extends IService<CaseHistory> {



    List<PatientCardDTO> selectPatientNameByMemberId(Long memberId,Long cardId);

    List<CaseHistoryDTO> selectCaseHistoryByCardId(Long cardId);


}
