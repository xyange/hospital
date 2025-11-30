

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
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@Data
public class TcmAcupointVO {

    /**
     * 穴位ID
     */
    @TableId
    @ApiModelProperty(value="穴位ID")
    private Long acupointId;

    /**
     * 穴位名称
     */
    @ApiModelProperty(value="穴位名称")
    private String acupointName;

	/**
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;
}
