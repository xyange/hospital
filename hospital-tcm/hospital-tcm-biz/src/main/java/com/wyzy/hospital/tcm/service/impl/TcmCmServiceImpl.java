
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmCmDTO;
import com.wyzy.hospital.tcm.entity.TcmCm;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmCmMapper;
import com.wyzy.hospital.tcm.service.TcmCmService;
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
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
@Service
public class TcmCmServiceImpl extends ServiceImpl<TcmCmMapper, TcmCm> implements TcmCmService {

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
		int i = baseMapper.updateTcmCmById(id,isOnline);
		if (i >0){
			return true;
		}
		return false;
	}

	/**
	 * 修改中药表
	 * @param tcmCm 中药表
	 * @return R
	 */
	@Override
	public boolean updateTcmCmById(TcmCm tcmCm) {
		tcmCm.setIsOnline(0);
		tcmCm.setDelFlag(0);
		tcmCm.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmCm);
	}

	/**
	 * 通过name查询中药DTO
	 * @param name id
	 * @return R
	 */
	@Override
	public TcmCmDTO selectTcmCmDTOByName(String name) {
		TcmCmDTO tcmCmDTO = baseMapper.selectTcmCmDTOByName(name);
		return tcmCmDTO;
	}

	/**
	 * 查询加一二级ID
	 * @param
	 * @return
	 */
	@Override
	public List<TcmCmDTO> selectCmOneTwoId() {
		return baseMapper.selectCmOneTwoId();
	}

	/**
	 * 根据中药二级分类ID查询 中药表信息
	 * @param sortId
	 * @return
	 */
	@Override
	public List<TcmCmDTO> getAllBySecondlevelId(Long sortId) {
		List<TcmCmDTO> bySecondlevelId = baseMapper.getAllBySecondlevelId(sortId);
		if (bySecondlevelId.size()!=0){
			return bySecondlevelId;
		}
		return null;
	}


	/**
	 * 通过Id查询中药表
	 * @param --onelevelId id
	 * @return R
	 */
	@Override
	public TcmCmDTO getById(Long id) {
		return baseMapper.getById(id);
	}

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --tcmCm 中药表
	 * @return
	 */
	@Override
	public IPage<TcmCmDTO> getTcmCmPage(IPage<TcmCmDTO> page) {
		List<TcmCmDTO> tcmCmDTOList= baseMapper.selectAll(page);
		IPage<TcmCmDTO> tcmCmDTOIPage = page.setRecords(tcmCmDTOList);
		return tcmCmDTOIPage;
	}

	/**
	 * 添加
	 * @param tcmCm
	 * @return
	 */
	@Override
	public boolean saveTcmCm(TcmCm tcmCm) {
			TcmCm cm = baseMapper.selectTcmCmByName(tcmCm.getChinamedicineName());
			if (cm != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmCm);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}

}
