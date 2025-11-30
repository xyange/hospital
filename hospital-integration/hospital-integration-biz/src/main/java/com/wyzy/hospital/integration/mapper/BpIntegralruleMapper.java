

package com.wyzy.hospital.integration.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 积分规则表
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
@Mapper
public interface BpIntegralruleMapper extends HospitalBaseMapper<BpIntegralrule> {

	/**
	 * 查询积分方式ID
	 * @param integralMethod 积分方式名称
	 * @param checkstatus （针对签到）方式
	 * @return
	 */
	@Select("select id from bp_integralrule where integral_method = #{integralMethod} and checkStatus = #{checkstatus}")
	Long selectIdByMethodAndTatus(@Param("integralMethod") String integralMethod,@Param("checkstatus") Integer checkstatus);

	/**
	 * 查询积分方式ID
	 * @param integralMethod
	 * @return
	 */
	@Select("select id from bp_integralrule where integral_method = #{integralMethod}")
	Long selectIdByMethod(@Param("integralMethod") String integralMethod);

	/**
	 * 修改每日任务
	 * @return R
	 */
	int updateIsEverydayById(@Param("id") Long id,@Param("isEveryday") Integer isEveryday);

	/**
	 * 查询任务列表
	 * @return R
	 */
	List<EveryDayDTO> selectPojoByIsEveryday(@Param("memberId") Long memberId, @Param("date") String date);

	/**
	 * 获取抵扣状态及抵扣配置
	 * @return
	 */
	BpIntegralrule selectNewestState();
}
