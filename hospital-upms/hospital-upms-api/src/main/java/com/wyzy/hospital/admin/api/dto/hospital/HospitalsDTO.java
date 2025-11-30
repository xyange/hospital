package com.wyzy.hospital.admin.api.dto.hospital;

import com.wyzy.hospital.admin.api.entity.Hospitals;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author aqie
 * Date on 2021/4/16  11:21
 * @Function:
 */
@Data
public class HospitalsDTO extends Hospitals {
    /**
     * 线上医生起始数
     */
    @ApiModelProperty(value="线上医生起始数")
    private Integer doctorNumberStart;
    /**
     * 线上医生结束数
     */
    @ApiModelProperty(value="线上医生结束数")
    private Integer doctorNumberEnd;

    /**
     * 医院新增科室id,逗号分隔
     */
    @ApiModelProperty(value="医院新增科室id,逗号分隔")
    private String departmentIds;

    /**
     * 根据科室id查询医院
     */
    @ApiModelProperty(value="科室id")
    private Long departmentId;

    /**
     * 根据科室名称查医院
     */
    @ApiModelProperty(value="科室名称")
    private String departmentName;
}
