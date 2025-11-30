package com.wyzy.hospital.patients.dto;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.entity.PatientsFamily;
import lombok.Data;
import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2021/4/14  11:09
 */
@Data
public class MedicalRecordDto extends MedicalRecord {

	private List<PatientsFamily> patientsFamilyList;

}
