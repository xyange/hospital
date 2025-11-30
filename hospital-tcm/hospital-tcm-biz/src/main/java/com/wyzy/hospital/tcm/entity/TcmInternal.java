

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
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
@Data
@TableName("tcm_internal")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "内科学表")
public class TcmInternal extends Model<TcmInternal> {

    private static final long serialVersionUID = 1L;

    /**
     * 内科学ID
     */
	@TableId
    @ApiModelProperty(value="内科学ID")
    private Long id;

    /**
     * 内科分类ID
     */
    @ApiModelProperty(value="内科分类ID")
    private Long internalsuperId;

    /**
     * 内科学名称
     */
    @ApiModelProperty(value="内科学名称")
    private String diseaseName;

    /**
     * 临床表现
     */
    @ApiModelProperty(value="临床表现")
    private String manifestation;

    /**
     * 治法
     */
    @ApiModelProperty(value="治法")
    private String treatment;

    /**
     * 代表方剂
     */
    @ApiModelProperty(value="代表方剂")
    private String recipeId;

    /**
     * 本方组成
     */
    @ApiModelProperty(value="本方组成")
    private String compose;

    /**
     * 加减配伍
     */
    @ApiModelProperty(value="加减配伍")
    private String compatibility;

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
