package com.wyzy.hospital.admin.api.dto.department;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: DiseaseDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/24 17:19
 */
@Data
public class DiseaseDTO {
    /**
     * 疾病ID
     */
    @TableId
    @ApiModelProperty(value="疾病ID")
    private Integer diseaseId;

    /**
     * 疾病名称
     */
    @ApiModelProperty(value="疾病名称")
    private String diseaseName;
}
