
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.CaseHistoryDTO;
import com.wyzy.hospital.admin.api.dto.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.CaseHistory;
import com.wyzy.hospital.admin.mapper.CaseHistoryMapper;
import com.wyzy.hospital.admin.service.CaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 病历表
 *
 * @author aqie
 * @date 2021-04-26 15:27:03
 */
@Service
public class CaseHistoryServiceImpl extends ServiceImpl<CaseHistoryMapper, CaseHistory> implements CaseHistoryService {
    @Autowired
    private CaseHistoryService caseHistoryService;

    @Override
    public List<PatientCardDTO> selectPatientNameByMemberId(Long memberId,Long cardId) {
        List<PatientCardDTO> patientCardDTOList = baseMapper.selectPatientNameByMemberId(memberId,cardId);
        for (PatientCardDTO pc:
        patientCardDTOList) {
           Integer num =baseMapper.selectPatientNum(pc.getCardId());
            pc.setPatientNum(num);
        }
        return  patientCardDTOList;
    }

    /**
    * @Description: 查询病例通过就诊卡
    * @Param: [cardId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.CaseHistoryDTO>
    * @Author: songM
    * @Date: 2021/6/18
    */
    @Override
    public List<CaseHistoryDTO> selectCaseHistoryByCardId(Long cardId) {
        return baseMapper.selectCaseHistoryByCardId(cardId);
    }
}
