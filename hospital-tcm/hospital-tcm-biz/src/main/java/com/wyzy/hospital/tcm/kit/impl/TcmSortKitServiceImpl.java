
package com.wyzy.hospital.tcm.kit.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.*;
import com.wyzy.hospital.tcm.entity.*;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.kit.TcmSortKitService;
import com.wyzy.hospital.tcm.service.*;
import com.wyzy.hospital.tcm.mapper.TcmSortMapper;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import com.wyzy.hospital.tcm.vo.TcmSortVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@Service
@AllArgsConstructor
public class TcmSortKitServiceImpl extends ServiceImpl<TcmSortMapper, TcmSort> implements TcmSortKitService {
	private TcmSortService tcmSortService;

	private TcmCmService tcmCmService;
	private TcmAcupointService tcmAcupointService;
	private TcmInternalService tcmInternalService;

	/**
	 * 中药：内科学：根据一级分类ID查询二级分类及数据表列表
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表
	 * @return R
	 */
	@Override
	public List<TcmSortVO> returnSecondaryData(Integer type,Long sortId) {
		/**
		 * 根据一级ID查询出二级集合列表
		 */
		List<TcmSort> tcmSortList = tcmSortService.getTcmSortListBySuperiorId(sortId);
		if (tcmSortList.isEmpty()){
			return null;
		}
		List list = new ArrayList(tcmSortList.size());
		for (TcmSort tcmSort:tcmSortList){
			list.add(tcmSort.getSortId());
		}
		List<TcmSortVO> tcmSortVOList;
		/**
		 * 根据分类类型及ID集合，查询数据表列表
		 */
		if (type == 2){
			tcmSortVOList = tcmSortService.selectCmTcmSortVOBySortIdList(list);
			return tcmSortVOList;
		}else if (type == 3){
			tcmSortVOList = tcmSortService.selectInternalTcmSortVOBySortIdList(list);
			return tcmSortVOList;
		}
		return null;
	}

	@Override
	public boolean removeById(Long sortId) {
		/*根据ID查询删除信息,和类型*/
		TcmSort tcmSort = tcmSortService.getById(sortId);
		if (tcmSort == null){
			return false;
		}
		Integer type = tcmSort.getType();
		/*如果上级ID为0则为一级ID可删除*/
		if (tcmSort.getSuperiorId()==0){
			/*一级分类需要验证二级分类*/
			List<TcmSort> tcmSortList = tcmSortService.getTcmSortListBySuperiorId(sortId);

			/*如果二级分类为空则可删除*/
			if ((tcmSortList == null || tcmSortList.size() == 0)){
				Integer integer = treeSort(type,sortId);
				if (integer==0){
					boolean removeById = tcmSortService.removeById(sortId);
						return removeById;
				}else {
					return false;
				}

			}else {
				return false;
			}
		}else {
			Integer integer = treeSort(type,sortId);
			if (integer==0) {
				/*如果二级分类为空则可删除*/
				boolean removeById = tcmSortService.removeById(sortId);
				return removeById;
			}else {
				return false;
			}
		}
	}

	/**
	 * 类型:类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * Integer type 分类表类型
	 * Long sortId 分类ID
	 * */
	public Integer treeSort(Integer type,Long sortId){
		Integer integer=1;
		if (type == 1){
			/**
			 * 根据分类表类型：1和分类ID，查询经脉数据表是否存在值
			 */
			List<TcmAcupointDTO> byAcupointId = tcmAcupointService.getByContextId(sortId);
			if (byAcupointId == null || byAcupointId.size()==0){
				integer = 0;
			}
		}else if (type == 2){
			/**
			 * 根据分类表类型：2和分类ID，查询中药数据表是否存在值
			 * 分类ID 是为 二级分类ID
			 */
			List<TcmCmDTO> bySecondlevelId = tcmCmService.getAllBySecondlevelId(sortId);
			if (bySecondlevelId ==null || bySecondlevelId.size()==0){
				integer = 0;
			}
		}else if (type == 3){
			/**
			 * 根据分类表类型：3和分类ID，查询内科学数据表是否存在值
			 * 分类ID 是为 二级分类ID
			 */
			List<TcmInternalDTO> byInternalsuperId = tcmInternalService.getAllByInternalsuperId(sortId);
			if (byInternalsuperId==null||byInternalsuperId.size()==0){
				integer = 0;
			}
		}
		return integer;
	}

	public List<TcmSortDTO> treeTcmSortDTO(List<TcmSort> tcmSortList){
		List<TcmSortDTO> tcmSortDTOList = new ArrayList<>();
		for (TcmSort tcmSort:tcmSortList){
			if (tcmSort.getSuperiorId()==0){
				TcmSortDTO tcmSortDTO = new TcmSortDTO();
				BeanUtils.copyProperties(tcmSort,tcmSortDTO);
				tcmSortDTOList.add(tcmSortDTO);
			}
		}
		/*循环存放一级科室的DepartmentsDTO*/
		for(TcmSortDTO tcmSortDTO:tcmSortDTOList){
			/*查询装入返回集合的一级科室的ID*/
			Long Id=tcmSortDTO.getSortId();
			int number =0;
			List<TcmSort> lis = new ArrayList<>();
			for(TcmSort tcmSort: tcmSortList){
				if(tcmSort.getSuperiorId().equals(Id)){
					number++;
					lis.add(tcmSort);
				}
			}
			tcmSortDTO.setTcmSortList(lis);
			tcmSortDTO.setTcmSortNumber(number);
		}
		return tcmSortDTOList;
	}

	/**
	 * 添加
	 * @param tcmSort 中医模块分类表
	 * @return
	 */
	@Override
	public boolean saveTcmSort(TcmSort tcmSort) {
		TcmSort sort = tcmSortService.selectTcmSortByName(tcmSort.getSortName());
		if (sort != null){
			throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
		}
		boolean save = tcmSortService.save(tcmSort);
		return save;
	}

	/**
	 * 根据type查询一级分类列表
	 * @param type --类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return
	 */
	@Override
	public List<TcmSortDTO> getTcmSortOneList(Integer type) {
		List<TcmSortDTO> tcmSortOneList = tcmSortService.getTcmSortOneList(type);
		if (type == 2){
			/**
			 * 查询一级ID下的数据数量
			 */
			List<TcmCmDTO> tcmCmDTOList = tcmCmService.selectCmOneTwoId();
			for (TcmSortDTO tcmSortDTO:tcmSortOneList){
				Long sortId = tcmSortDTO.getSortId();
				int number = 0 ;
				for (TcmCmDTO tcmCmDTO:tcmCmDTOList){
					Long onelevelId = tcmCmDTO.getOnelevelId();
					if (onelevelId.equals(sortId)){
						number++;
					}
				}
				tcmSortDTO.setTcmSortNumber(number);
			}
		}else if (type == 3){
			/**
			 * 查询一级ID下的数据数量
			 */
			List<TcmInternalDTO> tcmInternalDTOList = tcmInternalService.selectInternalOneTwoId();
			for (TcmSortDTO tcmSortDTO:tcmSortOneList){
				Long sortId = tcmSortDTO.getSortId();
				int number = 0 ;
				for (TcmInternalDTO tcmInternalDTO:tcmInternalDTOList){
					Long oneId = tcmInternalDTO.getOneId();
					if (oneId.equals(sortId)){
						number++;
					}
				}
				tcmSortDTO.setTcmSortNumber(number);
			}
		}
		return tcmSortOneList;
	}
}
