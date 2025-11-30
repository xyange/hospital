package com.wyzy.hospital.psychology.service.impl;

import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.api.entity.MonthDate;
import com.wyzy.hospital.psychology.mapper.PsychologistRecommendDetailMapper;
import com.wyzy.hospital.psychology.mapper.PsychologistRecommendMapper;
import com.wyzy.hospital.psychology.service.PsychologistRecommendDetailService;
import com.wyzy.hospital.psychology.service.PsychologistRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: PsychologistRecommendKitServiceImpl<br/>
 * Description: <br/>
 * date: 2021/6/4 17:03<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Service
public class PsychologistRecommendDetailServiceImpl implements PsychologistRecommendDetailService {
    @Resource
    private PsychologistRecommendDetailMapper psychologistRecommendDetailMapper;

    /**
     * 心理医生详情
     * @param doctorId
     * @return
     */
    @Override
    public PsychologistRecommendDetailDTO getRecommendDoctorParticulars(Long doctorId) {
        PsychologistRecommendDetailDTO psychologistRecommendDetailDTO = psychologistRecommendDetailMapper.selectRecommendDoctorParticulars(doctorId);
        return psychologistRecommendDetailDTO;
    }

    /**
     * 查询每月挂号情况
     * year 年
     * month 月
     * @return
     */
    @Override
    public List<MonthDate> getDatime(Long doctorId,String format) {
        List<MonthDate> monthDate = psychologistRecommendDetailMapper.getDatime(doctorId,format);
        return monthDate;
    }
}
