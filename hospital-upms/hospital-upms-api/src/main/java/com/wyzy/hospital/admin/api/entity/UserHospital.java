

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 用户医院收藏中间表
 *
 * @author aqie
 * @date 2021-04-17 14:48:05
 */
@Data
@TableName("user_hospital")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户医院收藏中间表")
public class UserHospital extends Model<UserHospital> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 医院id
     */
    @ApiModelProperty(value="医院id")
    private Long hospitalId;

    /**
     * 是否收藏
     */
    @ApiModelProperty(value="是否收藏")
    private Integer isCollect;

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
