
package com.wyzy.hospital.integration.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import com.wyzy.hospital.integration.mapper.BpIntegralruleMapper;
import com.wyzy.hospital.integration.service.BpIntegralruleService;
import com.wyzy.hospital.integration.utils.DateTimeUtil;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 积分规则表
 *
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
@Service
public class BpIntegralruleServiceImpl extends ServiceImpl<BpIntegralruleMapper, BpIntegralrule> implements BpIntegralruleService {
	/**
	 * 查询积分方式ID
	 * @param integralMethod 积分方式名称
	 * @param checkstatus （针对签到）方式
	 * @return
	 */
	public Long getId(String integralMethod,Integer checkstatus){
		Long getId;
		if (integralMethod.equals("签到")){
			getId = baseMapper.selectIdByMethodAndTatus(integralMethod,checkstatus);
		}else {
			getId = baseMapper.selectIdByMethod(integralMethod);
		}
		if (getId != null){
			return getId;
		}else {
			return null;
		}
	}

	/**
	 * 新增积分规则表
	 * @param bpIntegralrule 积分规则表
	 * @return R
	 */
	@Override
	public boolean saveBpIntegralrule(BpIntegralrule bpIntegralrule) {
		/**
		 * IntegralMethod 积分方式名称
		 * Checkstatus 签到状态:(0按日签到，1：按连续签到)
		 */
		Long id = getId(bpIntegralrule.getIntegralMethod(), bpIntegralrule.getCheckstatus());
		Integer integer;
		if (id == null){
			integer =baseMapper.insert(bpIntegralrule);
		}else {
			bpIntegralrule.setId(id);
			integer =baseMapper.updateById(bpIntegralrule);
		}
		if(integer>0){
			return true;
		}
		return false;
	}

	/**
	 * 通过id查询积分规则表信息
	 * @param id id
	 * @return R
	 */
	@Override
	public BpIntegralruleDTO getBpIntegralruleById(Long id) {
		//通过id查询积分规则表信息
		BpIntegralrule bpIntegralrule = baseMapper.selectById(id);
		if (bpIntegralrule == null){
			return null;
		}
		//通过BeanUtils装载到DTO
		BpIntegralruleDTO bpIntegralruleDTO = new BpIntegralruleDTO();
		BeanUtils.copyProperties(bpIntegralrule,bpIntegralruleDTO);
		//连续签到规则
		String continuously =bpIntegralrule.getContinuously();
		if (continuously == null){
			return null;
		}
		//连续签到转化为数组
		String[] split = continuously.split(",");
		List<Integer> integerList = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			integerList.add(Integer.parseInt(split[i]));
		}
		bpIntegralruleDTO.setIntegralDays(integerList);
		return bpIntegralruleDTO;
	}

	/**
	 * 修改每日任务
	 * @return R
	 */
	@Override
	public boolean isEveryday(Long id,Integer isEveryday) {
		if (isEveryday == 0){
			isEveryday = 1;
		}else if (isEveryday == 1){
			isEveryday = 0;
		}
		int updateIsEveryday = baseMapper.updateIsEverydayById(id,isEveryday);
		if (updateIsEveryday>0){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 查询任务列表
	 * @return R
	 */
	@Override
	public List<EveryDayDTO> getPojoByIsEveryday(Long memberId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		List<EveryDayDTO> everyDayDTOS = baseMapper.selectPojoByIsEveryday(memberId, date);
		return everyDayDTOS;
	}

	/**
	 * 获取抵扣状态及抵扣配置
	 * @return
	 */
	@Override
	public BpIntegralrule selectNewestState() {
		return baseMapper.selectNewestState();
	}
}
