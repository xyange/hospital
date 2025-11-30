package com.wyzy.hospital.psychology.Kit;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.api.entity.PsychologyImg;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wrk
 */
public interface PsychologistRecommendKitService {

    /**
     * app推荐心理医生
     * @param sex 性别
     * @param area 地址
     * @param day 可见日期
     * @param counselId  咨询类型
     * @param minPrice 小价格
     * @param maxPrice 大价格
     * @return
     */
	List<PsychologistRecommendDTO> getRecommendDoctorIds(Integer sex, String area, Integer day, Integer counselId, BigDecimal minPrice, BigDecimal maxPrice,Long categoryId,Long serveId);

    /**
     * 查询咨询记录
     * @param memberId
     * @return
     */
    List<OrderRecordDTO> getOrderrecordDTO(Long memberId);
}
