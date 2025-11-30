package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: SysDicDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/25 11:56
 */
@Data
public class SysDicDTO {
    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "字典项id")
    private Integer id;

    /**
     * 数据值
     */
    @ApiModelProperty(value = "数据值")
    private String value;

    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    private String label;

}
