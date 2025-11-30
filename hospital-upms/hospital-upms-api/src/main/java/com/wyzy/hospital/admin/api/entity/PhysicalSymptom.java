

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 身体管理症状自查
 *
 * @author songM
 * @date 2021-06-17 10:28:22
 */
@Data
@TableName("physical_symptom")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "身体管理症状自查")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhysicalSymptom extends Model<PhysicalSymptom> {

    private static final long serialVersionUID = 1L;

    /**
     * 症状ID
     */
    @TableId
    @ApiModelProperty(value="症状ID")
    private Long id;

    /**
     * 症状名称
     */
    @ApiModelProperty(value="症状名称")
    private String symptomName;

    /**
     * 上一级ID
     */
    @ApiModelProperty(value="上一级ID")
    private Long superiorId;

    /**
     * 状态：0正常 1删除
     */
    @ApiModelProperty(value="状态：0正常 1删除")
    private Integer delFlag;

    /**
     * 在线:0下线1上线
     */
    @ApiModelProperty(value="在线:0下线1上线")
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
    /**
     * 子列表
     */
    @ApiModelProperty(value="更新时间")
    private List<PhysicalSymptom> children;
}
