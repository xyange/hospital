

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.FoodDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 食物详情表
 *
 * @author hospital code generator
 * @date 2021-04-25 11:08:01
 */
@Mapper
public interface FoodDetailsMapper extends HospitalBaseMapper<FoodDetails> {
	//根据不同营养元素进行升序降序（根据选择二级显示）

	List<FoodDetailsDTO>bySqlSelectFood(@Param("cid") Long fid, @Param("sql") String sql);

	//根据不同营养元素进行升序降序(显示全部,根据一级表显示--默认展示)

	List<FoodDetailsDTO>bySqlSelectAllFood(@Param("fid") Long fid, @Param("sql") String sql);

	//后台审核，修改审核状态（0-待审核 1-通过 2-不通过）

	public void alterFoodStatus(@Param("foodDetailsDTO") FoodDetailsDTO foodDetailsDTO);

   //后台重新提交审核

	public void ReSubmitFoodStatus(@Param("foodDetailsDTO") FoodDetailsDTO foodDetailsDTO);


	//后台药品上线下线 （0-下线 1-上线）

	public void updateFoodStatus(@Param("foodId")Long foodId, @Param("foodExistStatus")String foodExistStatus);

   //食物查询

	String getByFoodName(String foodName);

}
