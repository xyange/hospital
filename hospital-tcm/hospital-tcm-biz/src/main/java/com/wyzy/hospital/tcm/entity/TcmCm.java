

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
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
@Data
@TableName("tcm_cm")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "中药表")
public class TcmCm extends Model<TcmCm> {

    private static final long serialVersionUID = 1L;

    /**
     * 中药ID
     */
	@TableId
    @ApiModelProperty(value="中药ID")
    private Long id;

    /**
     * 中药名称
     */
    @ApiModelProperty(value="中药名称")
    private String chinamedicineName;

    /**
     * 中药分类ID
     */
    @ApiModelProperty(value="中药分类ID")
    private Long secondlevelId;

    /**
     * 中药图片
     */
    @ApiModelProperty(value="中药图片")
    private String picture;

    /**
     * 基本内容
     */
    @ApiModelProperty(value="基本内容")
    private String basicContent;

	/**
	 * 药性
	 */
	@ApiModelProperty(value="药性")
	private String drugProperties;

    /**
     * 临床应用
     */
    @ApiModelProperty(value="临床应用")
    private String application;

    /**
     * 临床配伍
     */
    @ApiModelProperty(value="临床配伍")
    private String compatibility;

    /**
     * 方剂
     */
    @ApiModelProperty(value="方剂")
    private String recipeId;

    /**
     * 药理
     */
    @ApiModelProperty(value="药理")
    private String pharmacology;

    /**
     * 炮制
     */
    @ApiModelProperty(value="炮制")
    private String processing;

    /**
     * 性状与鉴别
     */
    @ApiModelProperty(value="性状与鉴别")
    private String characters;

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
