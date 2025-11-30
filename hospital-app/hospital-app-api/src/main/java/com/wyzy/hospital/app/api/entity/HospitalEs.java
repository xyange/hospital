package com.wyzy.hospital.app.api.entity;

import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author aqie
 * Date on 2021/5/20  10:21
 * @Function: es 医院实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "hospital")
public class HospitalEs {
	@Id
	@ApiModelProperty(value="医院ID")
	private Long id;

	@Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
	@ApiModelProperty(value="医院名称")
	private String hospitalName;

	@ApiModelProperty(value="医院电话")
	private String hospitalTel;

	@Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
	@ApiModelProperty(value="挂号时间")
	private String registrationTime;

	@Field(type = FieldType.Keyword)
	@ApiModelProperty(value="挂号具体时间")
	private String registrationDate;

	@Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
	@ApiModelProperty(value="地址")
	private String address;

	@ApiModelProperty(value="医院等级 0-三级甲等 1-三级乙等")
	private String gradeFlag;

	@ApiModelProperty(value="线上医生数目")
	private Integer onlineDoctorNumber;

	public HospitalEs(AppHospitalVO vo){
		this.id= vo.getId();
		this.hospitalName = vo.getHospitalName();
		this.hospitalTel = vo.getHospitalTel();
		this.registrationDate = vo.getRegistrationDate();
		this.registrationTime = vo.getRegistrationTime();
		this.address = vo.getAddress();
		this.gradeFlag = vo.getGradeFlag();
		this.onlineDoctorNumber = vo.getOnlineDoctorNumber();
	}
}
