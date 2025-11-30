

package com.wyzy.hospital.cyclopedia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.time.LocalDateTime;

/**
 * 食物详情表
 *
 * @author hospital code generator
 * @date 2021-04-25 11:08:01
 */
@Data
@TableName("food_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "食物详情表")
public class FoodDetails extends Model<FoodDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 食物详情ID
     */
    @TableId(value ="food_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="食物详情ID")
    private Long foodId;

	/**
	 * foodTypeName
	 */
	@ApiModelProperty(value="foodTypeName")
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
	@ApiModelProperty(value="钾")
	private Float foodPotassium;

	/**
	 * 镁
	 */
	@ApiModelProperty(value="镁")
	private Float foodMagnesium;

	/**
	 * 叶酸
	 */
	@ApiModelProperty(value="叶酸")
	private Float foodAcid;

	/**
	 * 锌
	 */
	@ApiModelProperty(value="锌")
	private Float foodZinc;

	/**
	 * 嘌呤
	 */
	@ApiModelProperty(value="嘌呤")
	private Float foodPurine;

	/**
	 * 钠
	 */
	@ApiModelProperty(value="钠")
	private Float foodSodium;

	/**
	 * 饱和脂肪
	 */
	@ApiModelProperty(value="饱和脂肪")
	private Float foodSaturatedFat;

    /**
     * GI
     */
    @ApiModelProperty(value="GI")
    private Float foodGi;

    /**
     * GL
     */
    @ApiModelProperty(value="GL")
    private Float foodGl;

	/**
	 * 食物图片
	 */
	@ApiModelProperty(value="foodImage")

	private String foodImage;

    /**
     * 食物类型表id
     */
    @ApiModelProperty(value="食物类型表id")
    private Long foodLevelId;


    /**
     * 推荐红绿灯
     */
    @ApiModelProperty(value="referralRate")
    private String foodReferralRate;

	/**
	 * 上传人
	 */
	@ApiModelProperty(value="foodUploadAdmin")
	private String foodUploadAdmin;

	/**
	 * 食物审核状态
	 */
	@ApiModelProperty(value="foodAuditStatus")
	private String foodAuditStatus;


	/**
	 * 上线/下线
	 */
	@ApiModelProperty(value="foodExistStatus")

	private String foodExistStatus;
	/**
	 * 审核人
	 */
	@ApiModelProperty(value="foodExamineAdmin")
	private String foodExamineAdmin;

	/**
	 * foodUploadTime
	 */
	@ApiModelProperty(value="上传时间")
	private LocalDateTime foodUploadTime;

	/**
	 * 过审时间
	 */
	@ApiModelProperty(value="过审时间")
	private LocalDateTime foodCheckPassTime;

	/**
	 * 审核时间
	 */
	@ApiModelProperty(value="审核时间")
	private LocalDateTime foodAuditTime;


	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value="更新时间")
	private LocalDateTime updateTime;

}
