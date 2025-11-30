

package com.wyzy.hospital.cyclopedia.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.FoodBackstageDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodLevelDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodOneLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 食物一级表
 *
 * @author hospital code generator
 * @date 2021-04-27 08:56:39
 */
@Mapper
public interface FoodLevelMapper extends HospitalBaseMapper<FoodLevel> {


	//查一级

	List<FoodLevelDTO> selectFirstByLevel();

	//根据一级查二级

	List<FoodLevelDTO>selectTwoByFid(Long fid);


	//查询一级及食物总数

	List<FoodOneLevelDTO> firstSelectFoodNumber();

	// 查一级表下二级表数量

	int selectFoodLevelCount(Long fid);



	//根据二级查食物数量(删二级用到)

	int selectDetailsCount(Long foodLevelId);


	//食物百科审核

	List<FoodBackstageDTO>selectFoodBackstage(IPage<FoodBackstageDTO> page);

	//食物百科审核条件查询

	List<FoodBackstageDTO>byConditionFoodBackstage(IPage<FoodBackstageDTO> page,@Param("minTime") LocalDateTime minTime,
												   @Param("maxTime") LocalDateTime maxTime,
												   @Param("foodName") String foodName,
												   @Param("foodUploadAdmin") String foodUploadAdmin);
//食物百科列表条件查询

	List<FoodBackstageDTO>byConditionFoodTable(IPage<FoodBackstageDTO> page,@Param("minTime") LocalDateTime minTime,
											   @Param("maxTime") LocalDateTime maxTime,
											   @Param("foodName") String foodName,
											   @Param("foodExamineAdmin") String foodExamineAdmin);


//食物百科审核列表条件查询

	List<FoodBackstageDTO>byConditionAuditFoodTable(IPage<FoodBackstageDTO> page,@Param("minTime") LocalDateTime minTime,
											   @Param("maxTime") LocalDateTime maxTime,
											   @Param("foodName") String foodName,
											   @Param("foodExamineAdmin") String foodExamineAdmin);





    //食物百科列表

	List<FoodBackstageDTO>selectFoodBackTable(IPage<FoodBackstageDTO> page);

    //百科食物审核列表

	List<FoodBackstageDTO>selectFoodBackExamineTable(IPage<FoodBackstageDTO> page);

	//后台百科食物详情

    List<FoodBackstageDTO>selectFoodDetailsBack(Long id);

	//姓名查询

	String selectName(String foodLevelName);

}
