

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.RegisterRecordDTO;
import com.wyzy.hospital.admin.api.entity.RegisterRecord;

import java.util.Map;

import java.util.List;

/**
 * 挂号记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:25
 */
public interface RegisterRecordService extends IService<RegisterRecord> {

    /**
     * 查私人医生详情
     *
     * @param doctorName
     * @param doctorId
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author wrk
     * @date 2021/05/25 17:45
     */
    Map<String, Object> getPrivateDoctorDetail(String doctorName, Long doctorId);


    /**
     * 通过就诊卡ID查询挂号记录
     * @param cardId 就诊卡ID
     * @return R
     */
    List<RegisterRecordDTO> getPojoByCardId(Long cardId);
}
