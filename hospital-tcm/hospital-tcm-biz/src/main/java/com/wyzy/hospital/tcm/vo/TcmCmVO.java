

package com.wyzy.hospital.tcm.vo;

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
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
@Data
public class TcmCmVO {
    /**
     * 中药ID
     */
    @TableId
    @ApiModelProperty(value="中药ID")
    private Long id;

    /**
     * 中药名称
     */
    @ApiModelProperty(value="中药名称")
    private String chinamedicineName;

	/**
	 * 药性
	 */
	@ApiModelProperty(value="药性")
	private String drugProperties;

	/**
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;
}
