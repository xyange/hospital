
package com.wyzy.hospital.integration.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.mapper.BpIntegralMapper;
import com.wyzy.hospital.integration.service.BpIntegralService;
import com.wyzy.hospital.integration.utils.IntegrationEnum;
import com.wyzy.hospital.integration.vo.BpIntegralVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@Service
public class BpIntegralServiceImpl extends ServiceImpl<BpIntegralMapper, BpIntegral> implements BpIntegralService {

	/**
	 * 新增积分表
	 * @param bpIntegral 积分表
	 * @return R
	 */
	@Override
	public boolean saveIntegration(BpIntegral bpIntegral) {
		int insert = baseMapper.insert(bpIntegral);
		if (insert>0){
			return true;
		}
		return false;
	}

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --bpIntegral 积分表
	 * @return
	 */
	@Override
	public IPage<BpIntegralDTO> getBpIntegralPage(IPage<BpIntegralDTO> page) {
		List<BpIntegral> bpIntegralList = baseMapper.selectBpIntegralPage(page);
		List<BpIntegralDTO> bpIntegralDTOList = new ArrayList<>();
		if (bpIntegralList.size() != 0){
			for (BpIntegral bpIntegral:bpIntegralList){
				BpIntegralDTO bpIntegralDTO = new BpIntegralDTO();
				BeanUtils.copyProperties(bpIntegral,bpIntegralDTO);
				bpIntegralDTOList.add(bpIntegralDTO);
			}
		}
		IPage<BpIntegralDTO> bpIntegralDTOIPage = page.setRecords(bpIntegralDTOList);
		return bpIntegralDTOIPage;
	}

	/**
	 * 通过手机号和获取类别查询积分表
	 * @param --id id
	 * @return R
	 */
	@Override
	public IPage<BpIntegralDTO> getByPhoneAndtypeId(IPage<BpIntegralDTO> page,String phone,String typeName) {
		List<BpIntegralDTO> bpIntegralDTOList = baseMapper.selectByPhoneAndtypeId(page,phone,typeName);
		IPage<BpIntegralDTO> bpIntegralDTOIPage = page.setRecords(bpIntegralDTOList);
		return bpIntegralDTOIPage;
	}

	/**
	 *查询会员积分管理
	 * @param
	 * @return R
	 */
	@Override
	public List<BpIntegralVO> getBpIntegralGather(Integer minIntegral, Integer maxIntegral, String phone) {
		LocalDateTime time = getTime();
		List<BpIntegralVO> bpIntegralVOList = baseMapper.selectBpIntegralGather(minIntegral,maxIntegral,phone,time);
		return bpIntegralVOList;
	}

	private String returnSql(Integer indexQuery, Integer indexSort){
		if (indexQuery ==null || indexSort == null){
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder();
		String nameQuery = IntegrationEnum.getName(indexQuery);
		String nameSort = IntegrationEnum.getName(indexSort);
		stringBuilder.append("ORDER BY ");
		stringBuilder.append(nameQuery);
		stringBuilder.append(" ");
		stringBuilder.append(nameSort);
		return stringBuilder.toString();
	}

	/**
	 * 获取当前时间
	 */
	private LocalDateTime getTime(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar.add(Calendar.DATE, 0);
		String three_days_after = sdf.format(calendar.getTime());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(three_days_after,df);
		return ldt;
	}

	/**
	 * 查询会员积分排序
	 * @param
	 * @return R
	 */
	@Override
	public List<BpIntegralVO> querySort(Integer indexQuery, Integer indexSort, Integer minIntegral, Integer maxIntegral) {
		String sql = returnSql(indexQuery, indexSort);
		/**
		 * 根据积分区间和手机号查询后
		 * 根据积分排序
		 * */
		LocalDateTime time = getTime();
		List<BpIntegralVO> bpIntegralVOList = baseMapper.selectSortByIntegralAndPhone(minIntegral,maxIntegral,sql,time);
		return bpIntegralVOList;
	}

	/**
	 * 获取积分类别名称
	 * @return
	 */
	@Override
	public List<String> getTypeNameList() {
		return baseMapper.selectTypeNameList();
	}

	/**
	 * 获取昨天连续登录信息
	 * @param memberId
	 * @param typeId
	 * @param yesterdayDate
	 * @return
	 */
	@Override
	public BpIntegral getDateNumber(Long memberId, Long typeId, String yesterdayDate) {
		return baseMapper.selectDateNumber(memberId,typeId,yesterdayDate);
	}

	/**
	 * 收支详情
	 * @param memberId
	 * @param date
	 * @return
	 */
	@Override
	public List<BpIntegralDTO> revenueExpenditureDetails(Long memberId, String date) {
		return baseMapper.revenueExpenditureDetails(memberId,date);
	}

	/**
	 * 当日完成数量
	 * @param typeId
	 * @param memberId
	 * @return
	 */
	@Override
	public Integer selectExecutionTimes(Long typeId, Long memberId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		return baseMapper.selectExecutionTimes(typeId,memberId,date);
	}

	/**
	 * 获取抵扣金
	 * @return R
	 */
	@Override
	public Integer getDeductionByMemberId(Long memberId) {
		LocalDateTime time = getTime();
		Integer integer = baseMapper.selectDeductionByMemberId(memberId, time);
		return integer;
	}
}
