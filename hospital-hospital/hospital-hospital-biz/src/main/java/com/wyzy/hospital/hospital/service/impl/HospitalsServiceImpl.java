
package com.wyzy.hospital.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.hospital.dto.HospitalDTO;
import com.wyzy.hospital.hospital.entity.Hospitals;
import com.wyzy.hospital.hospital.mapper.HospitalsMapper;
import com.wyzy.hospital.hospital.service.HospitalsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-10 08:33:26
 */
@Service
public class HospitalsServiceImpl extends ServiceImpl<HospitalsMapper, Hospitals> implements HospitalsService {

	@Resource
	private HospitalsMapper hospitalsMapper;
	@Override
	public List<Hospitals> listHospitalsByName(String name) {
		return hospitalsMapper.listHospitalsByName(name);
	}

	@Override
	public List<HospitalDTO> listHospital() {
		return hospitalsMapper.listHospital();
	}
}
