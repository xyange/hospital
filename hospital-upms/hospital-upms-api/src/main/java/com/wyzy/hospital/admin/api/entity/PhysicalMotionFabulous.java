

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 身体管理运动步数点赞
 *
 * @author hospital code generator
 * @date 2021-06-18 10:54:08
 */
@Data
@TableName("physical_motion_fabulous")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "身体管理运动步数点赞")
public class PhysicalMotionFabulous extends Model<PhysicalMotionFabulous> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 步数ID
     */
    @ApiModelProperty(value="步数ID")
    private Integer stepsId;

    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

}
