

package com.wyzy.hospital.integration.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.vo.BpIntegralVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@Mapper
public interface BpIntegralMapper extends HospitalBaseMapper<BpIntegral> {

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --bpIntegral 积分表
	 * @return
	 */
	List<BpIntegral> selectBpIntegralPage(IPage<BpIntegralDTO> page);

	/**
	 * 通过手机号和获取类别查询积分表
	 * @param --id id
	 * @return R
	 */
	List<BpIntegralDTO> selectByPhoneAndtypeId(IPage<BpIntegralDTO> page,@Param("phone") String phone,@Param("typeName") String typeName);

	/**
	 * 查询会员积分管理
	 * @param
	 * @return R
	 */
	List<BpIntegralVO> selectBpIntegralGather(@Param("minIntegral") Integer minIntegral,
											  @Param("maxIntegral") Integer maxIntegral,
											  @Param("phone") String phone,
											  @Param("time") LocalDateTime ldt);

	List<BpIntegralVO> selectSortByIntegralAndPhone(@Param("minIntegral") Integer minIntegral,
													 @Param("maxIntegral") Integer maxIntegral,
													 @Param("sql") String sql,
													 @Param("time") LocalDateTime time);

	/**
	 * 	查询用户连续签到的天数量
	 * @param phone 手机号
	 * @param id 规格ID
	 * @return
	 */
	@Select("select count(*) from bp_integral where  type_id = #{typeId} and phone =#{phone}")
	Integer selectNumberByDate(@Param("phone") String phone,@Param("typeId") Long id,@Param("pastDate") String pastDate);

	/**
	 * 获取积分类别名称
	 * @return
	 */
	List<String> selectTypeNameList();

	/**
	 * 获取昨天连续登录信息
	 * @param memberId
	 * @param typeId
	 * @param yesterdayDate
	 * @return
	 */
	BpIntegral selectDateNumber(@Param("memberId") Long memberId,@Param("typeId") Long typeId,@Param("yesterdayDate") String yesterdayDate);

	/**
	 * 收支详情
	 * @param memberId
	 * @param date
	 * @return
	 */
	List<BpIntegralDTO> revenueExpenditureDetails(@Param("memberId") Long memberId,@Param("date") String date);

	/**
	 * 当日完成数量
	 * @param typeId
	 * @param memberId
	 */
	Integer selectExecutionTimes(@Param("typeId") Long typeId,@Param("memberId") Long memberId,@Param("date") String date);

	/**
	 * 获取抵扣金
	 */
	Integer selectDeductionByMemberId(@Param("memberId") Long memberId,@Param("time") LocalDateTime ldt);
}
