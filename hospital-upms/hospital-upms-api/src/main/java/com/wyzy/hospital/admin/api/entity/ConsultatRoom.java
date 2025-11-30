

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 诊室表
 *
 * @author hospital code generator
 * @date 2021-04-17 08:47:10
 */
@Data
@TableName("consultat_room")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "诊室表")
public class ConsultatRoom extends Model<ConsultatRoom> {

    private static final long serialVersionUID = 1L;

    /**
     * 诊室ID
     */
    @TableId
    @ApiModelProperty(value="诊室ID")
    private Long id;

    /**
     * 诊室名字
     */
    @ApiModelProperty(value="诊室名字")
    private String consultatName;

    /**
     * 医院科室ID
     */
    @ApiModelProperty(value="医院科室ID")
    private Long hosdepdetailId;

    /**
     * 诊室位置
     */
    @ApiModelProperty(value="诊室位置")
    private String position;

    /**
     * 诊室照片
     */
    @ApiModelProperty(value="诊室照片")
    private String photo;

    /**
     * 是否有效
     */
    @TableLogic(value="0",delval="1")
    @ApiModelProperty(value="是否有效：1：删除 0：正常")
    private Integer delFlag;

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
