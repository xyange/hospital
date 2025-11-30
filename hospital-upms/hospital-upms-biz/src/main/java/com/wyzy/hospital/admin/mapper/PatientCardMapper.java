

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.member.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.PatientCard;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 就诊卡
 *
 * @author aqie
 * @date 2021-04-26 15:23:39
 */
@Mapper
public interface PatientCardMapper extends HospitalBaseMapper<PatientCard> {

    List<PatientCard> getPatientCard(Long memberId);

    /**
     * 新增就诊卡
     * @param patientIdCard 就诊卡
     * @return R
     */
    PatientCard selectPojoByPatientIdCard(@Param("patientIdCard") String patientIdCard,@Param("memberId") Long memberId);
}
