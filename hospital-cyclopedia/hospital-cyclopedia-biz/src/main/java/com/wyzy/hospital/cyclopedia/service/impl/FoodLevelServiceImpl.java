
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.FoodBackstageDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodLevelDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodOneLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodLevel;
import com.wyzy.hospital.cyclopedia.mapper.FoodLevelMapper;
import com.wyzy.hospital.cyclopedia.service.FoodLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 食物一级表
 *
 * @author hospital code generator
 * @date 2021-04-27 08:56:39
 */
@Service
public class FoodLevelServiceImpl extends ServiceImpl<FoodLevelMapper, FoodLevel> implements FoodLevelService {

	@Resource
	FoodLevelMapper foodLevelMapper;

	private FoodLevel foodLevel;


	@Override
	public List<FoodLevelDTO> queryFirstByLevel() {
		List<FoodLevelDTO> foodLevels = baseMapper.selectFirstByLevel();
		return foodLevels;
	}

	@Override
	public List<FoodLevelDTO> queryTwoByFid(Long fid) {
		return baseMapper.selectTwoByFid(fid);
	}




	@Override
	public int queryFoodLevelCount(long fid) {
		return baseMapper.selectFoodLevelCount(fid);
	}

	@Override
	public int queryDetailsCount(Long foodLevelId) {
		return baseMapper.selectDetailsCount(foodLevelId);
	}

	@Override
	public String movenFoodLevel(Long id, Integer levels) {
		String message = null;
		try {
			if (levels == 1) {
				int count = foodLevelMapper.selectFoodLevelCount(id);
				if (count == 0) {
					foodLevelMapper.deleteById(id);
					message = "删除成功----111";
				} else {
					message = "删除失败该一级表下存在二级分类----110";
				}
			} else {
				if (levels == 2) {
					int count = foodLevelMapper.selectDetailsCount(id);
					if (count == 0) {
						foodLevelMapper.deleteById(id);
						message = "二级删除成功----112";
					} else {
						message = "删除失败该二级表下存在食物----120";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}


	@Override
	public List<FoodOneLevelDTO> firstQueryFoodNumber() {
		List<FoodOneLevelDTO> foodLevels = baseMapper.firstSelectFoodNumber();
			return foodLevels;

	}

	@Override
	public List<FoodBackstageDTO> queryFoodBackstage(IPage<FoodBackstageDTO> page) {
		List<FoodBackstageDTO> foodLevelList = baseMapper.selectFoodBackstage(page);
		return foodLevelList;
	}
//条件查询

	@Override
	public List<FoodBackstageDTO> lookConditionFoodBackstage(IPage<FoodBackstageDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodUploadAdmin) {
		List<FoodBackstageDTO> foodBackstageDTOList = baseMapper.byConditionFoodBackstage(page,minTime, maxTime, foodName, foodUploadAdmin);
		return foodBackstageDTOList;
	}

	@Override
	public List<FoodBackstageDTO> queryFoodBackTable(IPage<FoodBackstageDTO> page) {
		List<FoodBackstageDTO> foodLevelList = baseMapper.selectFoodBackTable(page);
		return foodLevelList;
	}

	@Override
	public List<FoodBackstageDTO> lookConditionFoodTable( IPage<FoodBackstageDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodExamineAdmin) {
		List<FoodBackstageDTO> foodBackstageDTOList = baseMapper.byConditionFoodTable(page,minTime, maxTime, foodName, foodExamineAdmin);
		return foodBackstageDTOList;
	}

	@Override
	public List<FoodBackstageDTO> queryFoodBackExamineTable(IPage<FoodBackstageDTO> page) {
		List<FoodBackstageDTO> foodLevelList = baseMapper.selectFoodBackExamineTable(page);
		return foodLevelList;
	}

	@Override
	public List<FoodBackstageDTO> lookConditionAuditFoodTable(IPage<FoodBackstageDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodExamineAdmin) {
		List<FoodBackstageDTO> foodBackstageDTOList = baseMapper.byConditionAuditFoodTable(page,minTime, maxTime, foodName, foodExamineAdmin);
		return foodBackstageDTOList;
	}

	@Override
	public List<FoodBackstageDTO> queryFoodDetailsBack(Long id) {
		List<FoodBackstageDTO> foodLevelList = baseMapper.selectFoodDetailsBack(id);
		return foodLevelList;
	}


}
