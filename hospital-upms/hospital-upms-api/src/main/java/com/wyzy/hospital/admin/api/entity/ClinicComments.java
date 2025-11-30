

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-09 16:26:56
 */
@Data
@TableName("clinic_comments")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "诊所评论表")
public class ClinicComments extends Model<ClinicComments> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId
    @ApiModelProperty(value="评论id")
    private Long commentId;

    /**
     * 诊所id
     */
    @ApiModelProperty(value="诊所id")
    private Long clinicId;

    /**
     * 诊所名称
     */
    @ApiModelProperty(value="诊所名称")
    private String clinicName;

    /**
     * 诊所编码
     */
    @ApiModelProperty(value="诊所编码")
    private String clinicCode;

    /**
     * 诊疗技术id
     */
    @ApiModelProperty(value="诊疗技术id")
    private Integer technologyId;

    /**
     * 规格id
     */
    @ApiModelProperty(value="规格id")
    private Long skuId;

    /**
     * 订单id
     */
    @ApiModelProperty(value="订单id")
    private Long orderId;

    /**
     * 关联客户id
     */
    @ApiModelProperty(value="关联客户id")
    private Long userId;

    /**
     * 图片地址（多个以逗号隔开）
     */
    @ApiModelProperty(value="图片地址（多个以逗号隔开）")
    private String image;

    /**
     * 追加图片
     */
    @ApiModelProperty(value="追加图片")
    private String addImage;

    /**
     * 商家回复
     */
    @ApiModelProperty(value="商家回复")
    private String replay;

    /**
     * 评论
     */
    @ApiModelProperty(value="评论")
    private String comment;

    /**
     * 追加评论
     */
    @ApiModelProperty(value="追加评论")
    private String addComment;

    /**
     * 是否隐藏 1-是 0-否
     */
    @ApiModelProperty(value="是否隐藏 1-是 0-否")
    private Integer state;

    /**
     * 是否敏感词审核  1-是 0-否
     */
    @ApiModelProperty(value="是否敏感词审核  1-是 0-否")
    private Integer ifSensitive;

    /**
     * 追评时间
     */
    @ApiModelProperty(value="追评时间")
    private String addTime;

    /**
     * 商品满意度(宝贝描述) 1-一星 2-二星 3-三星 4-四星 5-五星
     */
    @ApiModelProperty(value="商品满意度(宝贝描述) 1-一星 2-二星 3-三星 4-四星 5-五星")
    private Integer star;

    /**
     * 服务满意度(宝贝描述) 1-一星 2-二星 3-三星 4-四星 5-五星
     */
    @ApiModelProperty(value="服务满意度(宝贝描述) 1-一星 2-二星 3-三星 4-四星 5-五星")
    private Integer serviceStar;

    /**
     * 环境满意度(宝贝描述) 1-一星 2-二星 3-三星 4-四星 5-五星
     */
    @ApiModelProperty(value="环境满意度(宝贝描述) 1-一星 2-二星 3-三星 4-四星 5-五星")
    private Integer environmentStar;

    /**
     * 医生满意度(宝贝描述)1-一星 2-二星 3-三星 4-四星 5-五星
     */
    @ApiModelProperty(value="医生满意度(宝贝描述)1-一星 2-二星 3-三星 4-四星 5-五星")
    private Integer doctorStar;

    /**
     * 商品印象
     */
    @ApiModelProperty(value="商品印象")
    private String impression;

    /**
     * 是否被管理员批准显示 1-批准显示 2-隐藏
     */
    @ApiModelProperty(value="是否被管理员批准显示 1-批准显示 2-隐藏")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

}
