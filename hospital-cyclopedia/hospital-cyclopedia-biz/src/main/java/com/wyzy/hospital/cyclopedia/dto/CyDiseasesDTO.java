package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/20  11:29
 */
@Data
public class CyDiseasesDTO {

	/**
	 * disId
	 */
	@TableId
	@ApiModelProperty(value="disId")
	private Long disId;

	/**
	 * 疾病名称
	 */
	@ApiModelProperty(value="疾病名称")
	private String disName;

	/**
	 * 疾病别称
	 */
	@ApiModelProperty(value="疾病别称")
	private String disNicknames;


	/**
	 * 病例概述
	 */
	@ApiModelProperty(value="病例概述")
	private String disContent;

	/**
	 * 症状
	 */
	@ApiModelProperty(value="症状")
	private String disSymptom;

	/**
	 * 病因
	 */
	@ApiModelProperty(value="病因")
	private String disCause;

	/**
	 * disImage
	 */
	@ApiModelProperty(value="疾病图片")
	private String disImage;

	/**
	 * disUploadAdmin
	 */
	@ApiModelProperty(value="上传人")
	private String disUploadAdmin;

	/**
	 * disProtect
	 */
	@ApiModelProperty(value="disProtect")
	private String disProtect;

	/**
	 * disTreatment
	 */
	@ApiModelProperty(value="disTreatment")
	private String disTreatment;

	/**
	 * disSeeDoctor
	 */
	@ApiModelProperty(value="就医")
	private String disSeeDoctor;

	/**
	 * disCheckAdmin
	 */
	@ApiModelProperty(value="审核人")
	private String disCheckAdmin;

	/**
	 * disExistStruts
	 */
	@ApiModelProperty(value="上下线状态")
	private String disExistStruts;



	/**
	 * disCheckStruts
	 */
	@ApiModelProperty(value="审核状态")
	private String disCheckStruts;

	/**
	 * disDelStruts
	 */
	@ApiModelProperty(value="删除状态")
	private String disDelStruts;

	/**
	 * disUploadTime
	 */
	@ApiModelProperty(value="上传时间")
	private LocalDateTime disUploadTime;

	/**
	 * disCheckPassTime
	 */
	@ApiModelProperty(value="过审时间")
	private LocalDateTime disCheckPassTime;


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
	 *
	 */
    private String departmentName;
	/**
	 * 二级科室集合
	 */
	private List<CyDepartmentDTO>cyDepartmentDTOList;
}
