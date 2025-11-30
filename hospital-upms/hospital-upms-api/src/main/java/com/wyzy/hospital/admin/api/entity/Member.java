

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 会员表
 *
 * @author aqie
 * @date 2021-04-26 14:56:59
 */
@Data
@TableName("wyzy_member")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会员表")
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @TableId(value = "member_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="会员id")
    private Long memberId;

    @ApiModelProperty(value="关联userId")
    private Long userId;

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
     * 身份证号
     */
    @ApiModelProperty(value="身份证号")
    private String idCard;

    /**
     * 唯一id
     */
    @ApiModelProperty(value="唯一id")
    private String uuid;

    /**
     * 昵称
     */
    @ApiModelProperty(value="昵称")
    private String nickname;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 是否付费(0-是 1-否)
     */
    @ApiModelProperty(value="是否付费(0-是 1-否)")
    private Integer paid;

    /**
     * 积分
     */
    @ApiModelProperty(value="积分")
    private Integer integration;

    /**
     * 就诊人数量
     */
    @ApiModelProperty(value="就诊人数量")
    private Integer patientNumber;

    /**
     * 消费金额
     */
    @ApiModelProperty(value="消费金额")
    private BigDecimal monetary;

}
