package com.wyzy.hospital.admin.api.dto.doctor;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Administrator
 */
@ApiModel(value = "App医生筛选实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppDoctorDTO {

	/**
	 * 医生id
	 */
	@ApiModelProperty(value="医生id")
	private Long doctorId;

	/**
	 * 医生姓名
	 */
	@ApiModelProperty(value="医生姓名")
	private String doctorName;

	/**
	 * 医生科室id
	 */
	@ApiModelProperty(value="医生科室id")
	private Long departmentId;

	/**
	 * 医生科室
	 */
	@ApiModelProperty(value="医生科室")
	private String department;

	/**
	 * 医生职称id
	 */
	@ApiModelProperty(value="医生职称id")
	private Integer professionalTitleId;

	/**
	 * 医生职称
	 */
	@ApiModelProperty(value="医生职称")
	private String professionalTitle;

	/**
	 * 归属机构级别
	 */
	@ApiModelProperty(value="归属机构级别")
	private String organizationGrade;



	/**
	 * 医生服务
	 */
	@ApiModelProperty(value="医生服务")
	private List<DoctorServeDTO> doctorServe;

	/**
	 * 擅长
	 */
	@ApiModelProperty(value="擅长")
	private String adept;


	/**
	 * 服务人次
	 */
	@ApiModelProperty(value="服务人次")
	private Integer peopleNumber;

	/**
	 * 医生头像
	 */
	@ApiModelProperty(value="医生头像")
	private String headPictureUrl;
	/**
	 * 医生寄语
	 */
	@ApiModelProperty(value="医生寄语")
	private String wishes;

	/**
	 * 医生归属
	 */
	@ApiModelProperty(value = "医生归属")
	private List<DoctorAttribution> doctorAttribution;

	/**
	 * 价格
	 */
	@ApiModelProperty(value = "价格")
	private Double price;

	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
	private Double longitude;

	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度")
	private Double latitude;

	@ApiModelProperty(value="距离")
	private Double distance;

	public String getWishes() {
		return wishes;
	}

	public void setWishes(String wishes) {
		if(wishes==null){
			this.wishes = "";
		}
		this.wishes = wishes;
	}
}
