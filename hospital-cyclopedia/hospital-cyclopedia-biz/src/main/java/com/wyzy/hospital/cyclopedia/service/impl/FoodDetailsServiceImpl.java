
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.FoodDetailsDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodEnum;
import com.wyzy.hospital.cyclopedia.entity.FoodDetails;
import com.wyzy.hospital.cyclopedia.mapper.FoodDetailsMapper;
import com.wyzy.hospital.cyclopedia.service.FoodDetailsService;
import com.wyzy.hospital.cyclopedia.util.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 食物详情表
 *
 * @author hospital code generator
 * @date 2021-04-25 11:08:01
 */
@Service
public class FoodDetailsServiceImpl extends ServiceImpl<FoodDetailsMapper, FoodDetails> implements FoodDetailsService {
	@Resource
	FoodDetailsMapper foodDetailsMapper;



	@Override
	public List<FoodDetailsDTO> bySqlQueryFood(Long cid, String field, String sort) {
		StringBuilder sql=new StringBuilder();

		if(FoodEnum.getFields(field).getCode().equals(field)){
			sql.append(FoodEnum.getFields(field).getField());
		}

		if(FoodEnum.getFields(sort).getCode().equals(sort)){
			sql.append("  "+ FoodEnum.getFields(sort).getField());
		}
		return baseMapper.bySqlSelectFood(cid,sql.toString());
	}

	@Override
	public List<FoodDetailsDTO> bySqlSelectAllFood(Long fid, String field, String sort) {
		StringBuilder sql=new StringBuilder();

		if(FoodEnum.getFields(field).getCode().equals(field)){
			sql.append(FoodEnum.getFields(field).getField());
		}

		if(FoodEnum.getFields(sort).getCode().equals(sort)){
			sql.append("  "+ FoodEnum.getFields(sort).getField());
		}
		return baseMapper.bySqlSelectAllFood(fid,sql.toString());
	}

	@Override
	public void ChangeFoodStatus(Long id, String status) {
		LocalDateTime localDateTime = TimeUtil.utilTime();
		FoodDetailsDTO foodDetailsDTO=new FoodDetailsDTO();
		foodDetailsDTO.setFoodId(id);
		foodDetailsDTO.setFoodAuditTime(localDateTime);
			if("0".equals(status)){
				foodDetailsDTO.setFoodAuditStatus("1");
				foodDetailsDTO.setFoodCheckPassTime(localDateTime);
				foodDetailsMapper.alterFoodStatus(foodDetailsDTO);
			}else if ("1".equals(status)){
				foodDetailsDTO.setFoodAuditStatus("2");
				foodDetailsMapper.alterFoodStatus(foodDetailsDTO);
			} else if(status == "2"){
				foodDetailsDTO.setFoodAuditStatus("1");
				foodDetailsMapper.alterFoodStatus(foodDetailsDTO);
			}else {
				foodDetailsDTO.setFoodAuditStatus("1");
				foodDetailsMapper.alterFoodStatus(foodDetailsDTO);
			}
	}

	@Override
	public void ReSubmitAlterStatus(Long id, String status) {
		FoodDetailsDTO foodDetailsDTO=new FoodDetailsDTO();
		foodDetailsDTO.setFoodId(id);
		if("2".equals(status)){
			foodDetailsDTO.setFoodAuditStatus("0");
			foodDetailsMapper.alterFoodStatus(foodDetailsDTO);
		}
	}

	// 1-上线，2 代表下线

	@Override
	public void updateFoodStatus(Long foodId, String foodExistStatus) {

		try {
			if ("1".equals(foodExistStatus)) {
				foodDetailsMapper.updateFoodStatus(foodId, "2");
			} else if ("2".equals(foodExistStatus)) {
				foodDetailsMapper.updateFoodStatus(foodId, "1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String selectByFoodName(String foodName) {
		return baseMapper.getByFoodName(foodName);
	}

}
