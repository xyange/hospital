
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmInternalDTO;
import com.wyzy.hospital.tcm.entity.TcmInternal;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmInternalMapper;
import com.wyzy.hospital.tcm.service.TcmInternalService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
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
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
@Service
public class TcmInternalServiceImpl extends ServiceImpl<TcmInternalMapper, TcmInternal> implements TcmInternalService {

	/**
	 * 上下线
	 * @param id
	 * @param isOnline
	 * @return
	 */
	@Override
	public boolean goOnlineById(Long id, Integer isOnline) {
		if (isOnline == 0){
			isOnline = 1;
		}else if (isOnline == 1){
			isOnline = 0;
		}
		int i = baseMapper.updateTcmInternalById(id,isOnline);
		if (i>0){
			return true;
		}
		return false;
	}

	/**
	 * 修改内科学表
	 * @param tcmInternal 内科学表
	 * @return R
	 */
	@Override
	public boolean updatePojoById(TcmInternal tcmInternal) {
		tcmInternal.setIsOnline(0);
		tcmInternal.setDelFlag(0);
		tcmInternal.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmInternal);
	}

	/**
	 * 通过内科学二级分类IDinternalsuperId查询内科学表
	 * @param --internalsuperId id
	 * @return R
	 */
	@Override
	public List<TcmInternalDTO> getAllByInternalsuperId(Long internalsuperId) {
		List<TcmInternalDTO> tcmInternals = baseMapper.selectAllByInternalsuperId(internalsuperId);
		if (tcmInternals.size()!=0){
			return tcmInternals;
		}
		return null;
	}

	/**
	 * 通过id查询内科学表
	 * @param id id
	 * @return R
	 */
	@Override
	public TcmInternalDTO getById(Long id) {
		return baseMapper.getById(id);
	}

	/**
	 * 通过name查询内科学表
	 * @param name name
	 * @return R
	 */
	@Override
	public TcmInternalDTO selectTcmInternalDTOByName(String name) {
		TcmInternalDTO internal = baseMapper.selectTcmInternalDTOByName(name);
		return internal;
	}

	/**
	 * 查询加一二级ID
	 * @return
	 */
	@Override
	public List<TcmInternalDTO> selectInternalOneTwoId() {
		return baseMapper.selectInternalOneTwoId();
	}

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --tcmInternal 内科学表
	 * @return
	 */
	@Override
	public IPage<TcmInternalDTO> getTcmInternalPage(IPage<TcmInternalDTO> page) {
		List<TcmInternalDTO> tcmInternalDTOList = baseMapper.getTcmInternalPage(page);
		IPage<TcmInternalDTO> tcmInternalDTOIPage = page.setRecords(tcmInternalDTOList);
		return tcmInternalDTOIPage;
	}

	/**
	 * 添加
	 * @param tcmInternal 内科学表
	 * @return
	 */
	@Override
	public boolean saveTcmInternal(TcmInternal tcmInternal) {
			TcmInternal internal = baseMapper.selectTcmInternalByName(tcmInternal.getDiseaseName());
			if (internal != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmInternal);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}

}
