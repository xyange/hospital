package com.wyzy.hospital.psychology.service;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ClassName: PsychologistRecommendService<br/>
 * Description: <br/>
 * date: 2021/6/4 17:02<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
public interface PsychologistRecommendService {

    /**
     * 查询满足条件ID集合
     * @param dayweek
     * @param week
     * @param counselId
     * @param minPrice
     * @param maxPrice
     * @param categoryId
     * @param serveId
     * @return
     */
    String getRecommendDoctorIdList(Date dayweek, Date week, Integer counselId, BigDecimal minPrice, BigDecimal maxPrice, Long categoryId, Long serveId);

    /**根据满足ID集合查询
     * @param longList
     * @return
     */
    List<PsychologistRecommendDTO> getRecommendByDoctorIds(String longList);

    /**
     * 查询咨询记录
     * @param memberId
     * @return
     */
    List<Long> getOrderIds(Long memberId);

    /**
     * 根据预约号查询信息
     * @param orderIds
     * @return
     */
    List<OrderRecordDTO> getOrderRecordDTOByOrderIds(List<Long> orderIds);
}
