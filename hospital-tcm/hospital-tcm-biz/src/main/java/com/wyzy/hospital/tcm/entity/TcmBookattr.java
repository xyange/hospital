

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
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
@Data
@TableName("tcm_bookattr")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医书属性表")
public class TcmBookattr extends Model<TcmBookattr> {

    private static final long serialVersionUID = 1L;

    /**
     * 医书属性ID
     */
	@TableId
    @ApiModelProperty(value="医书属性ID")
    private Long id;

    /**
     * 医书属性称
     */
    @ApiModelProperty(value="医书属性称")
    private String bookattrName;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型 1:典籍2:学科3:流派4:作者")
    private Integer type;

	/**
	 * 状态:1 正常, 0 失效
	 */
	@TableLogic(value="0",delval="1")
	@ApiModelProperty(value="状态:1 失效, 0 正常")
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
