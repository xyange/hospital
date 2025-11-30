

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.FoodDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodDetails;

import java.util.List;

/**
 * 食物详情表
 *
 * @author hospital code generator
 * @date 2021-04-25 11:08:01
 */
public interface FoodDetailsService extends IService<FoodDetails> {
	List<FoodDetailsDTO>bySqlQueryFood(Long cid, String field, String sort);

	//根据不同营养元素进行升序降序(显示全部)

	List<FoodDetailsDTO>bySqlSelectAllFood(Long fid, String field, String sort);

	//修改审核状态

	 void ChangeFoodStatus(Long id,String status);


	//后台重新提交审核

	void ReSubmitAlterStatus(Long id,String status);

   //后台上线下线

	void updateFoodStatus(Long foodId,String foodExistStatus);

	String selectByFoodName(String foodName);
}
