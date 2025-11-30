
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmMedicalbookDTO;
import com.wyzy.hospital.tcm.entity.TcmMedicalbook;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmMedicalbookMapper;
import com.wyzy.hospital.tcm.service.TcmMedicalbookService;
import com.wyzy.hospital.tcm.service.TcmUsermedicalbookService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@Service
@AllArgsConstructor
public class TcmMedicalbookServiceImpl extends ServiceImpl<TcmMedicalbookMapper, TcmMedicalbook> implements TcmMedicalbookService {

	private final TcmUsermedicalbookService tcmUsermedicalbookService;

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@Override
	public boolean goOnlineById(Long medicalbookId, Integer isOnline) {
		if (isOnline == 0){
			isOnline = 1;
		}else if (isOnline == 1){
			isOnline = 0;
		}
		int i = baseMapper.updateIsOnlineById(medicalbookId,isOnline);
		if (i>0){
			return true;
		}
		return false;
	}

	@Override
	public List<TcmMedicalbookDTO> getByMultivalued(Long classicsId, Long sectId, Long subjectId, Long writerId) {
		return baseMapper.selectByMultivalued(classicsId,sectId,subjectId,writerId);
	}

	/**
	 * 修改医书表
	 * @param tcmMedicalbook 医书表
	 * @return R
	 */
	@Override
	public boolean updateTcmMedicalbookById(TcmMedicalbook tcmMedicalbook) {
		tcmMedicalbook.setDelFlag(0);
		tcmMedicalbook.setIsOnline(0);
		LocalDateTime localDateTime = DateTimeUtil.returnLocalDateTime();
		tcmMedicalbook.setUpdateTime(localDateTime);
		int i = baseMapper.updateTcmMedicalbookById(tcmMedicalbook);
		if (i>0){
			return true;
		}
		return false;
	}

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	@Override
	public TcmMedicalbookDTO getById(Long medicalbookId) {
		return baseMapper.getById(medicalbookId);
	}

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	@Override
	public TcmMedicalbookDTO getByIdAPP(Long id,Long medicalbookId) {
		TcmMedicalbookDTO byIdAPP = baseMapper.getByIdAPP(id, medicalbookId);
		if (byIdAPP == null){
			return null;
		}else {
			/**
			 * 修改浏览量
			 */
			Integer integer = baseMapper.updatePageViewById(byIdAPP.getMedicalbookId());
			if (integer>0){
				return byIdAPP;
			}
		}
		return null;
	}

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param --tcmMedicalbook 医书表
	 * @return
	 */
	@Override
	public IPage<TcmMedicalbookDTO> getTcmMedicalbookPage(IPage<TcmMedicalbookDTO> page) {
		List<TcmMedicalbookDTO> tcmMedicalbookDTOList = baseMapper.getTcmMedicalbookPage(page);
		IPage<TcmMedicalbookDTO> tcmMedicalbookDTOIPage = page.setRecords(tcmMedicalbookDTOList);
		return tcmMedicalbookDTOIPage;
	}

	@Override
	public List<TcmMedicalbookDTO> getcollectMedicalbook(Long id) {
		/*查询收藏医书ID集合*/
		List<Long> medicalbookList = tcmUsermedicalbookService.getByUserId(id);
		if (medicalbookList == null|| medicalbookList.size()==0){
			return null;
		}
		List<TcmMedicalbookDTO> tcmMedicalbookDTOList = baseMapper.getcollectMedicalbook(medicalbookList);
		return tcmMedicalbookDTOList;
	}

	/**
	 * 通过name查询医书表
	 * @param name name
	 * @return R
	 */
	@Override
	public TcmMedicalbook selectTcmMedicalbookByName(String name) {
		TcmMedicalbook medicalbook = baseMapper.selectTcmMedicalbookByName(name);
		return medicalbook;
	}

	/**
	 * 新增医书表
	 * @param tcmMedicalbook
	 * @return
	 */
	@Override
	public boolean saveTcmMedicalbook(TcmMedicalbook tcmMedicalbook) {
			TcmMedicalbook medicalbook = baseMapper.selectTcmMedicalbookByName(tcmMedicalbook.getMedicalbookName());
			if (medicalbook != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmMedicalbook);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}
}
