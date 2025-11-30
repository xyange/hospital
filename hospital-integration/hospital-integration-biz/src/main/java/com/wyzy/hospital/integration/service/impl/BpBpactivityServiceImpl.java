
package com.wyzy.hospital.integration.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.integration.dto.BpBpactivityDTO;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpBpactivity;
import com.wyzy.hospital.integration.mapper.BpBpactivityMapper;
import com.wyzy.hospital.integration.service.BpBpactivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 积分活动表
 *
 * @author hospital code generator
 * @date 2021-05-08 16:09:33
 */
@Service
public class BpBpactivityServiceImpl extends ServiceImpl<BpBpactivityMapper, BpBpactivity> implements BpBpactivityService {

	/**
	 * 通过id删除积分活动表
	 * 如果上线，不许删除
	 * @param id id
	 * @return R
	 */
	@Override
	public boolean removeById(Long id) {
		/*查询上线状态*/
		Integer fluctuate = baseMapper.selectBpactivityById(id);
		if (fluctuate == 0 ){
			Integer i = baseMapper.deleteById(id);
			if (i>0){
				return true;
			}
		}
		return false;
	}

	/**
	 * 上线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	@Override
	public boolean OnlineById(Long id) {
		return baseMapper.OnlineById(id);
	}

	/**
	 * 下线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	@Override
	public boolean OfflineById(Long id) {
		return baseMapper.OfflineById(id);
	}

	/**
	 * 分页查询
	 * @return
	 */
	@Override
	public IPage<BpBpactivityDTO> getBpBpactivityPage(IPage<BpBpactivityDTO> page) {
		List<BpBpactivityDTO> bpBpactivityList = baseMapper.selectBpBpactivityPage(page);
		IPage<BpBpactivityDTO> bpBpactivityDTOIPage = page.setRecords(bpBpactivityList);
		return bpBpactivityDTOIPage;
	}
}
