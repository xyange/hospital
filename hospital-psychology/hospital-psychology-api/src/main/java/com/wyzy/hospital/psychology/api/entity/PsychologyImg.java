package com.wyzy.hospital.psychology.api.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 心理图片
 *
 * @author wrk
 * @date 2021/05/08 08:48
 **/
@ApiModel(value = "app心理图片")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsychologyImg {
	private Long id;
	private String imgUrl;
	private String hyperlinks;
	private String enable;
	private String imgName;
	private Integer imgType;
}
