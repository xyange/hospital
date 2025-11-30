

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
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
@Data
@TableName("tcm_disease")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "疾病表")
public class TcmDisease extends Model<TcmDisease> {

    private static final long serialVersionUID = 1L;

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
