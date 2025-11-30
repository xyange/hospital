

package com.wyzy.hospital.integration.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.vo.BpIntegralVO;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
public interface BpIntegralService extends IService<BpIntegral> {

	/**
	 * 新增积分表
	 * @param bpIntegral 积分表
	 * @return R
	 */
	boolean saveIntegration(BpIntegral bpIntegral);


	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --bpIntegral 积分表
	 * @return
	 */
	IPage<BpIntegralDTO> getBpIntegralPage(IPage<BpIntegralDTO> page);

	/**
	 * 通过手机号和获取类别查询积分表
	 * @param --id id
	 * @return R
	 */
	IPage<BpIntegralDTO> getByPhoneAndtypeId(IPage<BpIntegralDTO> page,String phone,String typeName);

	/**
	 * 查询会员积分管理
	 * @param
	 * @return R
	 */
	List<BpIntegralVO> getBpIntegralGather(Integer minIntegral, Integer maxIntegral, String phone);

	/**
	 * 查询会员积分排序
	 * @param
	 * @return R
	 */
	List<BpIntegralVO> querySort(Integer indexQuery, Integer indexSort, Integer minIntegral, Integer maxIntegral);


	/**
	 * 获取积分类别名称
	 */
	List<String> getTypeNameList();

	/**
	 * 获取昨天连续登录信息
	 * @param memberId
	 * @param typeId
	 * @param yesterdayDate
	 * @return
	 */
	BpIntegral getDateNumber(Long memberId, Long typeId, String yesterdayDate);

	/**
	 * 收支详情
	 * @param memberId
	 * @param date
	 * @return
	 */
	List<BpIntegralDTO> revenueExpenditureDetails(Long memberId, String date);

	/**
	 * 当日完成数量
	 * @param typeId
	 * @param memberId
	 * @return
	 */
	Integer selectExecutionTimes(Long typeId, Long memberId);

	/**
	 * 获取抵扣金
	 * @return R
	 */
	Integer getDeductionByMemberId(Long memberId);
}
