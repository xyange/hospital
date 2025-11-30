
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmBookattrDTO;
import com.wyzy.hospital.tcm.entity.TcmBookattr;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmBookattrMapper;
import com.wyzy.hospital.tcm.service.TcmBookattrService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
@Service
public class TcmBookattrServiceImpl extends ServiceImpl<TcmBookattrMapper, TcmBookattr> implements TcmBookattrService {

	/**
	 * 新增医书属性表
	 * @param tcmBookattr 医书属性表
	 * @return R
	 */
	@Override
	public boolean saveBookattr(TcmBookattr tcmBookattr) {
			TcmBookattr bookattr = baseMapper.selectByName(tcmBookattr.getBookattrName());
			if (bookattr != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmBookattr);
			if (insert>0){
				return true;
			}else {
				return false;
			}
	}

	/**
	 * 分页
	 * @param type
	 * @param page
	 * @return
	 */
	@Override
	public IPage<TcmBookattrDTO> Bookattrpage(Integer type, IPage<TcmBookattrDTO> page) {
		/**
		 * 查询所有
		 */
		List<TcmBookattrDTO> tcmBookattrDTOList = baseMapper.selectAll(type,page);
		IPage<TcmBookattrDTO> tcmBookattrDTOIPage = page.setRecords(tcmBookattrDTOList);
		return tcmBookattrDTOIPage;
	}

	/**
	 * 查看树状列表
	 * @return
	 */
	@Override
	public List getTcmBookattrList() {
		/**
		 * 查看一级ID列表
		 */
		List<Integer> integerList = baseMapper.selectType();
		List<TcmBookattr> tcmBookattrList = baseMapper.selectTcmBookattrList();
		List list = new ArrayList<>();
		for (Integer integer:integerList){
			TcmBookattrDTO tcmBookattrDTO = new TcmBookattrDTO();
			tcmBookattrDTO.setType(integer);
			List<TcmBookattr> tcmBookattrs = new ArrayList<>();
			for (TcmBookattr tcmBookattr:tcmBookattrList){
				if (tcmBookattr.getType().equals(integer)){
					tcmBookattrs.add(tcmBookattr);
				}
			}
			tcmBookattrDTO.setTcmBookattrList(tcmBookattrs);
			list.add(tcmBookattrDTO);
		}

		return list;
	}

	/**
	 * 修改
	 * @param tcmBookattr 医书属性表
	 * @return
	 */
	@Override
	public boolean updateTcmBookattrById(TcmBookattr tcmBookattr) {
		tcmBookattr.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		tcmBookattr.setDelFlag(0);
		return baseMapper.updatePojoById(tcmBookattr);
	}

	/**
	 * 通过name查询医书属性表
	 * @param name name
	 * @return R
	 */
	@Override
	public TcmBookattrDTO selectPojoDTOByName(String name) {
		TcmBookattrDTO bookattrDTO = baseMapper.selectPojoDTOByName(name);
		return bookattrDTO;
	}

	/**
	 * 根据type查询
	 * @param type
	 * @return
	 */
	@Override
	public List<TcmBookattrDTO> getTcmBookattrByType(Integer type) {
		return baseMapper.selectTcmBookattrByType(type);
	}
}
