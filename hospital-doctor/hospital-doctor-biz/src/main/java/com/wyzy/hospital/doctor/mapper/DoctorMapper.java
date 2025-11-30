

package com.wyzy.hospital.doctor.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.doctor.dto.DoctorDTO;
import com.wyzy.hospital.doctor.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-12 16:50:44
 */
@Mapper
public interface DoctorMapper extends HospitalBaseMapper<Doctor> {
	List<DoctorDTO> listAllDoctor(String doctorName,String disease,String hospital,String deportment,String area,String sortBy,String filterBy);

}
