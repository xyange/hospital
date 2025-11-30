package com.wyzy.hospital.patients.dto;

import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.entity.PatientsFamily;
import lombok.Data;

import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2021/4/14  11:09
 */
@Data
public class PatientsFamilyDto extends PatientsFamily {

	private List<MedicalRecord> medicalRecordList;

	private List<Patients> patientsList;



}
