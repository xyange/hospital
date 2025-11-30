

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
 * 公司药品表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:37:00
 */
@Data
@TableName("cy_reagent")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "公司药品表")
public class CyReagent extends Model<CyReagent> {

    private static final long serialVersionUID = 1L;

    /**
     * 公司制药id
     */
    @TableId(value = "cy_reagent_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="公司制药id")
    private Long cyReagentId;

    /**
     * 产药名称
     */
    @ApiModelProperty(value="产药名称")
    private String cyReagentName;

    /**
     * cyCompanyId
     */
    @ApiModelProperty(value="cyCompanyId")
    private Long cyCompanyId;

    /**
     * 药品试剂表id
     */
    @ApiModelProperty(value="药品试剂表id")
    private Long cyDrugTypeId;

	/**
	 * 删除状态/0/1删除
	 */
	@TableLogic(value="0",delval="1")
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

}
