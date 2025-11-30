

package com.wyzy.hospital.pharmacy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 药房评论
 *
 * @author aqie
 * @date 2021-04-22 09:47:09
 */
@Data
@TableName("ph_comment")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药房评论")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId
    @ApiModelProperty(value="评论id")
    private Long commentId;

    /**
     * 关联店铺id
     */
    @ApiModelProperty(value="关联店铺id")
    private Long shopId;

    /**
     * 商家名称
     */
    @ApiModelProperty(value="商家名称")
    private String shopName;

    /**
     * 商家编码
     */
    @ApiModelProperty(value="商家编码")
    private String shopCode;

    /**
     * 关联商品id
     */
    @ApiModelProperty(value="关联商品id")
    private Long productId;

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
	 * 追加图片地址（多个以逗号隔开）
	 */
	@ApiModelProperty(value="追加图片地址（多个以逗号隔开）")
	private String addImage;


    /**
     * 商家回复
     */
    @ApiModelProperty(value="商家回复")
    private String replay;

    /**
     * comment
     */
    @ApiModelProperty(value="comment")
    private String comment;

    /**
     * addComment
     */
    @ApiModelProperty(value="addComment")
    private String addComment;

    /**
     * 是否隐藏 1-是 0-否
     */
	@TableLogic
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
     * 商品印象
     */
    @ApiModelProperty(value="商品印象")
    private String impression;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private String updateTime;

}
