

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 远程会诊预约表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:57
 */
@Data
@TableName("consult_order")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "远程会诊预约表")
public class ConsultOrder extends Model<ConsultOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

    /**
     * 就诊卡id
     */
    @ApiModelProperty(value="就诊卡id")
    private Long cardId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 预约配置ID
     */
    @ApiModelProperty(value="预约配置ID")
    private Long orderId;

    /**
     * 预约时间
     */
    @ApiModelProperty(value="预约时间")
    private LocalDateTime orderTime;

    /**
     * 病情描述
     */
    @ApiModelProperty(value="病情描述")
    private String descriptionIllness;

    /**
     * 图片
     */
    @ApiModelProperty(value="图片")
    private String photograph;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

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

    /**
     * 诊疗模式类型
     */
    @ApiModelProperty(value="诊疗模式类型")
    private String consultType;

    /**
     * 疾病id
     */
    @ApiModelProperty(value="疾病id")
    private Long diseaseid;

}
