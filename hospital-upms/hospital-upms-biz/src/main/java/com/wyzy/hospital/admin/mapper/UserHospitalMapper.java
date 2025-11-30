

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.UserHospital;
import com.wyzy.hospital.admin.api.vo.hospital.HospitalsCollectVO;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * 用户医院收藏中间表
 *
 * @author aqie
 * @date 2021-04-17 14:48:05
 */
@Mapper
public interface UserHospitalMapper extends HospitalBaseMapper<UserHospital> {

    @Select("SELECT is_collect FROM user_hospital where user_id=#{userId} and hospital_id = #{hospitalId}")
    Optional<Integer> isCollect(@Param("hospitalId") long hospitalId,@Param("userId") Long userId);

    /**
     * 查收藏的医院
     * @param userId 用户id
     *
     * @author wrk
     * @date 2021/05/25 14:49
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO>
     */
    List<HospitalsCollectVO> getCollectedHospital(@Param("userId")Long userId);
}
