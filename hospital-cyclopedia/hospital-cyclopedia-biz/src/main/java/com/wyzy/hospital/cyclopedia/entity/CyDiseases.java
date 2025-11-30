

package com.wyzy.hospital.cyclopedia.entity;

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

import java.time.LocalDateTime;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-05-08 14:37:31
 */
@Data
@TableName("cy_diseases")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "疾病表")
public class CyDiseases extends Model<CyDiseases> {

    private static final long serialVersionUID = 1L;

    /**
     * disId
     */
	@TableId(value = "dis_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
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
	@TableLogic(value="0",delval="1")
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

}
