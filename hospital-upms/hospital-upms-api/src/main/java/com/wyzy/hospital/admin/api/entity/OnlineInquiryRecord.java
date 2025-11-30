

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

import java.time.LocalDateTime;

/**
 * 在线问诊记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:43
 */
@Data
@TableName("wyzy_online_inquiry_record")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "在线问诊记录")
public class OnlineInquiryRecord extends Model<OnlineInquiryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * inquiryId
     */
    @TableId(value = "inquiry_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="inquiryId")
    private Long inquiryId;

    /**
     * memberId
     */
    @ApiModelProperty(value="memberId",example ="2")
    private Long memberId;


    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id",example ="27")
    private Long doctorId;

    /**
     * 问诊类型
     */
    @ApiModelProperty(value="问诊类型:123-图文咨询,124-音频咨询,125-私人医生,126-预约挂号",example ="123")
    private Integer inquireType;

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

    @ApiModelProperty(value="问诊状态 0-进行中 1-已结束 2-已退款",example ="0")
    private Integer status;

    @ApiModelProperty(value="病情描述",example ="病情描述")
    private String diseaseDescription;

    @ApiModelProperty(value="病情图片")
    private String diseaseImg;

    @ApiModelProperty(value="订单id（暂时不填）")
    private String orderId;

    @ApiModelProperty(value="就诊卡id（就诊人id）" ,example = "1398083398644924417")
    private Long cardId;
}
