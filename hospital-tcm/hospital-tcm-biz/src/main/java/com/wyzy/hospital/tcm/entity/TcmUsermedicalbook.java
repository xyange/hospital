

package com.wyzy.hospital.tcm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 医书收藏表
 *
 * @author hospital code generator
 * @date 2021-04-30 10:38:12
 */
@Data
@TableName("tcm_usermedicalbook")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医书收藏表")
public class TcmUsermedicalbook extends Model<TcmUsermedicalbook> {

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
     * 医书ID
     */
    @ApiModelProperty(value="医书ID")
    private Long medicalbookId;

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
