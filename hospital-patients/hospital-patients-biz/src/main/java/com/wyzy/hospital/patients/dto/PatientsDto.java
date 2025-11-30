package com.wyzy.hospital.patients.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.entity.Patients;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2021/4/14  11:09
 */
@Data
public class PatientsDto extends Patients {

	private List<MedicalRecord> medicalRecordList;



}
