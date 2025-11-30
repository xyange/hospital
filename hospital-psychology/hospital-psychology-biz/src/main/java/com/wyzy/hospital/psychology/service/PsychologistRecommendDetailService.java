package com.wyzy.hospital.psychology.service;

import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.api.entity.MonthDate;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: PsychologistRecommendService<br/>
 * Description: <br/>
 * date: 2021/6/4 17:02<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
public interface PsychologistRecommendDetailService {
    /**
     * 心理医生详情
     * @param doctorId
     * @return
     */
    PsychologistRecommendDetailDTO getRecommendDoctorParticulars(Long doctorId);

    /**
     * 查询每月挂号情况
     * @return
     */
    List<MonthDate> getDatime(Long doctorId,String format);
}
