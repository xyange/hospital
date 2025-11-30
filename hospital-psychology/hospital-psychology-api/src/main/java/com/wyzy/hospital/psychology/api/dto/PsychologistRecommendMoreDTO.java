package com.wyzy.hospital.psychology.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 名师推荐更多
 *
 * @author wrk
 * @date 2021/05/07 16:28
 **/

@ApiModel(value = "app推荐心理医生-更多")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsychologistRecommendMoreDTO {
    private String avatar;
    private String doctorName;
    /**
     * 从业年限
     */
    private String workYears;
    private String area;
    /**
     * 级别 例如国家二级咨询师
     */
    private String grade;
    /**
     * 荣誉称呼
     */
    private String honoraryTitle;

    /**
     * 擅长方向
     */
    private String directionIds;
    private String directions;
    /**
     * 服务
     */
    private List<Map<String,Object>> serve;
    /**
     * 咨询类型
     */
    private String advisoryType;
    /**
     * 价格
     */
    private Integer price;
}
