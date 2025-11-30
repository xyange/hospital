package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDTO;
import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wrk
 */
@Mapper
public interface NumberQuantityMapper {
    /**
     * 查近几天号源情况
     *
     * @param hospitalId   医院id
     * @param hospitalName   医院名称
     * @param deportmentId 科室id
     * @param deportmentName 科室名称
     * @param nearDays     近几天
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDTO>
     * @author wrk
     * @date 2021/05/12 16:55
     */
    List<NumberQuantityDTO> getNumberQuantity(@Param("hospitalId") Long hospitalId,
                                              @Param("hospitalName") String hospitalName,
                                              @Param("deportmentId") Long deportmentId,
                                              @Param("deportmentName") String deportmentName,
                                              @Param("nearDays") Integer nearDays);

    /**
     * 查某个日期的号源
     *
     * @param hospitalId       医院id
     * @param hospitalName   医院名称
     * @param deportmentId     科室id
     * @param deportmentName 科室名称
     * @param registrationDate 挂号日期
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO>
     * @author wrk
     * @date 2021/05/12 18:11
     */
    List<NumberQuantityDetailsDTO> getNumberQuantityDetail(@Param("hospitalId") Long hospitalId,
                                                           @Param("hospitalName") String hospitalName,
                                                           @Param("deportmentId") Long deportmentId,
                                                           @Param("deportmentName") String deportmentName,
                                                           @Param("registrationDate") LocalDate registrationDate);

    /**
     * 号源减1
     *
     * @param hospitalId
     * @param deportmentId
     * @param doctorId
     * @param registrationDate
     * @param timeSlot
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/05/13 15:21
     */
    Integer minusDateNumberQuantity(@Param("hospitalId") Long hospitalId, @Param("deportmentId") Long deportmentId,
                                    @Param("doctorId") Long doctorId, @Param("registrationDate") LocalDate registrationDate,
                                    @Param("timeSlot") Integer timeSlot);


    /**
     * 查具体到医生的某天的号源情况
     *
     * @param hospitalId
     * @param deportmentId
     * @param doctorId
     * @param date
     * @param timeSlot
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO>
     * @author wrk
     * @date 2021/05/14 09:43
     */
    Integer getDetailNumberQuantity(@Param("hospitalId") Long hospitalId, @Param("deportmentId") Long deportmentId,
                                                           @Param("doctorId") Long doctorId, @Param("date") LocalDate date,
                                                           @Param("timeSlot") Integer timeSlot);
    
}
