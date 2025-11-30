package com.wyzy.hospital.cyclopedia.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.cyclopedia.dto.AddFoodDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodDetails;
import com.wyzy.hospital.cyclopedia.exception.GlobalException;
import com.wyzy.hospital.cyclopedia.kit.AddFoodKitService;
import com.wyzy.hospital.cyclopedia.mapper.FoodDetailsMapper;
import com.wyzy.hospital.cyclopedia.service.FoodDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/24  14:52
 */
@Service
@AllArgsConstructor
public class AddFoodKitServicelmpl extends ServiceImpl<FoodDetailsMapper, FoodDetails>implements AddFoodKitService {

	private final FoodDetailsService foodDetailsService;


	@Transactional
	@Override
	public boolean addFoodKitService(AddFoodDTO addFoodDTO) {

		String foodName = foodDetailsService.selectByFoodName(addFoodDTO.getFoodDetails().getFoodName());
		if (foodName == null) {
			foodDetailsService.save(addFoodDTO.getFoodDetails());
		}else {
			throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
		}
		return true;
	}
}
