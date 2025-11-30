package com.wyzy.hospital.app.repository;

import com.wyzy.hospital.app.api.entity.HospitalEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author aqie
 * Date on 2021/5/19  11:43
 * @Function:
 */
public interface HospitalRepository extends ElasticsearchRepository<HospitalEs,Long> {
	/**
	 * 根据医院名称查询医院列表(去重)
	 * @param hospitalName
	 * @param pageable
	 * @return
	 */
	Page<HospitalEs> findDistinctByHospitalName(String hospitalName, Pageable pageable);

	/**
	 * 根据医院名称查询医院列表
	 * @param hospitalName
	 * @param pageable
	 * @return
	 */
	Page<HospitalEs> findByHospitalName(String hospitalName, Pageable pageable);

	Page<HospitalEs> findByHospitalNameAndRegistrationDate(String hospitalName, String registrationDate, Pageable pageable);

	// Page<HospitalEs> findByHospitalNameAndRegistrationDate(String hospitalName, String registrationDate, Pageable pageable);
}
