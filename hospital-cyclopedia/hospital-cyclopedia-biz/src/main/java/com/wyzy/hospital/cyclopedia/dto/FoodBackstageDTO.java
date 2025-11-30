package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/13  15:47
 */
@Data
public class FoodBackstageDTO {

	/**
	 * 食物详情ID
	 */
	@ApiModelProperty(value="食物详情ID")
	private Long foodId;

	/**
	 * foodName
	 */
	@ApiModelProperty(value="foodName")
	private String foodName;

	/**
	 * 食物千卡
	 */
	@ApiModelProperty(value="食物千卡")
	private Float foodKcal;

	/**
	 * 食物千焦
	 */
	@ApiModelProperty(value="食物千焦")
	private Float foodKilojoules;

	/**
	 * 食物热量
	 */
	@ApiModelProperty(value="食物热量")
	private Float foodHeat;

	/**
	 * 蛋白质
	 */
	@ApiModelProperty(value="蛋白质")
	private Float foodProtein;

	/**
	 * 脂肪
	 */
	@ApiModelProperty(value="脂肪")
	private Float foodFat;

	/**
	 * 碳水化合物
	 */
	@ApiModelProperty(value="碳水化合物")
	private Float foodCarbohydrates;

	/**
	 * 胆固醇
	 */
	@ApiModelProperty(value="胆固醇")
	private Float foodCholesterol;

	/**
	 * 膳食纤维
	 */
	@ApiModelProperty(value="膳食纤维")
	private Float foodDietaryFiber;

	/**
	 * 铁
	 */
	@ApiModelProperty(value="铁")
	private Float foodIron;

	/**
	 * 钙
	 */
	@ApiModelProperty(value="钙")
	private Float foodCalcium;

	/**
	 * 钾
	 */

	private Float foodPotassium;

	/**
	 * 镁
	 */

	private Float foodMagnesium;

	/**
	 * 叶酸
	 */

	private Float foodAcid;

	/**
	 * 锌
	 */

	private Float foodZinc;

	/**
	 * 嘌呤
	 */
	private Float foodPurine;

	/**
	 * 钠
	 */
	private Float foodSodium;

	/**
	 * 饱和脂肪
	 */
	private Float foodSaturatedFat;

	/**
	 * GI
	 */

	private Float foodGi;

	/**
	 * GL
	 */
	private Float foodGl;

	/**
	 * 食物类型表id
	 */
	private Long foodLevelId;


	/**
	 * 推荐红绿灯
	 */
	private String foodReferralRate;

	/**
	 * 上传人
	 */
	private String foodUploadAdmin;

	/**
	 * 食物图片
	 */
	private String foodImage;

	/**
	 * 食物审核状态
	 */
	private String foodAuditStatus;


	/**
	 * 上线/下线
	 */

	private String foodExistStatus;
	/**
	 * 审核人
	 */
	private String foodExamineAdmin;

	/**
	 * foodUploadTime
	 */
	private LocalDateTime foodUploadTime;

	/**
	 * 过审时间
	 */
	private LocalDateTime foodCheckPassTime;

	/**
	 * 审核时间
	 */
	private LocalDateTime foodAuditTime;


	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
	/**
	 * 食物一级分类集合
	 */
	private List<FoodOneLevelDTO>foodOneLevelDTOList;
	/**
	 * 食物二级分类集合
	 */
	private List<FoodTwoLevelDTO>foodTwoLevelDTOList;
}
