

package com.wyzy.hospital.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.hospital.dto.HospitalDTO;
import com.wyzy.hospital.hospital.entity.Hospitals;

import java.util.List;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-10 08:33:26
 */
public interface HospitalsService extends IService<Hospitals> {
	/**
	 * 模糊查询医院
	 * @param name 医院名称
	 * @return R
	 */
	List<Hospitals> listHospitalsByName(String name);

	List<HospitalDTO> listHospital();

}
