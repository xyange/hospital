package com.wyzy.hospital.psychology.Kit;

import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wrk
 */
public interface PsychologistRecommendDetailKitService {

    /**
     * 心理医生详情
     * @param doctorId
     * @return
     */
    PsychologistRecommendDetailDTO getRecommendDoctorParticulars(Long doctorId,String year,String month);
}
