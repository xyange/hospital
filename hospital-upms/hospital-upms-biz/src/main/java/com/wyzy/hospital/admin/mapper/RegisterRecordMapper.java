

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.RegisterRecordDTO;
import com.wyzy.hospital.admin.api.entity.RegisterRecord;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 挂号记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:25
 */
@Mapper
public interface RegisterRecordMapper extends HospitalBaseMapper<RegisterRecord> {

    /**
     * 查私人医生详情
     *
     * @param doctorName
     * @param doctorId
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author wrk
     * @date 2021/05/25 17:47
     */
    Map<String, Object> getPrivateDoctorDetail(@Param("doctorName") String doctorName, @Param("doctorId")Long doctorId);

    /**
     * 通过就诊卡ID查询挂号记录
     * @param cardId 就诊卡ID
     * @param userId
     * @return R
     */
    List<RegisterRecordDTO> selectPojoByCardId(@Param("cardId") Long cardId,@Param("userId")Long userId);
}
