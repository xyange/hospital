

package com.wyzy.hospital.tcm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@Data
@TableName("tcm_medicalbook")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医书表")
public class TcmMedicalbook extends Model<TcmMedicalbook> {

    private static final long serialVersionUID = 1L;

    /**
     * 医书ID
     */
	@TableId
    @ApiModelProperty(value="医书ID")
    private Long medicalbookId;

    /**
     * 医书名称
     */
    @ApiModelProperty(value="医书名称")
    private String medicalbookName;

    /**
     * 医书分类ID
     */
    @ApiModelProperty(value="医书分类ID")
    private Long classicsId;

	/**
	 * 流派ID
	 */
	@ApiModelProperty(value="流派ID")
	private Long sectId;

	/**
	 * 学科ID
	 */
	@ApiModelProperty(value="学科ID")
	private Long subjectId;

	/**
	 * 作者ID
	 */
	@ApiModelProperty(value="作者ID")
	private Long writerId;

    /**
     * 目录
     */
    @ApiModelProperty(value="目录")
    private String catalogue;

    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;

	/**
	 * 浏览量
	 */
	@ApiModelProperty(value="浏览量")
	private Integer pageView;

	/**
	 * 状态:1 正常, 0 失效
	 */
	@TableLogic(value="0",delval="1")
	@ApiModelProperty(value="状态:1 失效, 0 正常")
	private Integer delFlag;

	/**
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;

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
