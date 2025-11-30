

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 身体管理症状自查分类
 *
 * @author hospital code generator
 * @date 2021-06-16 17:33:23
 */
@Data
@TableName("physical_symptom_type")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "身体管理症状自查分类")
public class PhysicalSymptomType extends Model<PhysicalSymptomType> {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    @TableId
    @ApiModelProperty(value="类型ID")
    private Long id;

    /**
     * 类型名称
     */
    @ApiModelProperty(value="类型名称")
    private String symptomName;

    /**
     * 状态：0正常 1删除
     */
    @TableLogic(value="0",delval="1")
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

}
