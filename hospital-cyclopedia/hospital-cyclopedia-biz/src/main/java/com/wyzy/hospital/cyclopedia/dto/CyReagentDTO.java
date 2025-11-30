package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  11:31
 */
@Data
public class CyReagentDTO {
	/**
	 * 公司制药id
	 */
	@TableId
	@ApiModelProperty(value="公司制药id")
	private Long cyReagentId;

	/**
	 * 产药名称
	 */
	@ApiModelProperty(value="产药名称")
	private String cyReagentName;

	/**
	 * 删除状态/0/1删除
	 */
	@ApiModelProperty(value="删除状态")
	private String delStruts;

	/**
	 * 上传人
	 */
	@ApiModelProperty(value="上传人")
	private String uploadAdmin;

	/**
	 * 审核状态 0-待审核 1-通过 2-未通过
	 */
	@ApiModelProperty(value="审核状态")
	private String auditStruts;

	/**
	 * 上线下线  1-上线 2-下线
	 */
	@ApiModelProperty(value="上线下线")
	private String existStruts;

	/**
	 * 审核人
	 */
	@ApiModelProperty(value="审核人")
	private String auditAdmin;

	/**
	 * reUploadTime
	 */
	@ApiModelProperty(value="上传时间")
	private LocalDateTime reUploadTime;

	/**
	 * disCheckPassTime
	 */
	@ApiModelProperty(value="过审时间")
	private LocalDateTime reCheckPassTime;

	/**
	 * reAuditTime
	 */
	@ApiModelProperty(value="审核时间")
	private LocalDateTime reAuditTime;

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
	 * 制药公司表dto集合
	 */
	private List<CyCompanyDTO>cyCompanyDTOList;

	/**
	 * 公司药品详情表dto集合
	 */
	private List<CyReagenDetailsDTO>cyReagenDetailsDTOList;
}
