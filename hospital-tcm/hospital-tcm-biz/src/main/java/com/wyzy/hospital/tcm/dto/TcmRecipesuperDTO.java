

package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TcmRecipesuperDTO {

	/**
	 * 方剂父级ID
	 */
	@TableId
	@ApiModelProperty(value="方剂父级ID")
	private Long id;

    /**
     * 方剂父级名称
     */
    @ApiModelProperty(value="方剂父级名称")
    private String recipesuperName;

	/**
	 * 状态:1 正常, 0 失效
	 */
	@ApiModelProperty(value="介绍")
	private String introduce;

	/**
	 * 方剂数量
	 */
	@ApiModelProperty(value="方剂数量")
	private Integer recipesuperNumber;

	/**
	 * 方剂集合
	 */
	@ApiModelProperty(value="方剂集合")
    private List<TcmRecipeDTO> tcmRecipeDTOList;
}
