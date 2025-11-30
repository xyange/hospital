package com.wyzy.hospital.psychology.service.impl;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.psychology.Kit.impl.PsychologistRecommendKitServiceImpl;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.mapper.PsychologistRecommendMapper;
import com.wyzy.hospital.psychology.service.PsychologistRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
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
public class PsychologistRecommendServiceImpl implements PsychologistRecommendService {
    @Resource
    private PsychologistRecommendMapper psychologistRecommendMapper;

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
    @Override
    public String getRecommendDoctorIdList(Date dayweek, Date week, Integer counselId, BigDecimal minPrice, BigDecimal maxPrice, Long categoryId, Long serveId) {
        String longList =psychologistRecommendMapper.selectRecommendDoctorIdList(dayweek,week,counselId,minPrice,maxPrice,categoryId,serveId);
        return longList;
    }

    /**
     * 根据满足ID集合查询
     * @param longList
     * @return
     */
    @Override
    public List<PsychologistRecommendDTO> getRecommendByDoctorIds(String longList) {
        List<PsychologistRecommendDTO> list = psychologistRecommendMapper.selectRecommendByDoctorIds(longList);
        return list;
    }

    /**
     * 查询咨询记录
     * @param memberId
     * @return
     */
    @Override
    public List<Long> getOrderIds(Long memberId) {
        return psychologistRecommendMapper.selectOrderIds(memberId);
    }

    /**
     * 根据预约号查询信息
     * @param orderIds
     * @return
     */
    @Override
    public List<OrderRecordDTO> getOrderRecordDTOByOrderIds(List<Long> orderIds) {
        return psychologistRecommendMapper.selectOrderRecordDTOByOrderIds(orderIds);
    }
}
