

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.FoodBackstageDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodLevelDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodOneLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodLevel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 食物一级表
 *
 * @author hospital code generator
 * @date 2021-04-27 08:56:39
 */
public interface FoodLevelService extends IService<FoodLevel> {


	//查一级表

	List<FoodLevelDTO>queryFirstByLevel();

	//根据一级查二级

	List<FoodLevelDTO>queryTwoByFid(Long fid);


	// 根据一级查二级数量（删除判断）

	int queryFoodLevelCount (long fid);

   //根据二级查食物数量（删除判断）

	int queryDetailsCount(Long foodLevelId);


	//删除一级表(如果包含二级表则不能直接删除)或二级表

	String movenFoodLevel(Long id, Integer levels);


	//查询一级及二级下食物总数

	List<FoodOneLevelDTO> firstQueryFoodNumber();

    //查后台状态

	List<FoodBackstageDTO>queryFoodBackstage(IPage<FoodBackstageDTO> page);

	//食物百科审核条件查询

	List<FoodBackstageDTO>lookConditionFoodBackstage(IPage<FoodBackstageDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodUploadAdmin);

	//食物百科列表

	List<FoodBackstageDTO>queryFoodBackTable(IPage<FoodBackstageDTO> page);

	//食物百科审核条件查询

	List<FoodBackstageDTO>lookConditionFoodTable(IPage<FoodBackstageDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodExamineAdmin);

	//百科食物审核列表

	List<FoodBackstageDTO>queryFoodBackExamineTable(IPage<FoodBackstageDTO> page);

	//食物百科审核条件查询

	List<FoodBackstageDTO>lookConditionAuditFoodTable(IPage<FoodBackstageDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodExamineAdmin);

	//后台百科食物详情

	List<FoodBackstageDTO>queryFoodDetailsBack(Long id);




}
