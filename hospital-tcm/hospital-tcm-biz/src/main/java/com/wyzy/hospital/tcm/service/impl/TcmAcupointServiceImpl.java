
package com.wyzy.hospital.tcm.service.impl;

import com.alibaba.nacos.api.config.filter.IFilterConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmAcupointDTO;
import com.wyzy.hospital.tcm.entity.TcmAcupoint;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmAcupointMapper;
import com.wyzy.hospital.tcm.service.TcmAcupointService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@Service
public class TcmAcupointServiceImpl extends ServiceImpl<TcmAcupointMapper, TcmAcupoint> implements TcmAcupointService {
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@Override
	public IPage<TcmAcupointDTO> pageTcmAcupointDTO(IPage<TcmAcupointDTO> page) {
		//查询所有
		List<TcmAcupointDTO> tcmAcupointDTOList = baseMapper.selectAll();
		IPage<TcmAcupointDTO> tcmAcupointDTOIPage=page.setRecords(tcmAcupointDTOList);
		return tcmAcupointDTOIPage;
	}

	/**
	 * 上下线操作
	 * @param acupointId
	 * @param isOnline
	 * @return
	 */
	@Override
	public boolean goOnlineById(Long acupointId, Integer isOnline) {
		int i = 0;
		if (isOnline == 0){
			isOnline = 1;
			i = baseMapper.updateTcmAcupointById(acupointId,isOnline);
		}else if (isOnline == 1){
			isOnline = 0;
			i = baseMapper.updateTcmAcupointById(acupointId,isOnline);
		}
		if (i>0){
			return true;
		}
		return false;
	}

	/**
	 * 修改穴位表
	 * @param tcmAcupoint 穴位表
	 * @return R
	 */
	@Override
	public boolean updateTcmAcupointById(TcmAcupoint tcmAcupoint) {
		tcmAcupoint.setDelFlag(0);
		tcmAcupoint.setIsOnline(0);
		tcmAcupoint.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmAcupoint);
	}

	/**
	 * 根据经络ID查询经脉数据表是否存在值
	 * @param contextId
	 * @return
	 */
	@Override
	public List<TcmAcupointDTO> getByContextId(Long contextId) {
		List<TcmAcupointDTO> tcmAcupoints = baseMapper.selectByContextId(contextId);
		if (tcmAcupoints.size()!=0){
			return tcmAcupoints;
		}
		return null;
	}

	/**
	 * 通过id查询穴位表
	 * @param acupointId id
	 * @return R
	 */
	@Override
	public TcmAcupointDTO getById(Long acupointId) {
		TcmAcupointDTO byId = baseMapper.getById(acupointId);
		if (byId == null){
			return null;
		}
		return byId;
	}

	/**
	 * 通过name查询穴位表
	 * @param name id
	 * @return R
	 */
	@Override
	public TcmAcupointDTO getTcmAcupointDTOByName(String name) {
		TcmAcupointDTO acupointDTO = baseMapper.getTcmAcupointDTOByName(name);
		return acupointDTO;
	}

	/**
	 * 查询经络腧穴:两级分类及数据表，三层
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return R
	 */
	@Override
	public List<TcmSortListVO> getAcupointTcmSortListAPP() {
		return baseMapper.selectAcupointTcmSortListAPP();
	}

	/**
	 * 新增
	 * @param tcmAcupoint 穴位表
	 * @return
	 */
	@Override
	public boolean saveTcmAcupoint(TcmAcupoint tcmAcupoint) {
		TcmAcupoint acupoint = baseMapper.getTcmAcupointByName(tcmAcupoint.getAcupointName());
		if (acupoint != null){
			throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
		}
		int insert = baseMapper.insert(tcmAcupoint);
		if (insert>0){
			return true;
		}else {
			return false;
		}
	}
}
