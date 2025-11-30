

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.CaseHistoryDTO;
import com.wyzy.hospital.admin.api.dto.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.CaseHistory;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 病历表
 *
 * @author aqie
 * @date 2021-04-26 15:27:03
 */
@Mapper
public interface CaseHistoryMapper extends HospitalBaseMapper<CaseHistory> {
    /**
     * 根据会员id查询就诊人
     * @param memberId
     * @return
     */
    List<PatientCardDTO> selectPatientNameByMemberId(@Param("memberId") Long memberId,@Param("cardId")Long cardId);
    /**
    * @Description: 查询就诊次数根据就诊卡id
    * @Param: [cardId]
    * @return: java.lang.Integer
    * @Author: songM
    * @Date: 2021/6/18
    */
    Integer selectPatientNum(@Param("cardId") Long cardId);

    /**
    * @Description: 查询病例通过就诊卡
    * @Param: [cardId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.CaseHistoryDTO>
    * @Author: songM
    * @Date: 2021/6/18
    */
    List<CaseHistoryDTO> selectCaseHistoryByCardId(@Param("cardId") Long cardId);
    /**
    * @Description: 查询就诊人通过就诊卡id
    * @Param: [cardId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.PatientCardDTO>
    * @Author: songM
    * @Date: 2021/6/19
    */
    List<PatientCardDTO> selectPatientNameByCardId(Long cardId);
}
