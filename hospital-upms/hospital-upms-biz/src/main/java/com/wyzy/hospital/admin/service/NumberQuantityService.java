package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDTO;
import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO;
import com.wyzy.hospital.common.core.util.R;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wrk
 */
public interface NumberQuantityService {
    /**
     * 查近几天号源情况
     *
     * @param hospitalId   医院id
     * @param hospitalName 医院名称
     * @param deportmentId 科室id
     * @param  deportmentName 科室名称
     * @param nearDays     近几天
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDTO>
     * @author wrk
     * @date 2021/05/12 16:55
     */
    List<NumberQuantityDTO> getNumberQuantity(Long hospitalId,String hospitalName, Long deportmentId,String deportmentName, Integer nearDays);

    /**
     * 查某个日期的号源
     *
     * @param hospitalId       医院id
     * @param hospitalName 医院名称
     * @param deportmentId     科室id
     * @param  deportmentName 科室名称
     * @param registrationDate 挂号日期
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO>
     * @author wrk
     * @date 2021/05/12 18:11
     */

    List<NumberQuantityDetailsDTO> getNumberQuantityDetail(Long hospitalId, String hospitalName, Long deportmentId, String deportmentName, LocalDate registrationDate);


    /**
     * 添加挂号记录
     * @param hospitalId
     * @param deportmentId
     * @param doctorId
     * @param date 挂号日期
     * @param timeSlot 0：上午，1：下午
     * @return java.lang.Boolean
     * @author wrk
     * @date 2021/05/13 15:03
     */
    Boolean minusDateNumberQuantity(Long hospitalId, Long deportmentId, Long doctorId, LocalDate date, Integer timeSlot);


    /**
     * 查具体某个医生某个日期的号源
     * @param hospitalId
     * @param deportmentId
     * @param doctorId
     * @param date 挂号日期
     * @param timeSlot 0：上午，1：下午
     * @return java.lang.Boolean
     * @author wrk
     * @date 2021/05/13 15:03
     */
    Integer getDetailNumberQuantity(Long hospitalId, Long deportmentId, Long doctorId, LocalDate date, Integer timeSlot);



}
