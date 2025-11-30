package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.api.entity.MonthDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: PsychologistRecommendMapper<br/>
 * Description: <br/>
 * date: 2021/6/4 17:10<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Mapper
public interface PsychologistRecommendDetailMapper {

    /**
     * 心理医生详情
     * @param doctorId
     * @return
     */
    PsychologistRecommendDetailDTO selectRecommendDoctorParticulars(@Param("doctorId") Long doctorId);

    /**
     * 查询每月挂号情况
     * year 年
     * month 月
     * @return
     */
    List<MonthDate> getDatime(@Param("doctorId") Long doctorId,@Param("format") String format);
}
