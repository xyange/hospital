

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
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@Data
public class TcmMedicalbookVO {

    /**
     * 医书ID
     */
    @TableId
    @ApiModelProperty(value="医书ID")
    private Long medicalbookId;

    /**
     * 医书名称
     */
    @ApiModelProperty(value="医书名称")
    private String medicalbookName;

	/**
	 * 作者名称
	 */
	@ApiModelProperty(value="作者名称")
	private String writer;

	/**
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;
}
