package com.wyzy.hospital.app.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author aqie
 */
@Data
@NoArgsConstructor
public class ContentDTO {
	@ApiModelProperty(value="章节标题 ")
    private String label;

	@ApiModelProperty(value="章节地址 ")
    private  String text;

	@ApiModelProperty(value="上级id ")
    private Long pid;

	@ApiModelProperty(value="书名")
    private String fileName;


    List<ContentDTO> children;
}
