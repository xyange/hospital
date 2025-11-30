package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
@Data
public class TcmDiseaseDTO {
	/**
	 * 疾病ID
	 */
	@TableId
	@ApiModelProperty(value="疾病ID")
	private Long diseaseId;

	/**
	 * 疾病名称
	 */
	@ApiModelProperty(value="疾病名称")
	private String diseaseName;

	/**
	 * 疾病介绍
	 */
	@ApiModelProperty(value="疾病介绍")
	private String introduce;

	/**
	 * 疾病原因
	 */
	@ApiModelProperty(value="疾病原因")
	private String reason;

	/**
	 * 疾病症状
	 */
	@ApiModelProperty(value="疾病症状")
	private String symptom;

	/**
	 * 疾病诊断
	 */
	@ApiModelProperty(value="疾病诊断")
	private String diagnosis;

	/**
	 * 预防治疗
	 */
	@ApiModelProperty(value="预防治疗")
	private String prophylaxis;

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
