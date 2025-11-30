package com.wyzy.hospital.tcm.dto;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:04
 */
@Data
public class TcmCmDTO {

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
	 * 一级中药分类ID
	 */
	@ApiModelProperty(value="一级中药分类ID")
	private Long onelevelId;

	/**
	 * 二级中药分类ID
	 */
	@ApiModelProperty(value="二级中药分类ID")
	private Long secondlevelId;

	/**
	 * 一级分类名称
	 */
	@ApiModelProperty(value="一级分类名称")
	private String oneName;

	/**
	 * 二级分类名称
	 */
	@ApiModelProperty(value="二级分类名称")
	private String twoName;

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
