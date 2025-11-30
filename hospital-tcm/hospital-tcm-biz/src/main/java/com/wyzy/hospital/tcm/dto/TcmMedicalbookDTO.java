package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@Data
public class TcmMedicalbookDTO {

	/**
	 * 是否收藏
	 */
	@ApiModelProperty(value="是否收藏:0未收藏，1已收藏")
	private Integer isCollect;

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
	 * 作者Name
	 */
	@ApiModelProperty(value="作者Name")
	private String writerName;

	/**
	 * 流派Name
	 */
	@ApiModelProperty(value="流派Name")
	private String sectName;

	/**
	 * 学科Name
	 */
	@ApiModelProperty(value="学科Name")
	private String subjectName;


	/**
	 * 医书分类名称
	 */
	@ApiModelProperty(value="医书分类名称")
	private String classicsName;

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

}
