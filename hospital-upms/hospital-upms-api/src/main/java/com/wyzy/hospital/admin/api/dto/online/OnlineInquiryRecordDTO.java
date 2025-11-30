package com.wyzy.hospital.admin.api.dto.online;

import com.wyzy.hospital.admin.api.entity.OnlineInquiryRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author aqie
 * Date on 2021/4/27  14:18
 * @Function:
 */
@Data
public class OnlineInquiryRecordDTO extends OnlineInquiryRecord {

    private String inquireTypeName;

    private String statusName;

    /**
     * 医生姓名
     */
    @ApiModelProperty(value="医生姓名")
    private String doctorName;
    /**
     * 医生头像
     */
    @ApiModelProperty(value="医生头像")
    private String avatar;
    /**
     * 医生职称
     */
    @ApiModelProperty(value="医生职称")
    private String label;
    /**
     * 科室名称
     */
    @ApiModelProperty(value="科室名称")
    private String departmentName;
}
