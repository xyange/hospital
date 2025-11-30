

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
 * 用户诊所关系表
 *
 * @author songM
 * @date 2021-05-17 16:26:18
 */
@Data
@TableName("user_clinic")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户诊所关系表")
public class UserClinic extends Model<UserClinic> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 诊所id
     */
    @ApiModelProperty(value="诊所id")
    private Long clinicId;

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
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

}
