package com.wyzy.hospital.tcm.dto;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.wyzy.hospital.tcm.entity.TcmBookattr;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
@Data
public class TcmBookattrDTO {

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
    @ApiModelProperty(value="类型")
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

	/**
	 * 医书属性集合
	 */
	@ApiModelProperty(value="医书属性集合")
	private List<TcmBookattr> tcmBookattrList;

}
