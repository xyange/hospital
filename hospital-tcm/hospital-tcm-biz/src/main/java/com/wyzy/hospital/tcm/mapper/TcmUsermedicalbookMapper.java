

package com.wyzy.hospital.tcm.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.entity.TcmUsermedicalbook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * 医书收藏表
 *
 * @author hospital code generator
 * @date 2021-04-30 10:38:12
 */
@Mapper
public interface TcmUsermedicalbookMapper extends HospitalBaseMapper<TcmUsermedicalbook> {

	@Select("SELECT is_collect FROM tcm_usermedicalbook where user_id=#{userId} and medicalbook_id = #{medicalbookId}")
	Optional<Integer> isCollect(@Param("medicalbookId") long medicalbookId, @Param("userId") int userId);

	@Select("SELECT medicalbook_id FROM tcm_usermedicalbook where user_id=#{userId} and is_collect = 1")
	List<Long> getByUserId(@Param("userId") Long id);
}
