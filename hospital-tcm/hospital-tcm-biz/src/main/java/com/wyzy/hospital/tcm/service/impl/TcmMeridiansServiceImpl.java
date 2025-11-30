
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmMeridiansDTO;
import com.wyzy.hospital.tcm.entity.TcmMeridians;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmMeridiansMapper;
import com.wyzy.hospital.tcm.service.TcmMeridiansService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
@Service
public class TcmMeridiansServiceImpl extends ServiceImpl<TcmMeridiansMapper, TcmMeridians> implements TcmMeridiansService {
	/**
	 * 根据ID查询经脉表信息
	 * @param meridiansId
	 */
	@Override
	public TcmMeridiansDTO getById(Long meridiansId) {
		return baseMapper.selectTcmMeridiansById(meridiansId);
	}

	/**
	 * 修改经脉表
	 * @param tcmMeridians 经脉表
	 * @return R
	 */
	@Override
	public boolean updatePojoById(TcmMeridians tcmMeridians) {
		tcmMeridians.setIsOnline(0);
		tcmMeridians.setDelFlag(0);
		tcmMeridians.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmMeridians);
	}

	/**
	 * 通过name查询经脉表DTO
	 * @param name name
	 * @return R
	 */
	@Override
	public TcmMeridiansDTO selectTcmMeridiansDTOByName(String name) {
		TcmMeridiansDTO meridians = baseMapper.selectTcmMeridiansDTOByName(name);
		return meridians;
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@Override
	public boolean goOnlineById(Long meridiansId, Integer isOnline) {
		if (isOnline == 0){
			isOnline =1;
		}else if (isOnline == 1){
			isOnline =0;
		}
		int i = baseMapper.updateTcmMeridiansById(meridiansId,isOnline);
		if (i>0){
			return true;
		}
		return false;
	}

	/**
	 * 通过经络contextId查询经脉表信息
	 * @param --contextId id
	 * @return R
	 */
	@Override
	public TcmMeridiansDTO getBycontextId(Long contextId,String meridiansName) {
		return baseMapper.selectBycontextId(contextId,meridiansName);
	}

	@Override
	public IPage<TcmMeridians> getTcmMeridiansPage(IPage<TcmMeridians> page) {
		List<TcmMeridians> tcmMeridiansList = baseMapper.getTcmMeridiansPage(page);
		IPage<TcmMeridians> tcmMeridiansIPage = page.setRecords(tcmMeridiansList);
		return tcmMeridiansIPage;
	}

	/**
	 * 添加
	 * @param tcmMeridians 经脉表
	 * @return
	 */
	@Override
	public boolean saveTcmMeridians(TcmMeridians tcmMeridians) {
			TcmMeridians meridians = baseMapper.selectTcmMeridiansByName(tcmMeridians.getMeridiansName());
			if (meridians != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmMeridians);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}
}
