package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
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
public interface PsychologistRecommendMapper {

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
    String selectRecommendDoctorIdList(@Param("dayweek") Date dayweek,@Param("week") Date week,@Param("counselId") Integer counselId,
                                           @Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice,
                                           @Param("categoryId") Long categoryId, @Param("serveId") Long serveId);

    /**
     * 根据满足ID集合查询
     * @param longList
     * @return
     */
    List<PsychologistRecommendDTO> selectRecommendByDoctorIds(@Param("longList") String longList);

    /**
     * 查询咨询记录
     * @param memberId
     * @return
     */
    List<Long> selectOrderIds(@Param("memberId") Long memberId);

    /**
     * 根据预约号查询信息
     * @param orderIds
     * @return
     */
    List<OrderRecordDTO> selectOrderRecordDTOByOrderIds(@Param("orderIds") List<Long> orderIds);
}
